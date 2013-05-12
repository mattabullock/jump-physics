package interfaces;

import handlers.CollisionHandler;

import java.awt.Rectangle;

public interface CollidableObject {
	public Rectangle getR();
	public CollisionHandler getCH();
}
