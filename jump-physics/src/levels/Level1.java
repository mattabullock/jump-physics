package levels;

//import java.util.Collections;
import java.util.Random;

import demo.Camera;

//import comparators.BlockComparator;

import objects.Block;

public class Level1 {
	
	private Camera c;
	
	public Level1() {
		Random r = new Random();
		c = new Camera();
		for(int i = 0; i < 10000; i++) {
			c.add(new Block(500 * i + r.nextInt(400), 145, 50, 30));
		}
		c.add(new Block(0, 175, 1000, 45));
//		getCamera().add(new Block(500, 145, 50, 30));
//		getCamera().add(new Block(0, 145, 50, 30));
//		getCamera().add(new Block(900, 145, 50, 30));
//		getCamera().add(new Block(1300, 145, 50, 30));
//		Collections.sort(getCamera().getObjects(), new BlockComparator());
//		for(int i = 0; i < getCamera().getObjects().size(); i++) {
//			System.out.println("i: " + i + "| x coord: " + getCamera().getObjects().get(i).getR().x);
//		}
	}

	public Camera getCamera() {
		return c;
	}
}