import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.io.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.sql.Timestamp;

public class PuzzleArt 
{

	
	
	
	
	
	public static void main(String[] args)
	{
		//Creiamo la schermata play.
		JFrame schermata_play=new JFrame("Puzzle Art!");
		schermata_play.setSize(1000, 610);
		schermata_play.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		schermata_play.setVisible(true);
		schermata_play.setLocationRelativeTo(null);
		schermata_play.setResizable(false);
		
		//Imposta icona programma.
				
				String s="icona.jpg"; //la stringa s contiene il nome.formato dell'immagine.
				Importa_Immagine i_i = new Importa_Immagine(s); // l'immagine viene importata grazie alla classe Importa_Immagine.
				Image icon = i_i.getImmagine(s);// il metodo getImmagine() della classe Importa_Immagine restituisce l'immagine che si deidera importare.
				schermata_play.setIconImage(icon);
		
				//Imposta label di sfondo.
				s="schermata_play.jpg";
				Image bckgrnd = i_i.getImmagine(s);
				Icon bckgrnd2=new ImageIcon(bckgrnd);    // Converte oggetto di tipo ImageIcon in un oggetto di tipo Icon
				
				JLabel sfondo=new JLabel();
				sfondo.setIcon(bckgrnd2);
		
				//Imposta il pannello di background.
			JPanel background_panel=new JPanel();
				schermata_play.add(background_panel);
				
				//impostiamo il bottone PLAY
				JButton play_button=new JButton("PLAY!");
				play_button.setToolTipText("Press this button to play.");
		
				
				// aggiunge la labelcontenente l'immagine di sfondo e il bottone play al pannello di background.
				
				
				background_panel.add(sfondo);
				background_panel.validate();
				background_panel.add(play_button);
				
				//imposta il layout.
				background_panel.setLayout(null);
				background_panel.setBounds(0, 0, 1000,800);
				sfondo.setBounds(0, 0, 1000, 550);
				play_button.setBounds(300,550, 200, 30);

				//Creiamo bottone tutorial.
				JButton tutorial = new JButton("TUTORIAL");
				tutorial.setToolTipText("press this button for your tutorial!");
				tutorial.setBounds(500,550, 200, 30);
				//Aggiungiamo il bottone al pannello principale.
				background_panel.add(tutorial);
			
				
				
				//Add Music
				Importa_Audio theme = new Importa_Audio("PuzzleArt_theme.WAV");
				theme.PlaySound();
				theme.RepeatInALoopSound();
				
				
		// crea l'azione di inizio gioco con l'azione PressPlayAction per il bottone play.
		PressPlayAction play_action = new PressPlayAction(schermata_play,theme);
		
		
		// imposta l'azione di inizio gioco per il bottone play.
		play_button.addActionListener(play_action);
		
		
		
		//Creiamo l'azione del bottone tutorial;
		TutorialAction tut_action= new TutorialAction();
		
		// Associamo al bottone tutorial l'azione TutorialAction.
		
		tutorial.addActionListener(tut_action);
		
		
	
		
		
		
		
		
		
		
		
		
		

	}

}
