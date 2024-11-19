import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;
import java.sql.Timestamp;


public class Cronometro  extends Frame implements ActionListener
{
	
	private int minute;
	private int second;
	private int secondCent;
	private JLabel timer_screen;
	
	private String msg=" ";
	private JPanel screen;
	private JPanel main_panel;
	
	
	
	public Cronometro(int minute,int second, JPanel mp )
	{
		
		this.minute=minute;
		this.second=second;
		this.secondCent=0;
		
		// crea la label di testo che mostrera il tempo rimasto.
		this.timer_screen= new JLabel(msg);
		this.screen = new JPanel();
		this.main_panel=mp;
		
		
		
		
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		// imposta l'aggiornamento del tempo.  (i minuti e i secondi vengono decrementati.
		if (this.second==0)
		{
			this.second=59;
			this.minute=this.minute-1;
			
		}
		this.secondCent=this.secondCent-25;
		if (this.secondCent==-100)
		{
			this.secondCent=0;
			this.second=this.second-1;
			if (this.second==-1)
			{
				this.second=59;
				this.minute=this.minute-1;
				
			}
		}
		
		
		
		// imposta la label di testo.
		if (this.minute<10)
		{
			if (this.second<10)
			{
				this.msg="0"+this.minute+" : 0"+(this.second);
			}
			else
			{
				this.msg="0"+this.minute+" : "+(this.second);
			}
		}
		else
		{
			if (this.second<10)
			{
				this.msg=""+this.minute+" : 0"+(this.second);
			}
			else
			{
				this.msg=""+this.minute+" : "+(this.second);
			}
		}
		
		this.timer_screen.setText(msg);  //Stampa sulla schermata di gioco il timer.
		
		
		// aggiungi la label allo screen e aggiungi lo screen al pannello principale.
		this.screen.setBackground(Color.WHITE);
		this.screen.add(this.timer_screen);
		this.screen.validate();
		this.main_panel.add(screen);
		this.main_panel.validate();
		
		
		if (this.minute==0 && this.second==0)   // imposta la chiusura del programma allo scadere del tempo prestabilito.
		{
			
			Importa_Audio gong = new Importa_Audio("Gong.WAV");
			gong.PlaySound();
			
			JOptionPane.showMessageDialog(null, "            GAME OVER!");
			System.exit(0);
			
		}
		
		
		
	}
	
	public int getMinute()
	{
		return this.minute;
	}
	public int getSecond()
	{
		return this.second;
	}
	public JPanel getScreen()
	{
		return this.screen;
	}
}