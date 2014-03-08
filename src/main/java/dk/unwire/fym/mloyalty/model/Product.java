package dk.unwire.fym.mloyalty.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private Merchant merchant;
	private String name;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
