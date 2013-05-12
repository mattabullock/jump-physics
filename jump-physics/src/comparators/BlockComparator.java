package comparators;

import java.util.Comparator;

import objects.Block;

public class BlockComparator implements Comparator<Block> {

	@Override
	public int compare(Block o1, Block o2) {
		if(o1.getR().x < o2.getR().x) {
			return -1;
		}
		else if(o1.getR().x > o2.getR().x) {
			return 1;
		}
		else {
			return 0;
		}
	}

}