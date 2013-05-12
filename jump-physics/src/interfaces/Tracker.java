package interfaces;

import handlers.MovementHandler;

public interface Tracker {
	public double getScreenPositionX();
	public double getScreenPositionY();
	public double getX();
	public double getY();
	public boolean isMovingRight();
	public boolean isMovingLeft();
	public MovementHandler getMh();
}