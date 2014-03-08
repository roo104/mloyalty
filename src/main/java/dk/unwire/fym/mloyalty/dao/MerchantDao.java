package dk.unwire.fym.mloyalty.dao;

import dk.unwire.fym.mloyalty.model.Merchant;

public interface MerchantDao {

	public Merchant getMerchantByUsernameAndPassword(String username, String password);
}
