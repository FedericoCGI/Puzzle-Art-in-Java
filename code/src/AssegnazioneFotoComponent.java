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

public class AssegnazioneFotoComponent extends JPanel   // Assegna le foto ai rettangoli.
{
	private Rectangle2D.Double[] rect_array;  // array di rettangoli.
	private Image[] img_array; // array di foto.
	private ArrayList<Rectangle2D.Double> griglia_estesa;  // griglia di rettangoli che si sviuppa orizzontalmente.
	private JPanel grid_panel;
	private Importa_Audio audio;
	private Rectangle2D.Double[][] gfc;  //griglia di rettangoli. 
	private Rectangle2D.Double[][] griglia_ordinata; 
	private Rectangle2D.Double[] grid_array; //contiene i rettangoli che costituicono la griglia.

	private JFrame level;
	private Timer time;
	private CardViewer il_bacio,monaLisa,notteStellata;
	
	private JLabel points; 
	private Rectangle2D.Double border_mask1,border_mask2,border_mask3; //per evitare il messaggio posizione eerata se l'immagine non viene spostata nella griglia.
	//Rispettivamente:
	//border_mask1 e' il rettangolo maschera che va dal punto 0,0 e si estende fino a 3 pixel prima della griglia.
	//border_mask2 e' il rettangolo maschera che si estende 3 pixel al di sotto della fine della griglia.
	//border_mask3 e' il rettangolo maskera che si estende 3 pixel a sinistra della griglia.
	
	
	
	
	public AssegnazioneFotoComponent(Importa_Audio audio,JFrame level,Rectangle2D.Double[] array1_rect, Image[] array2_img, Rectangle2D.Double[] grid_array,Rectangle2D.Double[][] gfc) // Costruttore
	{
		this.rect_array=array1_rect;
		this.img_array=array2_img;
		this.grid_array=grid_array;
		this.gfc=gfc;
		this.level=level;
		this.audio=audio;
		
		
		
		//Creiamo un pannello che ospitera' il timer screen.
		JPanel timer_panel=new JPanel();
		timer_panel.setBounds(630,6,40,20);
		timer_panel.validate();
		
		//Creiamo la Label relativa al punteggio che mostra i punti.
		this.points= new JLabel();
		this.points.setBackground(Color.WHITE);
		JPanel points_panel= new JPanel();
		points_panel.setBounds(this.points.getX()-10, this.points.getY(), this.points.getWidth()+10, this.points.getHeight()+10);
		points_panel.setBackground(Color.WHITE);
		points_panel.add(points);
		points_panel.validate();
		this.add(points_panel);
		this.validate();
		
		
		
		/* A seconda della lunghezza dell'array di rettangoli che viene passato nel costruttore, si distinguono i seguenti casi:
		lunghezza 4 --> primo livello, 0 punti
		lunghezza 9 --> secondo livello, 40 punti
		lunghezza 16 --> terzo livello, 130 punti
		*/
		
		switch (this.rect_array.length)
		{
			case 4:
				{
					this.points.setText("Punti: 0 !");
					this.validate();
				}
				
				break;
			case 9:
					
				{
					this.points.setText("Punti: 40 !");
					this.validate();
				}
					
					break;
			case 16:
					
				{
					this.points.setText("Punti: 130 !");
					this.validate();
				}
					
					break;
			
		}

		/* A seconda della lunghezza dell'array di rettangoli che viene passato nel costruttore, si distinguono i seguenti casi:
		lunghezza 4 --> primo livello, timer 2min 00 s
		lunghezza 9 --> secondo livello, timer 1 min 45 se
		lunghezza 16 --> terzo livello, timer 1 min 20 s
		*/
		
		switch (this.rect_array.length)
		{
			case 4:
				{
					Cronometro timer_screen= new Cronometro(2,0,timer_panel);
					this.time= new Timer(250,timer_screen);
				}
				
				break;
			case 9:
					
				{
					Cronometro timer_screen= new Cronometro(1,45,timer_panel);
					this.time= new Timer(250,timer_screen);
				}
					
					break;
			case 16:
					
				{
					Cronometro timer_screen= new Cronometro(1,20,timer_panel);
					this.time= new Timer(250,timer_screen);
				}
					
					break;
			
		}
		
		
		// imposta Timer screen.
		
		
		this.time.start();
		
		this.add(timer_panel);   // abbiamo aggiunto il timer_panel che ospita il timer nel pannello principale(photoGrid_panel).
		this.revalidate();
		
		
		
		
		// ordiniamo in un arraylist  i rettangoli contenuti nell'array, per poi dare ai rettangoli una posizione casuale.
		this.griglia_estesa= new ArrayList<Rectangle2D.Double> (this.rect_array.length);
		for (int i=0; i<this.rect_array.length; i++) // aggiungi elementi alla arraylist
		{
			this.griglia_estesa.add(i, this.rect_array[i]);
		}
		
		
		
		
		// Randomizziamo la posizione degli elementi dell'ArrayList.
		Collections.shuffle(this.griglia_estesa);   // il metodo public static void shuffle(List<?> list) mescola ("disordina") gli elementi della lista del parametro list utilizzando una sorgente di casualita' predefinita.
		
		
		// aggiungiamo  la componente che permette di ordinare i rettangoli in una griglia nxn.
		this.ordinaInGriglia(this.griglia_estesa);
		
		
		
		//aggiungi pulsante vedi immagine
				JButton view_image= new JButton("VIEW IMAGE");
				view_image.setToolTipText("Press this button to open the complete image.");
				view_image.setBounds(500, 10,50 , 20);
				
				// aggiungi il bottone view al pannello di livello1
				this.add(view_image);
				this.validate();
				
				
				/* A seconda della lunghezza dell'array di rettangoli che viene passato nel costruttore, si distinguono i seguenti casi:
				lunghezza 4 --> primo livello, CardViewer il_bacio,
				lunghezza 9 --> secondo livello, CardViewer MonaLisa,
				lunghezza 16 --> terzo livello, CardViewer NotteStellata
				*/
				
				switch (this.rect_array.length)
				{
					case 4:
						{
							
							
							// Creo le azioni del visualizzatore di immagine da ricostruire.
							// creo una JLabel contenete l'immagine da ricostruire.
							URL url_icon2=getClass().getResource("viewer_level1.jpg");
							Icon icon2 = new ImageIcon(url_icon2);
							
							JLabel photo_label = new JLabel();
							photo_label.setIcon(icon2);
							
							
							
							// creo un cardviewer per la foto 1.
							 this.il_bacio = new CardViewer("Il Bacio",photo_label,this.getViewerImageIcon());
							il_bacio.setSize(600, 800);
							
							
							
							// Creo una viewer action per il bottone view image
							ViewerAction view_image1 = new ViewerAction(il_bacio);
							
							//Aggiungo l'azione di visualizzazione al bottone view image
							
							view_image.addActionListener(view_image1);
							
							
						}
						
						break;
					case 9:
							
						{
							
							
							

							// Creo le azioni del visualizzatore di immagine da ricostruire.
							// creo una JLabel contenete l'immagine da ricostruire.
							URL url_icon2=getClass().getResource("viewer_level2.jpg");
							Icon icon2 = new ImageIcon(url_icon2);
							
							JLabel photo_label = new JLabel();
							photo_label.setIcon(icon2);
							
							
							// creo un cardviewer per la foto 2.
							this.monaLisa = new CardViewer("Mona Lisa",photo_label,this.getViewerImageIcon());
							this.monaLisa.setSize(687, 1024);
							
							// Creo una viewer action per il bottone view image
							ViewerAction view_image2 = new ViewerAction(this.monaLisa);
							
							//Aggiungo l'azione di visualizzazione al bottone view image
							
							view_image.addActionListener(view_image2);
							
							
						}
							
							break;
					case 16:
							
						{
							
							
							

							// Creo le azioni del visualizzatore di immagine da ricostruire.
							// creo una JLabel contenete l'immagine da ricostruire.
							URL url_icon4=getClass().getResource("viewer_level3.jpeg");
							Icon icon3 = new ImageIcon(url_icon4);
							
							JLabel photo_label = new JLabel();
							photo_label.setIcon(icon3);
							
							
							
							// creo un cardviewer per la foto 3.
							this.notteStellata = new CardViewer("Notte Stellata",photo_label,this.getViewerImageIcon());
							this.notteStellata.setSize(640, 482);
							
							// Creo una viewer action per il bottone view image
							ViewerAction view_image3 = new ViewerAction(this.notteStellata);
							
							//Aggiungo l'azione di visualizzazione al bottone view image
							
							view_image.addActionListener(view_image3);
							
							
						}
							
							break;
					
				}
				
				/* A seconda della lunghezza dell'array di rettangoli che viene passato nel costruttore, si distinguono i seguenti casi:
				lunghezza 4 --> primo livello, impostiamo il rettangolo borders_mask in coordinate()
				lunghezza 9 --> secondo livello, impostiamo il rettangolo borders_mask in coordinate()
				lunghezza 16 --> terzo livello, impostiamo il rettangolo borders_mask in coordinate()
				*/
				
				switch (this.rect_array.length)
				{
					case 4:
						{
							this.border_mask1= new Rectangle2D.Double(0, 0,2000 , 147);
							this.border_mask2= new Rectangle2D.Double(0, 473,2000 , 2000);
							this.border_mask3= new Rectangle2D.Double(293, 0,2000 , 2000);
							
						}
						
						break;
					case 9:
							
						{
							this.border_mask1= new Rectangle2D.Double(0, 0,2000 , 127);
							this.border_mask2= new Rectangle2D.Double(0, 613,2000 , 2000);
							this.border_mask3= new Rectangle2D.Double(423, 0,2000 , 2000);
						}
							
							break;
					case 16:
							
						{
							this.border_mask1= new Rectangle2D.Double(0, 0,2000 , 97);
							this.border_mask2= new Rectangle2D.Double(0, 623,2000 , 2000);
							this.border_mask3= new Rectangle2D.Double(653, 0,2000 , 2000);
						}
							
							break;
					
				}
		
		
		
		// aggiungiamo il movimento alle immagini.
		Muovi_Immagine move_img = new Muovi_Immagine(this.time,this.level,this.grid_array,this.rect_array);
		addMouseListener(move_img);
		addMouseMotionListener(move_img);
		
		
		
		
		repaint();
		
		
		
	}
	
