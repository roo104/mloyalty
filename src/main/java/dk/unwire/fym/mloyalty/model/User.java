package dk.unwire.fym.mloyalty.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	private long balance;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	@Fetch(FetchMode.SELECT)
	private List<Point> points;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	@Fetch(FetchMode.SELECT)
	private List<Redemption> redemptions;
	
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
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public List<Point> getPoints() {
		return points;
	}
	public void setPoints(List<Point> points) {
		this.points = points;
	}
	public List<Redemption> getRedemptions() {
		return redemptions;
	}
	public void setRedemptions(List<Redemption> redemptions) {
		this.redemptions = redemptions;
	}
	
}
