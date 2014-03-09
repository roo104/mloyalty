package dk.unwire.fym.mloyalty.service;

import dk.unwire.fym.mloyalty.model.Balance;

public interface BalanceService {

	public Balance getUserBalance(long userId);
}
