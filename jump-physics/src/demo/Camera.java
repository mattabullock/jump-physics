package demo;

import interfaces.LevelObject;

import java.util.ArrayList;

public class Camera {
	
	ArrayList<LevelObject> objects;
	ArrayList<LevelObject> onBoard;
	int beginOnBoard;
	
	public Camera() {
		objects = new ArrayList<LevelObject>();
		onBoard = new ArrayList<LevelObject>();
	}
	
	public void add(LevelObject o) {
		objects.add(o);
	}
	
	public void addToBoard(LevelObject b) {
		onBoard.add(b);
	}
	
	public void clearBoard() {
		onBoard.clear();
	}
	
	public ArrayList<LevelObject> getObjects() {
		return objects;
	}
	
	public void moveRight() {
		for(LevelObject o : objects) {
			o.getR().x += 6;
		}
	}
	
	public void moveLeft() {
		for(LevelObject o : objects) {
			o.getR().x -= 6;
		}
	}
	
//	public void move(double velocity) {
//		for(Block o : objects) {
//			o.getR().x -= velocity;
//		}
//	}
}