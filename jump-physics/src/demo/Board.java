package demo;
import handlers.CameraMovementHandler;
import interfaces.LevelObject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import levels.Level1;

import objects.Square;


@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener{
	
	
	Image background;
	Square b;
	Level1 level;
	private static int points;
	CameraMovementHandler c;
	
	public Board() {
		setPoints(0);
		addKeyListener(new TAdapter());
		setFocusable(true);
		level = new Level1();
		b = new Square(400, 155, 0, 0);
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/images/background.png"));
		background = ii.getImage();
		c = new CameraMovementHandler(b, 0, 0);
		new Timer(10, this).start();
    }
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(background, 0, 0, this);
		g2d.drawString("Jumps: " + getPoints(), 0, 60);
		g2d.drawString("PositionX: " + c.getTrackedX(), 0, 20);
		g2d.drawString("ScreenPositionX: " + c.getScreenX(), 0, 40);
		g2d.drawImage(b.getImage(), (int) b.getScreenPositionX(), (int) b.getScreenPositionY(), this);
		level.getCamera().clearBoard();
		for(LevelObject lo : level.getCamera().objects) {
			if(lo.getR().x <= c.getScreenX() + 600 && lo.getR().x + lo.getR().width >= c.getScreenX()) {
				level.getCamera().addToBoard(lo);
			}
		}
		for(LevelObject lo : level.getCamera().onBoard) {
			g2d.drawImage(lo.getImage(), (int) (lo.getR().x - c.getScreenX()), (int) (lo.getR().y - c.getScreenY()), this);
		}
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	
	
	
	private class TAdapter extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				b.getMh().endJump();
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				b.getMh().endMoveRight();
			}
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				b.getMh().endMoveLeft();
			}
		}
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				b.getMh().startJump();
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				b.getMh().moveRight();
			}
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				b.getMh().moveLeft();
			}
		}
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		b.getMh().move();
		c.react();
		repaint();
//		for(LevelObject lo : level.getCamera().onBoard) {
//			b.getCH().checkIntersection(lo.getR());
//		}
	}

	public static int getPoints() {
		return points;
	}

	public static void setPoints(int points) {
		Board.points = points;
	}
}