package objects;

import interfaces.LevelObject;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Block implements LevelObject{
	
	private Rectangle r;
	Image block;
	
	public Block(int x, int y, int width, int height) {
		r = new Rectangle(x, y, width, height);
		ImageIcon jj = new ImageIcon(this.getClass().getResource("/images/block.png"));
		block = jj.getImage();
	}

	public Image getImage() {
		return block;
	}

	public Rectangle getR() {
		return r;
	}
}