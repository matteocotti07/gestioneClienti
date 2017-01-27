package frame;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	public MainFrame(String title) {
		setTitle(title);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
