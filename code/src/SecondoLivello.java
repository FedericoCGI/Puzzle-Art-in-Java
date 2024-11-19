
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

public class SecondoLivello extends JFrame
{

	private JFrame sl; // schermata di un livello (uno)
	private CardViewer cv;  //CardViewer contenente l'immagine da visualizzare.
	private Importa_Audio audio;
	public SecondoLivello(JFrame sl,CardViewer cv,Importa_Audio audio)
	{
		
		
		this.sl=sl;
		this.cv=cv;
		this.audio=audio;
		
		
	
		// Creiamo la griglia "scheletro" .
				GrigliaFotoComponent griglia_scheletro = new GrigliaFotoComponent(30,130,130,160,3,3);  // sposta la griglia dal contorno nero.  vengono passate le coordinate x e y e le dimensioni del primo rettangolo della griglia di dimensioni 9x9.
				// costruiamo 4 rettangoli che ospiteranno la griglia
				Rectangle2D.Double griglia_rect1=griglia_scheletro.getGriglia()[0][0];//griglia_rect1 è il rettangolo situato alla posizione 0,0 all'interno della matrice(griglia)griglia_scheletro
				Rectangle2D.Double griglia_rect2=griglia_scheletro.getGriglia()[0][1];
				Rectangle2D.Double griglia_rect3=griglia_scheletro.getGriglia()[0][2];
				Rectangle2D.Double griglia_rect4=griglia_scheletro.getGriglia()[1][0];
				Rectangle2D.Double griglia_rect5=griglia_scheletro.getGriglia()[1][1];
				Rectangle2D.Double griglia_rect6=griglia_scheletro.getGriglia()[1][2];
				Rectangle2D.Double griglia_rect7=griglia_scheletro.getGriglia()[2][0];
				Rectangle2D.Double griglia_rect8=griglia_scheletro.getGriglia()[2][1];
				Rectangle2D.Double griglia_rect9=griglia_scheletro.getGriglia()[2][2];
	
				
				// Creiamo un array di rettangoli che contenga i rettangoli costituenti la griglia scheletro.
				Rectangle2D.Double[] griglia_array= { griglia_rect1, griglia_rect2, griglia_rect3, griglia_rect4, griglia_rect5, griglia_rect6, griglia_rect7, griglia_rect8,griglia_rect9};
				

				//creiamo la griglia che andra' a contenere le immagini.
				GrigliaFotoComponent griglia_immagini = new GrigliaFotoComponent(600,120,120,150,3,3);  //vengono passate le coordinate x e y e le dimensioni del primo rettangolo della griglia di dimensioni 9x9.
				// Creiamo i rettangoli che andranno a contenere le immegini.
				Rectangle2D.Double photo_rect1, photo_rect2, photo_rect3, photo_rect4, photo_rect5, photo_rect6, photo_rect7, photo_rect8,photo_rect9;
				
				// Assegnamo posizione e dimensioni a questi rettangoli, prendendo le posizioni gia preimpostate nella griglia creata.
				photo_rect1=griglia_immagini.getGriglia()[0][0];  // tale rettangolo che conterra' l'immagine e' l'elemento 0,0 della griglia.
				photo_rect2=griglia_immagini.getGriglia()[0][1];
				photo_rect3=griglia_immagini.getGriglia()[0][2];
				photo_rect4=griglia_immagini.getGriglia()[1][0];
				photo_rect5=griglia_immagini.getGriglia()[1][1];
				photo_rect6=griglia_immagini.getGriglia()[1][2];
				photo_rect7=griglia_immagini.getGriglia()[2][0];
				photo_rect8=griglia_immagini.getGriglia()[2][1];
				photo_rect9=griglia_immagini.getGriglia()[2][2];
				
//Importiamo le immagini utilizzando la classe Importa_Immagine.
				
				Image img1, img2, img3,img4, img5, img6, img7, img8, img9;
				String s= " "; //la stringa s contiene il nome.formato dell'immagine.
				Importa_Immagine imm = new Importa_Immagine(s);
				s="MonaLisa_part1.jpg";
				img1=imm.getImmagine(s);  // il metodo getImmagine(s) della clsse Importa_Immagine restituisce l'immagine desiderata.
				
				s="MonaLisa_part2.jpg";
				img2=imm.getImmagine(s);
				
				s="MonaLisa_part3.jpg";
				img3=imm.getImmagine(s);
				
				s="MonaLisa_part4.jpg";
				img4=imm.getImmagine(s);
				
				s="MonaLisa_part5.jpg";//5
				img5=imm.getImmagine(s);
				
				s="MonaLisa_part6.jpg";//6
				img6=imm.getImmagine(s);
				
				s="MonaLisa_part7.jpg";//7
				img7=imm.getImmagine(s);
				
				s="MonaLisa_part8.jpg";//8
				img8=imm.getImmagine(s);
				
				
				s="MonaLisa_part9.jpg";//8
				img9=imm.getImmagine(s);
				
				
				// Creiamo un array di rettangoli contenente i rettangoli creati.
				Rectangle2D.Double[] rect_array = { photo_rect1, photo_rect2, photo_rect3, photo_rect4, photo_rect5, photo_rect6, photo_rect7,photo_rect8, photo_rect9 };
				// Criamo un array di immagini con le immagini importate.
				Image[] img_array = { img1, img2, img3, img4, img5, img6, img7, img8, img9};
				
				
				//Visualizza le coordinate dei rettangoli prima della randomizzazoine della posizione.
				System.out.println("Rettangolo1: "+photo_rect1.getX()+" - "+photo_rect1.getY());
				
				// Crea un oggetto per la schermata del secondo livello.
				JFrame slevel2= new JFrame("Puzzle Art!");
				slevel2.setSize(1200, 700);
				slevel2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				slevel2.setVisible(true);
				slevel2.setLocationRelativeTo(null);
				slevel2.setLayout(null);
				slevel2.setResizable(false);
				
				
				
				//Imposta icona programma.
				URL url_icon=getClass().getResource("icona.jpg");
				Image icon = new ImageIcon(url_icon).getImage();
				slevel2.setIconImage(icon);
		
				
				// Assegnamo la griglia contenete le foto in posizione casuale. il costruttore necessita come argomento un array di rettangoli, un array di immagini ed una matrice di rettangoli.
				AssegnazioneFotoComponent photoGrid_panel = new AssegnazioneFotoComponent(audio,slevel2,rect_array, img_array,griglia_array,griglia_immagini.getGriglia());
				// impostiamo la posizione della griglia nel frame.photoGrid_panel viene gestito come un pannello, in quanto la  classe  AssegnazioneFotoComponent extends JPanel.
				photoGrid_panel.setBounds(0, 0,slevel2.getWidth(), slevel2.getHeight());
				// Impostiamo il colore relativo al pannelo photoGrid_panel. il colore deve essere casuale ad ogni avvio del gioco.
				photoGrid_panel.setBackground(this.getRandomColorize());
				photoGrid_panel.validate();
				
				
//Visualizza le coordinate dei rettangoli dopo della randomizzazoine della posizione.
				
				System.out.println("Rettangolo1: "+photo_rect1.getX()+" - "+photo_rect1.getY());
				
				
				
				
				// Aggiungiamo il tutto al frame.
				slevel2.add(photoGrid_panel);
				
				
				
				
	}
	
	
	public int getRandomColorValue() // restituisce un valore random tra 0 e 255.
	{
		int x = (int) (Math.random()*(255+1));
		return x;
	}
	public Color getRandomColorize() // restituisce un colore random RGB prendendo tre valori casuali dovuti al metodo getRandomColorValue().
	{
		Color new_color;
		new_color=new Color(this.getRandomColorValue(),this.getRandomColorValue(),this.getRandomColorValue());
		return new_color;
	}
	
	public void closeW()   // chiude la schermata del livello precedente (livello1).
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