	public Image getViewerImageIcon()  // Restituisce l'icona / immagine desiderata.
	{
		Image img_returning=null;
		
		/* A seconda della lunghezza dell'array di rettangoli che viene passato nel costruttore, si distinguono i seguenti casi:
		lunghezza 4 --> primo livello, viewer_livel1
		lunghezza 9 --> secondo livello, viewer_level2
		lunghezza 16 --> terzo livello, viewer_level3
		*/
		
		switch (this.rect_array.length)
		{
			case 4:
				{
					
					URL url_icon2=getClass().getResource("viewer_level1.jpg");
					Image icon2 = new ImageIcon(url_icon2).getImage();
					img_returning=icon2;
					
					
					
				}
				
				break;
			case 9:
					
				{
					
					
					
					URL url_icon2=getClass().getResource("viewer_level2.jpg");
					Image icon2 = new ImageIcon(url_icon2).getImage();
					img_returning=icon2;
					
					
					
				}
					
					break;
			case 16:
					
				{
					
					
					
					URL url_icon3=getClass().getResource("viewer_level3.jpeg");
					Image icon3 = new ImageIcon(url_icon3).getImage();
					img_returning=icon3;
					
					
					
				}
					
					break;
			
		}
		
		return img_returning;
	}
	
	
	
	
	// metodo che ordina gli elemnti di un array list (esteso orizzontalmente) all'interno di una griglia nxn.
	public Rectangle2D.Double[][] ordinaInGriglia(ArrayList<Rectangle2D.Double> list)
	{
		// crea la griglia e ordina l'array list nella griglia.
		this.griglia_ordinata= new Rectangle2D.Double[this.gfc.length][this.gfc[0].length];  // si impostano le dimensioni della nuova griglia nxn che ordinera' e conterra' gli elementi dell'arraylist. 
		double x2=this.rect_array[0].getX(); // coordinata x del primo elemento di tipo rettangolo dell'arraylist.
		double y2=this.rect_array[0].getY(); // coordinata y del primo elemento di tipo rettangolo dell'arraylist.
		double l2=this.rect_array[0].getWidth(); // lunghezza del primo elemento di tipo rettangolo dell'arraylist.
		double h2=this.rect_array[0].getHeight();// altezza del primo elemento di tipo rettangolo dell'arraylist.
		
				for(int i=0; i<this.gfc.length; i++)
				{
					for(int j=0; j<this.gfc[0].length; j++)
					{
						Rectangle2D.Double rect= new Rectangle2D.Double();
						if(i==0 && j==0)//primo rettangolo
						{
							rect=list.get(j+i*this.gfc.length);
							rect.setRect(x2, y2,l2, h2);
							this.griglia_ordinata[i][j]=rect;
						}
						
						if( i==0 && j>0)//prima riga
						{
							rect=list.get(j+i*this.gfc.length);
							rect.setRect(x2+j*l2, y2,l2, h2);
							this.griglia_ordinata[i][j]=rect;
						}
						if(i>0 && j==0)//prima colonna
						{
							
							rect=list.get(j+i*this.gfc.length);
							rect.setRect(x2, y2+i*h2,l2, h2);
							this.griglia_ordinata[i][j]=rect;
						}
						if(i>0 && j>0)//altre righe
						{
							rect=list.get(j+i*this.gfc.length);
							rect.setRect(x2+j*l2, y2+i*h2,l2, h2);
							this.griglia_ordinata[i][j]=rect;
						
						}
						System.out.println(this.griglia_ordinata[i][j].getX()+" - "+this.griglia_ordinata[i][j].getY() );
					}
				}
				return this.griglia_ordinata;
			
	}
	
