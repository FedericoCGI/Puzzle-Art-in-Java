import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;



import java.sql.Timestamp;

public class PressPlayAction implements ActionListener 
{
	
	
	private JFrame sp; //schermata play.
	private Importa_Audio audio;
	
	PressPlayAction(JFrame sp,Importa_Audio audio) // Default Constructor
	{
		
		this.sp=sp;
		this.audio=audio;
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		
		
		
		
		JOptionPane.showMessageDialog(null, "                  LEVEL 1");
		
			
				
		
		// Creiamo la griglia "scheletro" .
		GrigliaFotoComponent griglia_scheletro = new GrigliaFotoComponent(30,150,130,160,2,2);  // sposta la griglia dal contorno nero.  vengono impostate le coordinate x e y e le dimensioni del primo rettangolo che costituisce la griglia. come argomento vengono passate anche le dimensioni della griglia. 
		
		// costruiamo 4 rettangoli che ospiteranno la griglia
		Rectangle2D.Double griglia_rect1=griglia_scheletro.getGriglia()[0][0];//griglia_rect1 è il rettangolo situato alla posizione 0,o all'interno della matrice(griglia)griglia_scheletro
		Rectangle2D.Double griglia_rect2=griglia_scheletro.getGriglia()[0][1];
		Rectangle2D.Double griglia_rect3=griglia_scheletro.getGriglia()[1][0];
		Rectangle2D.Double griglia_rect4=griglia_scheletro.getGriglia()[1][1];
		// Creiamo un array di rettangoli che contenga i rettangoli costituenti la griglia scheletro.
		Rectangle2D.Double[] griglia_array= { griglia_rect1, griglia_rect2, griglia_rect3, griglia_rect4};
		
	
		
		
		
				
				//creiamo la griglia che andra' a contenere le immagini.
				GrigliaFotoComponent griglia_immagini = new GrigliaFotoComponent(900,320,120,150,2,2);   //vengono creati dei rettangoli disposti in una griglia di dimensioni 2x2. vengono inoltre passati come argomenti del costruttore le coordinate x e y e le dimensioni del primo rettangolo.
				// Creiamo i rettangoli che andranno a contenere le immegini.
				Rectangle2D.Double photo_rect1, photo_rect2, photo_rect3, photo_rect4;
				
				// Assegnamo posizione e dimensioni a questi rettangoli, prendendo le posizioni gia preimpostate nella griglia creata.
				photo_rect1=griglia_immagini.getGriglia()[0][0];   // tale elemento e' il rettangolo che ospitera' la foto ed e' situato alla posizione 0,0.
				photo_rect2=griglia_immagini.getGriglia()[0][1];
				photo_rect3=griglia_immagini.getGriglia()[1][0];
				photo_rect4=griglia_immagini.getGriglia()[1][1];
				
				//Importiamo le immagini utilizzando la classe Importa_Immagine.
				
				Image img1, img2, img3,img4;
				String s= " ";
				Importa_Immagine imm = new Importa_Immagine(s); //creo un oggetto Importa_Immagine.
				s="il_bacio_part1.jpg";  // la stringa s contiene il nome dell'immagine.formato
				img1=imm.getImmagine(s); // il metodo getImmagine(s) della classe Importa_Immagine restituisce l'immagine richiesta.
				
				s="il_bacio_part2.jpg";
				img2=imm.getImmagine(s);
				
				s="il_bacio_part3.jpg";
				img3=imm.getImmagine(s);
				
				s="il_bacio_part4.jpg";
				img4=imm.getImmagine(s);
				
				// Creiamo un array di rettangoli contenente i rettangoli creati.
				Rectangle2D.Double[] rect_array = { photo_rect1, photo_rect2, photo_rect3, photo_rect4};
				// Criamo un array di immagini con le immagini importate.
				Image[] img_array = { img1, img2, img3, img4};
				
				//Visualizza le coordinate dei rettangoli prima della randomizzazoine della posizione.
				System.out.println("Rettangolo1: "+photo_rect1.getX()+" - "+photo_rect1.getY());
				
				
				// Crea un oggetto per la schermata del primo livello.
						JFrame slevel1 = new JFrame("Puzzle Art!");
						slevel1.setSize(1200, 700);
						slevel1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						slevel1.setVisible(true);
						slevel1.setLocationRelativeTo(null);
						slevel1.setLayout(null);
						slevel1.setResizable(false);
						
						
						//Imposta icona programma.
						URL url_icon=getClass().getResource("icona.jpg");
						Image icon = new ImageIcon(url_icon).getImage();
						slevel1.setIconImage(icon);
				
						
						
						
						
				
				// Assegnamo la griglia contenente le foto in posizione casuale. il costruttore necessita come argomento un array di rettangoli, un array di immagini ed una matrice di rettangoli.
				AssegnazioneFotoComponent photoGrid_panel = new AssegnazioneFotoComponent(audio,slevel1,rect_array, img_array,griglia_array,griglia_immagini.getGriglia());
				// impostiamo la posizione della griglia nel frame(come pannello, dato che la classe AssegnazioneFotoComponent extends JPanel).
				photoGrid_panel.setBounds(0, 0,slevel1.getWidth(), slevel1.getHeight());
				// Impostiamo il colore relativo al pannelo photoGrid_panel. il colore deve essere generato in modo random ad ogni avvio del gioco.
				photoGrid_panel.setBackground(this.getRandomColorize());
				photoGrid_panel.validate();
				
				
				
				
				//Visualizza le coordinate dei rettangoli dopo della randomizzazoine della posizione.
				
				System.out.println("Rettangolo1: "+photo_rect1.getX()+" - "+photo_rect1.getY());
				
				
				
			
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				// Aggiungiamo il tutto al frame.
				slevel1.add(photoGrid_panel);
				
				
				
				
				
				
				
				
				
				//rendi invisibile la schermata play.
				sp.setVisible(false);
			
		
		
				
				

				
				
				
		
		
	}
	
	
	
	public int getRandomColorValue() // restituisce un valore random tra 0 e 255.
	{
		int x = (int) (Math.random()*(255+1));
		return x;
	}
	public Color getRandomColorize() // restituisce un colore random RGB, prendendo tre valori generati dal metodo getRandomColorValue().
	{
		Color new_color;
		new_color=new Color(this.getRandomColorValue(),this.getRandomColorValue(),this.getRandomColorValue());
		return new_color;
	}
	
	
	
	
	
}
