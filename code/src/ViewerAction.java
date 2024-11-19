import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;
import java.sql.Timestamp;

public class ViewerAction implements ActionListener 
{
	private CardViewer viewer;
	
	public ViewerAction(CardViewer clv) // default Constructor
	{
		this.viewer=clv;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		setViewer(this.viewer);
		this.viewer.setVisible(true);
		this.viewer.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	public void setViewer(CardViewer clv)
	{
		this.viewer=clv;
	}
	
}
