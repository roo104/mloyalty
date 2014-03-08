package dk.unwire.fym.mloyalty.dao;

import java.util.List;

import dk.unwire.fym.mloyalty.model.Point;

public interface PointDao {

	public List<Point> getByUser(long userId);
	
	public long getBalance(long userId);
	
	public void addPoints(Point point);
}
