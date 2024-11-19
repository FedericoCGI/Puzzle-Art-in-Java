import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;
import java.sql.Timestamp;

public class CardViewer extends JFrame      
{
	
	
	private JLabel photo_label;
	private Image icon;
	
	public CardViewer(String title, JLabel label, Image icon) //default Constructor
	{
		super(title);
		// creo un icona
		this.icon=icon;
		setIconImage(this.icon);
		//  aggiungo una JLabel con lo sfondo di un immagine.
		
		
		this.photo_label=label;
		add(this.photo_label);
		
		
	
		
		
	}
}