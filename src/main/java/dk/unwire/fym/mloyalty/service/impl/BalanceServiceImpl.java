package dk.unwire.fym.mloyalty.service.impl;

import javax.inject.Inject;

import dk.unwire.fym.mloyalty.dao.PointDao;
import dk.unwire.fym.mloyalty.dao.UserDao;
import dk.unwire.fym.mloyalty.model.Balance;
import dk.unwire.fym.mloyalty.service.BalanceService;

public class BalanceServiceImpl implements BalanceService {
	
	@Inject
	private PointDao pointDao;
	@Inject
	private UserDao userDao;

	@Override
	public Balance getPointBalance(long userId) {
		Balance balance = new Balance();
		balance.setBalance(pointDao.getBalance(userId));
		balance.setUser(userDao.getUserById(userId));
		return balance;
	}

}
