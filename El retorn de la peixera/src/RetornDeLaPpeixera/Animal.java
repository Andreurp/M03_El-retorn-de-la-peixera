package RetornDeLaPpeixera;

import java.util.Random;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public abstract class Animal {
	
	protected boolean mascle;
	protected boolean horizontal;
	protected GImage imatge;
	protected int posicioX;
	protected int posicioY;
	protected int midaFinestraX;
	protected int midaFinestraY;
	protected int direccio;
	protected int velocitat;
	protected boolean esteril;
	protected int contedorEsteril;
	
	protected Random rand = new Random();
	
	public Animal (int midaFinestaX, int midaFinestaY, boolean mascle) {
		this.mascle=mascle;
		horizontal=rand.nextBoolean();
		posicioX=rand.nextInt(midaFinestaX-100);
		posicioY=rand.nextInt(midaFinestaY-100);
		midaFinestraX=midaFinestaX;
		midaFinestraY=midaFinestaY;
		velocitat=rand.nextInt(11)+5;
		esteril=false;
		contedorEsteril=0;
		
		// Dunar una direcció
		if(rand.nextBoolean()==true){
			direccio=1;
		}else{
			direccio=-1;
		}
		generaImatge();
	}
	
	protected abstract void generaImatge();
	
	//Mou peix
	public abstract void mou();
	
	public GImage getImatge() {
		return imatge;
	}
	public GRectangle getPosicio(){
		return imatge.getBounds();
	}
	public boolean getMascle(){
		return mascle;
	}
	
	public boolean getEsteril() {
		return esteril;
	}
	/**
	 * 
	 * @param p
	 * @return 0 no fer res
	 * 1 mata els dos animals
	 * 2 cria animal
	 * 3 mata a l'altre animal
	 */
	public abstract int xoca(Animal p);
	
	public void setEsteril(boolean esteril) {
		this.esteril = esteril;
		if(esteril==true){
			contedorEsteril=(int)imatge.getBounds().getWidth();
		}
	}
}
