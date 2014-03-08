package dk.unwire.fym.mloyalty.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class User implements Serializable	 {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@JsonIgnore
	@OneToOne
	private Merchant merchant;
	private String identifier;
	@Enumerated(EnumType.STRING)
	private IdentifierType identifierType;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public IdentifierType getIdentifierType() {
		return identifierType;
	}
	public void setIdentifierType(IdentifierType identifierType) {
		this.identifierType = identifierType;
	}
	
}
