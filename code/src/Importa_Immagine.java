
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.Collections;
import java.util.*;
import javax.swing.*;



import java.awt.*;

public class Importa_Immagine 
{
	private String s;  //contiene il nome dellìimmagine.formato
	public Importa_Immagine(String s)  //Costruttore
	{
		this.s=s;
		this.getImmagine(this.s);
	}
	
	public Image getImmagine(String s)  //Metodo che restituice l'immagine desiderata avendo come argomento una stringa contenente il nome dell'immagine.
	{
		
		Image image = new ImageIcon(getClass().getResource(s)).getImage();
		return image;
	}
}
