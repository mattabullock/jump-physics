package objects;

import handlers.*;
import interfaces.CollidableObject;
import interfaces.Tracker;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;



public class Square implements Tracker, CollidableObject {
	
	MovementHandler mh;
	CollisionHandler ch;
	Image square;
	Rectangle r;

	public Square(double x, double y, double velX, double velY) {
		ImageIcon jj = new ImageIcon(this.getClass().getResource("/images/square.png"));
		square = jj.getImage();
		r = new Rectangle((int) x, (int) y, jj.getIconWidth(), jj.getIconHeight());
		ch = new CollisionHandler(this);
		mh = new MovementHandler(x,y,velX,velY,.5,false,false,false, this);
	}
	
	public Image getImage() {
		return square;
	}

	public MovementHandler getMh() {
		return mh;
	}

	public double getX() {
		return mh.getPositionX();
	}
	
	public double getY() {
		return mh.getPositionY();
	}
	
	public double getScreenPositionX() {
		return mh.getScreenPositionX();
	}
	
	public double getScreenPositionY() {
		return mh.getScreenPositionY();
	}
	
	public double getVelX() {
		return mh.getVelocityX();
	}
	
	public double getVelY() {
		return mh.getVelocityY();
	}
	
	public boolean isOnGround() {
		return mh.isOnGround();
	}

	public boolean isMovingRight() {
		return mh.isMovingRight();
	}

	public boolean isMovingLeft() {
		return mh.isMovingLeft();
	}

	public Rectangle getR() {
		return r;
	}

	public CollisionHandler getCH() {
		return ch;
	}
}