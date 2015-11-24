package RetornDeLaPpeixera;

import acm.graphics.GImage;

public class Pop extends Animal {

	public Pop(int midaFinestaX, int midaFinestaY, boolean mascle) {
		super(midaFinestaX, midaFinestaY, true);

		if (this.horizontal) {
			if (rand.nextInt(2) % 2 == 0) {
				posicioY = (int) (midaFinestraY - imatge.getHeight());
			} else {
				posicioY = 0;
			}
		} else {
			if (rand.nextInt(2) % 2 == 0) {
				posicioX = (int) (midaFinestraX - imatge.getWidth());
			} else {
				posicioX = 0;
			}
		}
		imatge.setLocation(posicioX, posicioY);
	}

	@Override
	protected void generaImatge() {
		imatge = new GImage("Pop/pop.png", posicioX, posicioY);

	}

	@Override
	public void mou() {
		if (horizontal == true) {
			imatge.move(direccio * velocitat, 0);

		} else {
			imatge.move(0, direccio * velocitat);
		}

		// Quan desaparegi per un custat torna per l'oposat
		if (horizontal) {
			// baix horitzontal
			if (posicioY > 0) {
				// dreta
				if (imatge.getLocation().getX() + imatge.getWidth() > midaFinestraX) {
					imatge.setLocation(midaFinestraX - imatge.getWidth(), posicioY);
					horizontal = false;
					direccio = -1;
				}
				// esquerra
				else if (imatge.getLocation().getX() < 0) {
					imatge.setLocation(0, posicioY);
					horizontal = false;
					direccio = -1;
				}
				// dalt horitzontal
			} else if (posicioY == 0) {
				// dreta
				if (imatge.getLocation().getX() + imatge.getWidth() > midaFinestraX) {
					imatge.setLocation(midaFinestraX - imatge.getWidth(), posicioY);
					horizontal = false;
					direccio = 1;
				}
				// esquerra
				else if (imatge.getLocation().getX() < 0) {
					imatge.setLocation(0, posicioY);
					horizontal = false;
					direccio = 1;
				}
			}
		} else {
			if (posicioX > 0) {
				if (imatge.getLocation().getY() + imatge.getHeight() > midaFinestraY) {
					imatge.setLocation(posicioX, midaFinestraY - imatge.getHeight());
					horizontal = true;
					direccio = -1;
				} else if (imatge.getLocation().getY() < 0) {
					imatge.setLocation(posicioX, 0);
					horizontal = true;
					direccio = -1;
				}
			} else if (posicioX == 0) {
				// 
				if (imatge.getLocation().getY() + imatge.getHeight() > midaFinestraY) {
					imatge.setLocation(posicioX, midaFinestraY - imatge.getHeight());
					horizontal = true;
					direccio = 1;
				}
				// esquerra
				else if (imatge.getLocation().getY() < 0) {
					imatge.setLocation(posicioX, 0);
					horizontal = true;
					direccio = 1;
				}
			}
		}
	}

	@Override
	public int xoca(Animal p) {
		// TODO Auto-generated method stub
		return 0;
	}

}
