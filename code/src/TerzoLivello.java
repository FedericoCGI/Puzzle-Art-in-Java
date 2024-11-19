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


public class TerzoLivello extends JFrame
{
	
	private JFrame sl; // schermata livello precedente (livello 2)
	private CardViewer cv;  //CardViewer contenente l'immagine da visualizzare.
	private Importa_Audio audio;
	
	public TerzoLivello(JFrame sl, CardViewer cv,Importa_Audio audio)
	{
		this.sl=sl;
		this.cv=cv;
		this.audio=audio;
		
		sl.setVisible(false);
		
		
		// Creiamo la griglia "scheletro" .
		GrigliaFotoComponent griglia_scheletro = new GrigliaFotoComponent(10,100,160,130,4,4);  // sposta la griglia dal contorno nero. vengono impostate le dimensioni e le coordinate x e y del primo rettangolo della griglia 4x4.
		
		
		// costruiamo 4 rettangoli che ospiteranno la griglia
		Rectangle2D.Double griglia_rect1=griglia_scheletro.getGriglia()[0][0];//griglia_rect1 è il rettangolo situato alla posizione 0,o all'interno della matrice(griglia)griglia_scheletro
		Rectangle2D.Double griglia_rect2=griglia_scheletro.getGriglia()[0][1];
		Rectangle2D.Double griglia_rect3=griglia_scheletro.getGriglia()[0][2];
		Rectangle2D.Double griglia_rect4=griglia_scheletro.getGriglia()[0][3];
		Rectangle2D.Double griglia_rect5=griglia_scheletro.getGriglia()[1][0];
		Rectangle2D.Double griglia_rect6=griglia_scheletro.getGriglia()[1][1];
		Rectangle2D.Double griglia_rect7=griglia_scheletro.getGriglia()[1][2];
		Rectangle2D.Double griglia_rect8=griglia_scheletro.getGriglia()[1][3];
		Rectangle2D.Double griglia_rect9=griglia_scheletro.getGriglia()[2][0];
		Rectangle2D.Double griglia_rect10=griglia_scheletro.getGriglia()[2][1];
		Rectangle2D.Double griglia_rect11=griglia_scheletro.getGriglia()[2][2];
		Rectangle2D.Double griglia_rect12=griglia_scheletro.getGriglia()[2][3];
		Rectangle2D.Double griglia_rect13=griglia_scheletro.getGriglia()[3][0];
		Rectangle2D.Double griglia_rect14=griglia_scheletro.getGriglia()[3][1];
		Rectangle2D.Double griglia_rect15=griglia_scheletro.getGriglia()[3][2];
		Rectangle2D.Double griglia_rect16=griglia_scheletro.getGriglia()[3][3];
		
		
		// Creiamo un array di rettangoli che contenga i rettangoli costituenti la griglia scheletro.
		Rectangle2D.Double[] griglia_array= { griglia_rect1, griglia_rect2, griglia_rect3, griglia_rect4, griglia_rect5, griglia_rect6, griglia_rect7, griglia_rect8,griglia_rect9,
				 griglia_rect10, griglia_rect11, griglia_rect12, griglia_rect13, griglia_rect14, griglia_rect15, griglia_rect16};
		
		//creiamo la griglia che andra' a contenere le immagini.
		GrigliaFotoComponent griglia_immagini = new GrigliaFotoComponent(700,100,150,120,4,4); // vengono impostate le dimensioni e le coordinate x e y del primo rettangolo della griglia 4x4.
		// Creiamo i rettangoli che andranno a contenere le immegini.
		Rectangle2D.Double photo_rect1, photo_rect2, photo_rect3, photo_rect4, photo_rect5, photo_rect6, photo_rect7, photo_rect8,photo_rect9,
		photo_rect10, photo_rect11, photo_rect12, photo_rect13, photo_rect14, photo_rect15, photo_rect16;


		// Assegnamo posizione e dimensioni a questi rettangoli, prendendo le posizioni gia preimpostate nella griglia creata.
		photo_rect1=griglia_immagini.getGriglia()[0][0]; // tale rettangolo che conterra' l'immagine e' il rpimo elemento alla posizione 0,0 della griglia.
		photo_rect2=griglia_immagini.getGriglia()[0][1];
		photo_rect3=griglia_immagini.getGriglia()[0][2];
		photo_rect4=griglia_immagini.getGriglia()[0][3];
		photo_rect5=griglia_immagini.getGriglia()[1][0];
		photo_rect6=griglia_immagini.getGriglia()[1][1];
		photo_rect7=griglia_immagini.getGriglia()[1][2];
		photo_rect8=griglia_immagini.getGriglia()[1][3];
		photo_rect9=griglia_immagini.getGriglia()[2][0];
		photo_rect10=griglia_immagini.getGriglia()[2][1];
		photo_rect11=griglia_immagini.getGriglia()[2][2];
		photo_rect12=griglia_immagini.getGriglia()[2][3];
		photo_rect13=griglia_immagini.getGriglia()[3][0];
		photo_rect14=griglia_immagini.getGriglia()[3][1];
		photo_rect15=griglia_immagini.getGriglia()[3][2];
		photo_rect16=griglia_immagini.getGriglia()[3][3];
		
		
		
//Importiamo le immagini utilizzando la classe Importa_Immagine.
		
		Image img1, img2, img3,img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15, img16;
		String s= " ";  
		Importa_Immagine imm = new Importa_Immagine(s);
		s="NotteStellata_part1.jpg";// la stringa s contiene il nome.formato dell'immagine da importare.
		img1=imm.getImmagine(s);  // il metodo getImmagine della classe Importa_Immagine restituisc l'immagine desiderata.
		
		
		s="NotteStellata_part2.jpg";
		img2=imm.getImmagine(s);
		
		s="NotteStellata_part3.jpg";
		img3=imm.getImmagine(s);
		
		s="NotteStellata_part4.jpg";
		img4=imm.getImmagine(s);
		
		s="NotteStellata_part5.jpg";//5
		img5=imm.getImmagine(s);
		
		s="NotteStellata_part6.jpg";//6
		img6=imm.getImmagine(s);
		
		s="NotteStellata_part7.jpg";
		img7=imm.getImmagine(s);
		
		s="NotteStellata_part8.jpg";
		img8=imm.getImmagine(s);
		
		
		s="NotteStellata_part9.jpg";
		img9=imm.getImmagine(s);
		
		
		s="NotteStellata_part10.jpg";
		img10=imm.getImmagine(s);
		
		s="NotteStellata_part11.jpg";
		img11=imm.getImmagine(s);
		
		s="NotteStellata_part12.jpg";
		img12=imm.getImmagine(s);
		
		s="NotteStellata_part13.jpg";
		img13=imm.getImmagine(s);
		
		
		s="NotteStellata_part14.jpg";
		img14=imm.getImmagine(s);
		
		s="NotteStellata_part15.jpg";
		img15=imm.getImmagine(s);
		
		
		s="NotteStellata_part16.jpg";
		img16=imm.getImmagine(s);
		
		// Creiamo un array di rettangoli contenente i rettangoli creati.
		Rectangle2D.Double[] rect_array = { photo_rect1, photo_rect2, photo_rect3, photo_rect4, photo_rect5, photo_rect6, photo_rect7,photo_rect8, photo_rect9,
				photo_rect10, photo_rect11, photo_rect12, photo_rect13, photo_rect14, photo_rect15, photo_rect16};
		// Criamo un array di immagini con le immagini importate.
		Image[] img_array = { img1, img2, img3, img4, img5, img6, img7, img8, img9,
				img10, img11, img12, img13, img14, img15, img16};
		
		//Visualizza le coordinate dei rettangoli prima della randomizzazoine della posizione.
		System.out.println("Rettangolo1: "+photo_rect1.getX()+" - "+photo_rect1.getY());
		
		// Crea un oggetto per la schermata del secondo livello.
		JFrame slevel3= new JFrame("Puzzle Art!");
		slevel3.setSize(1400, 900);
		slevel3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		slevel3.setVisible(true);
		slevel3.setLocationRelativeTo(null);
		slevel3.setLayout(null);
		slevel3.setResizable(false);
		
		//Imposta icona programma.
		URL url_icon=getClass().getResource("icona.jpg");
		Image icon = new ImageIcon(url_icon).getImage();
		slevel3.setIconImage(icon);
		
		
		
		// Assegnamo la griglia contenete le foto in posizione casuale. il costruttore necessita come argomento un array di rettangoli, un array di immagini ed una matrice di rettangoli.
		AssegnazioneFotoComponent photoGrid_panel = new AssegnazioneFotoComponent(audio,slevel3,rect_array, img_array,griglia_array,griglia_immagini.getGriglia());
		// impostiamo la posizione della griglia nel frame. photoGrid_panel viene gestita come un pannello, in quanto la classe AssegnazioneFotoComponent extends JPanel()
		
		photoGrid_panel.setBounds(0, 0,slevel3.getWidth(), slevel3.getHeight());
		// Impostiamo il colore relativo al pannelo photoGrid_panel. il colore deve essere casuale ad ogni avvio del gioco.
		photoGrid_panel.setBackground(this.getRandomColorize());
		photoGrid_panel.validate();
		
		
		
		

		System.out.println("Rettangolo1: "+photo_rect1.getX()+" - "+photo_rect1.getY());
		
		
		
		
		// Aggiungiamo il tutto al frame.
		slevel3.add(photoGrid_panel);
		
		
		
	}
	
	public int getRandomColorValue() // restituisce un valore random tra 0 e 255.
	{
		int x = (int) (Math.random()*(255+1));
		return x;
	}
	public Color getRandomColorize() // restituisce un colore random RGB prendendo tre valori random dato dal metodo getrandomColorValue().
	{
		Color new_color;
		new_color=new Color(this.getRandomColorValue(),this.getRandomColorValue(),this.getRandomColorValue());
		return new_color;
	}
	
	public void closeW()  // chiude la schermata del livello precedente (livello 2).
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
