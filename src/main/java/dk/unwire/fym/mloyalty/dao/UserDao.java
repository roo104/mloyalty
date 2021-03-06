package dk.unwire.fym.mloyalty.dao;

import dk.unwire.fym.mloyalty.model.User;

public interface UserDao {

	public User getUserById(long userId);
	
	public long getBalance(long userId);
	
	public User getUserByIdentifierAndPassword(String identifier, String password);
}
