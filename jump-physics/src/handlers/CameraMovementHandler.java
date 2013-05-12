package handlers;

import interfaces.Tracker;

public class CameraMovementHandler {
	
	public double trackedX;
	double trackedY;
	public double screenX;
	double screenY;
	Tracker t;
	
	final double MAX_SPEED = 6.0;
	final double SCREEN_WIDTH = 600;
	
	public CameraMovementHandler(Tracker t, double screenX, double screenY) {
		this.t = t;
		trackedX = t.getScreenPositionX();
		trackedY = t.getScreenPositionY();
		this.screenX = screenX;
		this.screenY = screenY;
	}
	
	public void updateTracker() {
		trackedX = t.getScreenPositionX();
		trackedY = t.getScreenPositionY();
	}
	
	public double getTrackedX() {
		return trackedX;
	}

	public void setTrackedX(double trackedX) {
		this.trackedX = trackedX;
	}

	public double getTrackedY() {
		return trackedY;
	}

	public void setTrackedY(double trackedY) {
		this.trackedY = trackedY;
	}

	public double getScreenX() {
		return screenX;
	}

	public void setScreenX(double screenX) {
		this.screenX = screenX;
	}

	public double getScreenY() {
		return screenY;
	}

	public void setScreenY(double screenY) {
		this.screenY = screenY;
	}

	public void react() {
		updateTracker();
		if(trackedX <= SCREEN_WIDTH / 3 && t.isMovingLeft()) {
			screenX -= MAX_SPEED;
		}
		else if(trackedX >= SCREEN_WIDTH * 2 / 3 - 20 && t.isMovingRight()) {
			screenX += MAX_SPEED;
		}
	}
}