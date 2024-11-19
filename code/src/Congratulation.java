import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.*;


import javax.swing.*;
import javax.swing.Timer;

import java.awt.event.*;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Congratulation extends JFrame
{
	private JFrame sl;   // schermata di un livello precedente (livello 3).
	private CardViewer cv;  //CardViewer contenente l'immagine da visualizzare.
	private Importa_Audio audio;
	
	public Congratulation(JFrame sl, CardViewer cv,Importa_Audio audio)
	{
		this.sl=sl;
		this.cv=cv;
		this.audio=audio;
		
		
		
		// Crea schermata finale.
		
		JFrame end = new JFrame("Puzzle Art!");
		end.setSize(1013,750);
		end.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		end.setLocationRelativeTo(null);
		end.setVisible(true);
		end.setResizable(false);
		
		
		
		
		//crea label ospitante foto.
		JLabel end_label = new JLabel();
		String s="fireworks.jpg";
		Importa_Immagine im_im = new Importa_Immagine(s);
		Image frwrk = im_im.getImmagine(s);
		Icon fireworks = new ImageIcon(frwrk);
		end_label.setIcon(fireworks);
		
		//Impostiamo l'icona del frame.
		end.setIconImage(frwrk);
		
		
		// aggiungiamo la label al frame.
		end.add(end_label);
		
		audio.StopSound();
		Importa_Audio win =new Importa_Audio("AnthemOfVictory .WAV");
		win.PlaySound();
		win.RepeatInALoopSound();
		
		//Mostra messaggio e chiudi il gioco.
		JOptionPane.showMessageDialog(null, " CONGRATULATIONS!");
		System.exit(0);
		
	}
	
	public void closeW()  // chiude la schermata del livello precedente (livello 3).
	{
		this.sl.setVisible(false);
	}
	
	public void closeCardViewer()   // Chiude il CardViewer a livello terminato nel caso in cui esso rimane aperto.
	{
		if(this.cv.isShowing())
		{
			this.cv.setVisible(false);
		}
	}
}
