import java.awt.event.ActionListener;
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

public class TutorialAction implements ActionListener
{
	
	private int i=0;  // inutile al frame , serve sl per inizializzare e cstruire un oggetto di tipo TutorialAction.
	public TutorialAction()
	{
		this.i=0;
	}
	public void actionPerformed (ActionEvent e)
	{
		//crea il frame
		JFrame tutorial_frame = new JFrame ("Tutorial");
		tutorial_frame.setSize(2000, 1200);
		tutorial_frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		tutorial_frame.setVisible(true);
		tutorial_frame.setLocationRelativeTo(null);
		tutorial_frame.setLayout(null);
		
		// Inseriamo la prima immagine del tutorial in una label
		String s="tutorial_1.jpg";
		Importa_Immagine im_im=new Importa_Immagine(s);
		Image tutorial_img = im_im.getImmagine(s);
		Icon tutorial_1 = new ImageIcon(tutorial_img);
		
		// impostiamo il testo del tutorial e le label che ospiteranno tale testo.
		String text1="BENVENUTI A PUZZLE ART! ";
		
		String text2="\n\nIn questo tutorial vi mostreremo come giocare a PUZZLE ART!\n\nGiocare e' semplicissimo! Lo scopo del gioco e' quello di ricostruire il puzzle di immagini che vi proponiamo ";
		String text3="in ogni livello.\n\nBasta prendere un pezzo dell'immagine situato alla destra dello schermo e trascinarlo con il mouse  nella griglia (a sinistra dello schermo)."; 
		String text4="Se il pezzetto di immagine sara' inserito nella giusta sezione della griglia acquisterete dei punti che vi permetteranno di accedere ai livelli successivi.";
		
		JLabel tutorial_label_1= new JLabel(text1);
		
		tutorial_label_1.setBounds(650, 5, 300, 30);
		
		JLabel tutorial_label_2=new JLabel(text2);
		tutorial_label_2.setBounds(400, 50, 1000, 20);
		

		JLabel tutorial_label_3=new JLabel(text3);
		tutorial_label_3.setBounds(400, 70, 1000, 20);
		

		JLabel tutorial_label_4=new JLabel(text4);
		tutorial_label_4.setBounds(400, 90, 1000, 20);
		

		JLabel tutorial_label_5=new JLabel();
		tutorial_label_5.setIcon(tutorial_1);
		tutorial_label_5.setBounds(10, 70, 350, 214);
		
		String text6="Ogni livello e' un livello a tempo, entro il quale si deve riscostruire l'immagine. Il timer sullo schermo mostra il tempo rimanente. ";
		String text7="Se si riesce a ricostruire l'immagine prima dello scadere del tempo si accede al livello succesivo, altrimenti \"GAME OVER\"!";
		
		JLabel tutorial_label_6=new JLabel(text6);
		tutorial_label_6.setBounds(400, 130, 1000, 20);
		JLabel tutorial_label_7=new JLabel(text7);
		tutorial_label_7.setBounds(400, 150, 1000, 20);
		
		s="tutorial_333.jpg";  // aggiungiamo una nuova immagine al frame tutorial tramite la classe Importa_immagine. la stringa s contiene ilnome.formato della foto da importare.
		Image img3= im_im.getImmagine(s); //il metodo getImmagine(s) della classe Importa_Immagine restituisce l'immagine desiderata.
		Icon img33= new ImageIcon(img3);
		
		JLabel tutorial_label_8= new JLabel();
		tutorial_label_8.setIcon(img33);
		tutorial_label_8.setBounds(1050, 170, 300, 150);
		
		String text9="Se hai necessita' di visualizzare la foto dell'immagine da ricostruire , puoi cliccare su \" VIEW IMAGE\".";
		String text10="Cosa stai aspettando? Chiudi questa finestra, premi play e inizia a giocare!";
		String text11="BUON DIVERTIMENTO!";
		

		JLabel tutorial_label_9=new JLabel(text9);
		tutorial_label_9.setBounds(400, 210, 700, 20);
		
		s="tutorial_222.jpg"; // aggiungiamo una nuova immagine al tutorial tramite la classe Importa_Immagine.
		Image img2= im_im.getImmagine(s);
		Icon img22 = new ImageIcon(img2);
		
		JLabel tutorial_label_12=new JLabel();
		tutorial_label_12.setIcon(img22);
		tutorial_label_12.setBounds(500, 250, 450, 225);
		
		
		JLabel tutorial_label_10=new JLabel(text10);
		tutorial_label_10.setBounds(500, 500, 700, 20);
		JLabel tutorial_label_11=new JLabel(text11);
		tutorial_label_11.setBounds(650, 570, 700, 20);
		
		String credits1="\"CREDITS\" .Progetto sviluppato da Federico March e Isabel Toro Sima, per STM";
		String credits2=" All Rights Reserved ©";
		
		JLabel credits_1=new JLabel(credits1);
		credits_1.setBounds(900, 650, 600, 30);
		JLabel credits_2=new JLabel(credits2);
		credits_2.setBounds(900, 670, 600, 20);
		// aggiungiamo il tutto al frame.
		tutorial_frame.add(tutorial_label_1);
		tutorial_frame.add(tutorial_label_2);
		tutorial_frame.add(tutorial_label_3);
		tutorial_frame.add(tutorial_label_4);
		tutorial_frame.add(tutorial_label_5);
		tutorial_frame.add(tutorial_label_6);
		tutorial_frame.add(tutorial_label_7);
		tutorial_frame.add(tutorial_label_8);
		tutorial_frame.add(tutorial_label_9);
		tutorial_frame.add(tutorial_label_10);
		tutorial_frame.add(tutorial_label_11);
		tutorial_frame.add(tutorial_label_12);
		tutorial_frame.add(credits_1);
		tutorial_frame.add(credits_2);
		
		
		
		
		
		
		
		
	}
}
