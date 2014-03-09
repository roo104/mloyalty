package dk.unwire.fym.mloyalty.rest.security;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethodInvoker;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.util.Base64;
import org.jboss.resteasy.util.HttpResponseCodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.unwire.fym.mloyalty.dao.MerchantDao;
import dk.unwire.fym.mloyalty.dao.UserDao;
import dk.unwire.fym.mloyalty.model.Merchant;
import dk.unwire.fym.mloyalty.model.User;

@Provider
public class SecurityInterceptor implements ContainerRequestFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityInterceptor.class);

	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static final String AUTHENTICATION_SCHEME = "Basic";
	private static final ServerResponse ACCESS_DENIED = new ServerResponse("Access denied for this resource",
			HttpResponseCodes.SC_UNAUTHORIZED, new Headers<Object>());
	private static final ServerResponse SERVER_ERROR = new ServerResponse("INTERNAL SERVER ERROR",
			HttpResponseCodes.SC_INTERNAL_SERVER_ERROR, new Headers<Object>());;

	@Inject
	private MerchantDao merchantDao;
	@Inject
	private UserDao userDao;

	@Override
	public void filter(ContainerRequestContext containerRequestContext) throws IOException {
		ResourceMethodInvoker methodInvoker = (ResourceMethodInvoker) containerRequestContext
				.getProperty("org.jboss.resteasy.core.ResourceMethodInvoker");
		Method method = methodInvoker.getMethod();

		if (!method.isAnnotationPresent(PermitAll.class)) {

			final MultivaluedMap<String, String> headers = containerRequestContext.getHeaders();

			// Fetch authorization header
			final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);

			// If no authorization information present; block access
			if (authorization == null || authorization.isEmpty()) {
				containerRequestContext.abortWith(ACCESS_DENIED);
				return;
			}

			// Get encoded username and password
			final String encodedUserPassword = authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");

			// Decode username and password
			String usernameAndPassword = null;
			try {
				usernameAndPassword = new String(Base64.decode(encodedUserPassword));
			} catch (IOException e) {
				containerRequestContext.abortWith(SERVER_ERROR);
				return;
			}

			// Split username and password tokens
			final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
			final String username = tokenizer.nextToken();
			final String password = tokenizer.nextToken();

			LOGGER.debug("Username [{}] and password [{}]", username, password);

			// Verify user access
			if (method.isAnnotationPresent(RolesAllowed.class)) {
				RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
				Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));

				// Is user valid?
				if (!isUserAllowed(username, password, rolesSet)) {
					containerRequestContext.abortWith(ACCESS_DENIED);
					return;
				}
			}
		}
	}

	private boolean isUserAllowed(final String username, final String password, final Set<String> rolesSet) {
		boolean isAllowed = false;

		String role = rolesSet.iterator().next();
		if (Roles.END_USER.equals(role)) {
			User user = userDao.getUserByIdentifierAndPassword(username, password);
			
			if (user != null) {
				isAllowed = true;
			}
		} else if (Roles.MERCHANT.equals(role)) {
			Merchant merchant = this.merchantDao.getMerchantByUsernameAndPassword(username, password);

			if (merchant != null) {
				isAllowed = true;
			}
		}

		return isAllowed;
	}

}
