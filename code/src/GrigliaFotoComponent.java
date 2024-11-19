import java.awt.geom.Rectangle2D;
import java.util.*;
import javax.swing.*;

public class GrigliaFotoComponent extends JFrame  // (si limita a creare la griglia di rettangoli.
{
	
	private double x,y,l,h;//coordinate x e y della posizione, l e h altezza e lunghezza del rettangolo
	private int gridLines;//righe della griglia
	private int gridColumns;//colonne della giglia
	private Rectangle2D.Double[][] fotoGriglia;//griglia
	
	
	

	public GrigliaFotoComponent(double x,double y,double l, double h, int gl, int gc)
	{
		this.x=x;
		this.y=y;
		this.l=l;
		this.h=h;
		this.gridLines=gl;
		this.gridColumns=gc;
		
		
		this.fotoGriglia= new Rectangle2D.Double[this.gridLines][this.gridColumns];  //imposta le dimensioni della griglia nxn.
		
		for(int i=0; i<this.gridLines; i++)//creiamo la griglia
		{
			for(int j=0; j<this.gridColumns; j++)
			{
				Rectangle2D.Double rect = new Rectangle2D.Double();
				if(i==0 && j==0)//primo rettangolo
				{
					rect.setRect(this.x, this.y, this.l, this.h);//questo metodo è un void eimposta le coordinate e le dimensioni del rettangolo.
					fotoGriglia[i][j]=rect;//l'elemento i,j della griglia è un rettangolo
				}
				
				
				if(i==0 && j>0)//prima riga
				{
					
					rect.setRect(this.x+j*this.l, this.y, this.l, this.h);//questo metodo è un voidquesto metodo è un void e imposta le coordinate e le dimensioni del rettangolo.
					fotoGriglia[i][j]=rect;//l'elemento i,j della griglia è un rettangolo
					
				}
				
				if(i>0 && j==0)//prima colonna
				{
					
					rect.setRect(this.x, this.y+i*this.h, this.l, this.h);//questo metodo è un void questo metodo è un void eimposta le coordinate e le dimensioni del rettangolo.
					fotoGriglia[i][j]=rect;//l'elemento i,j della griglia è un rettangolo
				}
				
				if(i>0 && j>0)//altre righe e colonne
				{
					rect.setRect(this.x+j*this.l, this.y+i*this.h, this.l, this.h);//questo metodo è un void questo metodo è un void eimposta le coordinate e le dimensioni del rettangolo.
					fotoGriglia[i][j]=rect;//l'elemento i,j della griglia è un rettangolo	
				}
			}
		}
		
		
	}
	
	public double getAscisse()
	{
		return this.x;
	}
	
	public double getOrdinate()
	{
		return this.y;
	}

	public double getLung()
	{
		return this.l;
	}
	
	public double getAltezza()
	{
		return this.h;
	}
	
	public Rectangle2D.Double[][] getGriglia()
	{
		return this.fotoGriglia;
	}
	
	public int getRighe()
	{
		return this.gridLines;
		
	}
	
	public int getColonne()
	{
		return this.gridColumns;
	}
	
}

