package handlers;

import java.awt.Rectangle;

import interfaces.CollidableObject;
import demo.Board;

public class MovementHandler {
	private double screenPositionX;
	protected double screenPositionY;
	double positionX, positionY;
	double velocityX, velocityY;
	double gravity;
	boolean onGround, movingRight, movingLeft;
	CollidableObject co;
	CollisionHandler ch;
	Rectangle r;
	
	final double SCREEN_WIDTH = 600;
	
	public MovementHandler(double posX, double posY, double velX, double velY, 
			double grav, boolean ground, boolean right, boolean left, CollidableObject co) {
		positionX = posX;
		positionY = posY;
		screenPositionX = posX;
		setScreenPositionY(posY);
		velocityX = velX;
		velocityY = velY;
		gravity = 0.5;
		onGround = false;
		movingRight = false;
		movingLeft = false;
		this.co = co;
		this.ch = co.getCH();
		r = co.getR();
	}
	
	public void move() {
		//boost to overcome the jitter thing
//		if(velocityX == 0) {
			if(movingRight) {
				velocityX = 6;
			} 
			else if(movingLeft) {
				velocityX = -6;
			}
			else {
				velocityX = 0;
			}
//		}
		
		System.out.println("onGround: " + onGround);
//		if(!onGround) {
			velocityY += gravity;
//		}
			
			
			
//		//deceleration
//		if(!movingLeft && !movingRight && onGround && velocityX > 0) {
//			velocityX -= .6;
//		}
//		else if(!movingLeft && !movingRight && onGround && velocityX < 0) {
//			velocityX += .6;
//		}
//		if(velocityX <= .6) {
//			velocityX = 0;
//		}
//		//acceleration
//		if(onGround && velocityX < 6 && movingRight) {
//			velocityX += .6;
//		}
//		else if(onGround && velocityX > -6 && movingLeft) {
//			velocityX -= .6;
//		}
//			//not sure
//			else if(onGround && (velocityX > 0 && !movingRight || velocityX < 0 && !movingLeft)) {
//				velocityX = 0;
//			}
//		//horizontal deceleration in the air
//		else if(!onGround) {
//			if(velocityX > 0 && !movingRight) {
//				velocityX -= .1;
//			}
//			else if(velocityX < 0 && !movingLeft) {
//				velocityX += .1;
//			}
//		}
			
		
//        //changing direction in air
//		if(!onGround && velocityX < 0 && movingRight) {
//        	velocityX += 0.1;
//        }
//        else if(!onGround && velocityX >= 0 && velocityX <= 6 && movingRight) {
//        	velocityX += 0.1;
//        }
//        else if(!onGround && velocityX > 0 && movingLeft) {
//        	velocityX -= 0.1;
//        }
//        else if(!onGround && velocityX <= 0 && velocityX >= -6 && movingLeft) {
//        	velocityX -= 0.1;
//        }
		
		setScreenPositionX(getScreenPositionX() + velocityX);
		setScreenPositionY(getScreenPositionY() + velocityY);
        positionY += velocityY;
        positionX += velocityX;
        r.setLocation((int) positionX, (int) positionY);
        
        if(positionY > 155.0) {
//        	System.out.println(ch.hitTop);
			positionY = 155.0;
        	screenPositionY = 155.0;
            velocityY = 0.0;
            onGround = true;
        }
        else {
        	onGround = false;
        }
        
        if(screenPositionX < SCREEN_WIDTH / 3) {
        	screenPositionX = SCREEN_WIDTH / 3;
        }
        else if(screenPositionX > SCREEN_WIDTH * 2 / 3 - 20) {
        	screenPositionX = SCREEN_WIDTH * 2 / 3 - 20;
        }
        
        if(positionY > 200) {
        	System.exit(-1);
        }
        
	}
	
	public void startJump() {
		if(onGround) {
			Board.setPoints(Board.getPoints() + 1);
			velocityY = -12.0;
			onGround = false;
		}
	}
	
	public void endJump() {
	    if(velocityY < -6.0) {
	        velocityY = -6.0;
	    }
	}
	
	public void moveRight() {
		if(!movingRight) {
			movingRight = true;
		}
	}
	
	public void endMoveRight() {
		if(movingRight) {
			movingRight = false;
		}
	}
	
	public void moveLeft() {
		if(!movingLeft) {
			movingLeft = true;
		}
	}
	
	public void endMoveLeft() {
		if(movingLeft) {
			movingLeft = false;
		}
	}
	
	public double getPositionX() {
		return positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public double getVelocityX() {
		return velocityX;
	}

	public double getVelocityY() {
		return velocityY;
	}

	public boolean isOnGround() {
		return onGround;
	}

	public boolean isMovingRight() {
		return movingRight;
	}

	public boolean isMovingLeft() {
		return movingLeft;
	}

	public double getScreenPositionX() {
		return screenPositionX;
	}

	public void setScreenPositionX(double screenPositionX) {
		this.screenPositionX = screenPositionX;
	}

	public double getScreenPositionY() {
		return screenPositionY;
	}

	public void setScreenPositionY(double screenPositionY) {
		this.screenPositionY = screenPositionY;
	}
}