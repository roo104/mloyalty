package dk.unwire.fym.mloyalty.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dk.unwire.fym.mloyalty.dao.PointDao;
import dk.unwire.fym.mloyalty.model.Point;
import dk.unwire.fym.mloyalty.model.User;
import dk.unwire.fym.mloyalty.service.PointService;

@Stateless
public class PointServiceImpl implements PointService {

	@Inject
	private PointDao pointDao;
	
	@Override
	public void addPoints(long userId, long points) {
	}

}
