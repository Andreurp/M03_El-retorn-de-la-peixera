package RetornDeLaPpeixera;

import acm.graphics.GImage;

public class Cranc extends Animal {

	public Cranc(int midaFinestaX, int midaFinestaY, boolean mascle) {
		super(midaFinestaX, midaFinestaY, mascle);
		
		this.mascle=true;
		horizontal=true;
		posicioY=(int)(midaFinestraY-imatge.getHeight());
		imatge.setLocation(posicioX, posicioY);
	}

	@Override
	protected void generaImatge() {
		imatge = new GImage("Cranc/Crawdaunt.png", posicioX, posicioY);
	}

	@Override
	public void mou() {
		imatge.move(direccio * velocitat, 0);
		if (imatge.getLocation().getX() > midaFinestraX) {
			imatge.setLocation(0 - imatge.getBounds().getWidth(), posicioY);
		} else if (imatge.getLocation().getX() < 0 - imatge.getBounds().getWidth()) {
			imatge.setLocation(midaFinestraX, posicioY);
		}
		
	}

	@Override
	public int xoca(Animal p) {
		
		return 0;
	}

}
