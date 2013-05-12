package demo;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main extends JFrame {
	public Main() {
		add(new Board());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    setSize(616,236);
	    setLocationRelativeTo(null);
	    setTitle("Jump Demo");
	    setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}
}