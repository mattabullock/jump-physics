package handlers;

import interfaces.CollidableObject;

import java.awt.Rectangle;

public class CollisionHandler {

	boolean hitTop, hitBot, hitLeft, hitRight;
	Rectangle r1;
	
	public CollisionHandler(CollidableObject co) {
		hitTop = true;
		hitBot = false;
		hitLeft = false;
		hitRight = false;
		r1 = co.getR();
	}
	
	public void checkIntersection(Rectangle r2) {
		hitTop = false;
		hitRight = false;
		hitLeft = false;
		hitBot = false;
		if(r1.x == r2.x + r2.width + 1
				&& r1.y <= r2.y + r2.height
				&& r1.y + r1.height >= r2.y) {
			//right collision
			hitRight = true;
		}
		if(r2.x == r1.x + r1.width - 1
				&& r2.y <= r1.y + r1.height
				&& r2.y + r2.height >= r1.y) {
			//left collision
			hitLeft = true;
		} 
		if(r1.y == r2.y + r2.height - 1
				&& r2.x <= r1.x + r1.width
				&& r2.x + r2.width >= r1.x) {
			//bot collision
			hitBot = true;
		}
		if(r2.y - 1 <= r1.y + r1.height
				//&& r2.y + 2 >= r1.y + r1.height
				&& r1.x <= r2.x + r2.width
				&& r1.x + r1.width >= r2.x) {
			//top collision
			hitTop = true;
		}
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(hitTop);
	}	
}