	// metodo che disegna la griglia scheletro e assegna le foto ai rettangoli ( perche' per visualizzare la griglia scheletro e le immagini da spostare contemporaneamente la griglia scheletro e le immagini devono stare sullo stesso pannello, altrimenti se sono su due pannelli diversi, quando vai a spostare le immagini la griglia scheletro scompare.
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g_2D = (Graphics2D) g;
		for (int i=0; i<this.rect_array.length; i++) // assegna foto ai rettangoli.
		{
			g_2D.drawImage(this.img_array[i],(int) this.rect_array[i].getX(), (int)this.rect_array[i].getY(), (int)this.rect_array[i].getWidth(), (int)this.rect_array[i].getHeight(), null); // il metodo prende come argomento valori di tipo interi.
			
		}
		
		for(int i=0; i<this.grid_array.length; i++)     // disegna la griglia scheletro.
		{
			g_2D.draw(this.grid_array[i]);
		}
		
	}
	
	
	
	
	
	
	
	
	
	public Rectangle2D.Double[] getRectangleArray()
	{
		return this.rect_array;
	}
	
	public Image[] getImageArray()
	{
		return this.img_array;
	}
	
	public ArrayList<Rectangle2D.Double> getRectangleArrayList()
	{
		return this.griglia_estesa;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Creiamo un classe che gestisce il movimento delle immagini al click e al trascinamento del mouse
	
	
	
	class Muovi_Immagine extends MouseAdapter
	{

		private Rectangle2D.Double[] grid;   // griglia
		private Rectangle2D.Double[] rett;  // rettangoli ai quali sono asociate le immagini
		private boolean var=false;
		private Point2D pos;
		private int punteggio;
		private Rectangle2D.Double rettangolo_in_movimento;  //rettangolo di riferimento che verra' spostato.
		private Rectangle2D.Double griglia_fissa; // griglia fissa di riferimento che dovra' contenere il rettangolo in movimento per avviare il gioco.
		private JFrame level;
		private Timer t;
		private String pp;
		private int index;
		
		
		
		
		public Muovi_Immagine(Timer t, JFrame level,Rectangle2D.Double[] grid,Rectangle2D.Double[] rett )// costruttore
		{
			this.grid=grid;
			this.rett=rett;
			this.level=level;
			this.t=t;
			
			
			/* A seconda della lunghezza dell'array di rettangoli che viene passato nel costruttore, si distinguono i seguenti casi di inizializzazione della variabile di istanza this.punteggio:
			lunghezza 4 --> primo livello, this.puntoggio =0
			lunghezza 9 --> secondo livello, this.punteggio=40
			lunghezza 16 --> terzo livello, this.punteggio=120
			*/
			
			//inizializza il punteggio per ogni livello.
			switch(this.rett.length)
			{
				case 4:
					this.punteggio=0;
					
					break;
					
				case 9:
					this.punteggio=40;
					break;
					
				case 16:
					this.punteggio=130;
					break;
			}
			
		}
		
		public void mousePressed(MouseEvent e)       //metodo che gestisce il click del mouse sull'immagine
		{
			pos = (e.getPoint());      // prendi la posizione del punto dove si fa il click del mouse
			System.out.println(pos);
			
			boolean valid=this.mossaNonValida();   // Controlla se la mossa sia o meno valida per evitare di barare e aumentare i punti.
			if(valid==true)
			{
				System.out.println("Mossa Non Valida ha valore TRUE");
				this.punteggio=this.punteggio+0;
			}
			else
			{
				System.out.println("Mossa Non Valida ha valore FALSE");
				this.punteggio=this.punteggio+0;
			}

			
			
			boolean click =false;
			//adesso vediamo se la posizione del punto al click del mouse è contenuta in una delle immaggini(in uno dei rettangoli dell'array rett), cosicche' l'immagine selezionata possa essere spostata.
			for(int i=0; i<this.grid.length; i++)
			{
				this.rettangolo_in_movimento=this.rett[i];  //Ci riconduciamo alla condizione secondo cui bisogna spostare un solo rettangolo in una sola griglia 1x1. Per ogni i, associamo al rettangolo_in_movimento un elemento di tipo rettangolo dell'array.
				if (this.rettangolo_in_movimento.contains(pos))
				{
					click=true;
					break;
						
					
				}
				else
				{
					click=false;
				}
					
					
					
				
			}
			
			
			boolean p_giusta=getGiustaPosizione();
			
			
			if(click ==true  )
			{
				if(p_giusta==true)
				{
					if(rett[index].contains(pos))   // Le seguenti istruzioni sono relative al caso in cui un immagine I sia gia' stata posizionata al posto giusto nella griglia. Immaginiamo di spostare una seconda immagine M sopra l'immagine I coprendo una certa sezione A(viene coperta una certa sezione A dell'immagine I quando l'immagine I viene sormontata da un'immagine M, dove questa porzione A puo' essere piccola o grande quanto I). Se non vi fossero le seguenti istruzioni se si cliccasse nella sezione A per spostare M , M non si spoterebbe, in quanto la poszione al click del mouse risulterebbe essere dentro l'immagine I che e' bloccata perche' al posto giusto. Per spostare l'immagine M si dovrebbe fare click su m in una sezione che sia al di fuori della sezione A che copre I. Ma le seguenti istruzioni permettono di spostare M , cliccando ovunque su M, anche se M copre per intero, o per una piccola sezione,l'immagine  I.
					{
						for(int i=0; i<rett.length; i++)
						{
							this.rettangolo_in_movimento=rett[i];
							if(this.rettangolo_in_movimento==rett[index])
							{
								var=false;  //blocca l'immagine che gia' e' al posto giusto al fine di evitare che il giocatore possa barare.
								continue;
							}
							else
							{
								if(this.rettangolo_in_movimento.contains(pos)|| this.rettangolo_in_movimento.intersects(rett[index]))
								{
									var=true;
									break;
								}
							}
						}
					}
					
				}
				else
				{
					var=true;
				}
			}
			else
			{
				var=false;     // se var = false stampa le coordinate del punto preso al click del mouse
				System.out.println("Coordinata del punto al click "+e.getX()+" "+e.getY());
				
			} 
			
			
				
				
				
		
				
			
		}
			
		
		
		
		
		public void mouseDragged(MouseEvent b)//metodo che gestisce il  trascinamento delle immagini con il mouse
			
		{
			
			//adesso vediamo se la posizione del punto al click del mouse è contenuta in una delle immaggini(in uno dei rettangoli dell'array rett)
			
			if(var)
			{
					
							
							
								
								// se var = true sposti l'immagine che contiene la posizione del mouse.
						
								Point2D offset = new Point2D.Double(pos.getX(),pos.getY());
								Point2D nCenter = new Point2D.Double(b.getX(), b.getY());
								Point2D raggio = null;
								
								
								
								/* A seconda della lunghezza dell'array di rettangoli che viene passato nel costruttore, si distinguono i seguenti casi:
								lunghezza 4 --> primo livello, timer 2min 00 s
								lunghezza 9 --> secondo livello, timer 1 min 45 se
								lunghezza 16 --> terzo livello, timer 1 min 20 s
								*/
								
								switch (rect_array.length)
								{
									case 4:
										{
											 raggio = new Point2D.Double(nCenter.getX()+60, nCenter.getY()+75);
										}
										
										break;
									case 9:
											
										{
											 raggio = new Point2D.Double(nCenter.getX()+60, nCenter.getY()+75);
										}
											
											break;
									case 16:
											
										{
											 raggio = new Point2D.Double(nCenter.getX()+75, nCenter.getY()+60);
										}
											
											break;
									
								}
								
								
								this.rettangolo_in_movimento.setFrameFromCenter(nCenter, raggio);
								repaint();
								
								
							}
							else   // se var = false stampi il messaggio.
							{
								System.out.println("Non succede niente!");
								repaint();
							}
								
							
		}
			
					
		
		
		
		public void mouseReleased(MouseEvent e)  // metodo che descrive cio' che succede al rilascio del tasto del mouse.
		{
			
			boolean posto_giusto;//varibiale che indica se l'immagine è posizionata nella sezione corretta della griglia.
			
			
			
			
			if(var==true)
			{
						 posto_giusto=getGiustaPosizione();    //il valore che assume la variabile dipende dal valore restituito dal metodo getGiustaPosizione().
						
						
						posto_giusto=posto_giusto;
						if(posto_giusto==true )     // se l'immagine (rettangolo contenente l'immagine in questione) e' spostata nel posto giusto incrementi i punti del giocatore.
						{
							
							
							this.punteggio=this.punteggio+10;
							pp= "Punti: "+this.punteggio+ " !";
							points.setText(pp);
							points.setBackground(Color.WHITE);
							validate();
							
							System.out.println(this.punteggio);
							
							
							// gestione del punteggio per passare al liveelo successivo.
							
							/* A seconda della lunghezza dell'array di rettangoli che viene passato nel costruttore, si distinguono i seguenti casi:
							lunghezza 4 --> primo livello, se il punteggio e' pari a 40 punti, ferma il timer e passa al livello2;
							lunghezza 9 --> secondo livello, crea un oggetto di secondo livello.Se il punteggio e' pari a 130, ferma il timer e passa al livello3;
							lunghezza 16 --> terzo livello, crea un oggetto di terzo livello. se il punteggio e' pari a 290, ferma il timer, mostra il punteggio totale e chiudi il programma.
							*/
							
							switch (this.rett.length)
							{
								case 4:
								{
									if (this.punteggio==40)
									{
										
										
										this.t.stop();
										setLayout(null);
										setBackground(Color.WHITE);
										Importa_Audio get = new Importa_Audio("Get It .WAV");
										get.PlaySound();
										JOptionPane.showMessageDialog(null,"                  LEVEL 2" );
										// Crea un oggetto di tipo SecondoLivello.
										
										SecondoLivello level2=new SecondoLivello(this.level,il_bacio,audio);
										level2.closeW(); // chiude il frame del livello1.
										level2.closeCardViewer();  // Chiude il view_image nel caso in cui fosse ancora aperto a livello terminato.
									}
								}
								break;
									
									case 9:
									{
										if (this.punteggio==130)
										{
											this.t.stop();
											setLayout(null);
											setBackground(Color.WHITE);
											Importa_Audio get = new Importa_Audio("Get It .WAV");
											get.PlaySound();
												JOptionPane.showMessageDialog(null,"                  LEVEL 3" );
											this.level.setVisible(false);  // Rende invisibile la schermata relativa al primo livello.
											
											TerzoLivello level3= new TerzoLivello(this.level,monaLisa,audio);
											level3.closeW(); //chiude il frame del livello2.
											level3.closeCardViewer();  // Chiude il view_image nel caso in cui fosse ancora aperto a livello terminato.
											
											
											
										
											
										}
										
									}
									break;
									
									case 16:
									{
										if (this.punteggio==290)
										{
											this.t.stop();
											setLayout(null);
											setBackground(Color.WHITE);
											Importa_Audio get = new Importa_Audio("Get It .WAV");
											get.PlaySound();
											JOptionPane.showMessageDialog(null,"Il tuo punteggio totale e' di "+ this.punteggio+" punti!" );
											this.level.setVisible(false);  // Rende invisibile la schermata relativa al primo livello.
											notteStellata.setVisible(false);
											// Crea schermata finale.
											
											Congratulation end_of_the_game = new Congratulation(this.level,notteStellata,audio);
											end_of_the_game.closeCardViewer();  // Chiude il view_image nel caso in cui fosse ancora aperto a livello terminato.
											end_of_the_game.closeW(); // chiude il frame del livello 3.
											
											
											
										
										
										}
											
											
									}
										break;
							
							}
							
							
							
							
							repaint();
						
						}
						else//se l'immagine(rettangolo contenente l'immagine in questione) non viene spostata nel posto giusto i punti non vengono incrmentati.
						{
							
							if(border_mask1.contains(e.getX(),e.getY())  || border_mask2.contains(e.getX(),e.getY())  || border_mask3.contains(e.getX(),e.getY()  ) )
							{
								System.out.println(" ");
							}
							
							else
							{
								this.punteggio=this.punteggio+0;
								JOptionPane.showMessageDialog(null, "Posizione errata!");
								repaint();
							}
							
						}	
				}
						
			
		}
		
		
		
		
		
		public boolean getGiustaPosizione()     // metodo che controlla se un rettangolo contenente l'immagine viene posizionato nella sezione giusta della griglia. Ci riconduciamo al caso in cui vi e' un solo rettangolo da spostare (rettangolo_in_movimento) all'interno di una sola sezione di un griglia 1x1 (griglia_fissa).
		{
			 
			boolean posizione_giusta=false;
			for(int i=0; i<grid.length; i++)//controlliamo che spostando l'immagine il quadrato contenente l'immagine sia posizionato nella giusta sezione di griglia
			{
				this.griglia_fissa=this.grid[i]; // per ogni i, associamo a griglia_fissa un rettangolo (sezione di griglia) dell'array grid(array che contiene i rettangoli che formano la griglia)
				if(this.griglia_fissa.contains(this.rettangolo_in_movimento))   //si verifica se la griglia_fissa contiene il rettangolo in movimento.
				
				{
					if(this.rettangolo_in_movimento==this.rett[i])  // si verifica che  il rettangolo in movimento e' uguale al rettangolo corrispondente alla giusta sezione  della griglia
					{
						posizione_giusta=true;
						index=i;
						break;
					}
					else
					{
						posizione_giusta=false;
						break;
						
					}
					
				}
			}
			
			return posizione_giusta;
		}
		
		
		public boolean mossaNonValida()
		{
			
				
				boolean mossa_non_valida=false;
				for(int i=0; i<grid.length; i++)//controlliamo che spostando l'immagine il quadrato contenente l'immagine sia posizionato nella giusta sezione di griglia
				{
					this.griglia_fissa=this.grid[i]; // per ogni i, associamo a griglia_fissa un rettangolo (sezione di griglia) dell'array grid(array che contiene i rettangoli che formano la griglia)
					if(this.griglia_fissa.contains(pos))   //si verifica se la griglia_fissa contiene il rettangolo in movimento.
					
					{
						
							mossa_non_valida=true;
							
							break;
					}
						else
						{
							mossa_non_valida=false;
							
							
						}
						
					
				}
				return mossa_non_valida;
		}
		
		
		
		public int getPunti()
		{
			return this.punteggio;
		}
					
			
			
	}
		
		
	

	

	
	
}

