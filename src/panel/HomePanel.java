package panel;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class HomePanel extends JPanel{
    
    private JPanel titlePanel;
    private JPanel mainPanel;
	
    public HomePanel (){
	
        titlePanel = new JPanel();
        mainPanel = new JPanel(new GridLayout(1, 2, 0, 0));
    }

}
