package dk.unwire.fym.mloyalty.model.json;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

/**
 * This class will make sure Json timestamps is written in the format yyyy-mm-dd'T'hh:MM:ss'Z' 
 * @author Jonas Pedersen
 *
 */

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonConfig implements ContextResolver<ObjectMapper> {

	private final ObjectMapper objectMapper;

	public JacksonConfig() {
		objectMapper = new ObjectMapper();
		objectMapper.configure(
				SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
	}

	@Override
	public ObjectMapper getContext(Class<?> objectType)	{
		return objectMapper;
	}

}