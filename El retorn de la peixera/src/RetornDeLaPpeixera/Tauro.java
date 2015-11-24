package RetornDeLaPpeixera;

import acm.graphics.GImage;

public class Tauro extends Animal {

	public Tauro(int midaFinestaX, int midaFinestaY, boolean mascle) {
		super(midaFinestaX, midaFinestaY, mascle);

	}

	@Override
	protected void generaImatge() {
		String img = "";
		if (mascle == true) {
			if (horizontal == true) {
				if (direccio > 0) {
					img = "Taurons/TauroMascleDreta.png";
				} else {
					img = "Taurons/TauroMascleEsquerra.png";
				}
			} else {
				if (direccio > 0) {
					img = "Taurons/TauroMascleAbaix.png";
				} else {
					img = "Taurons/TauroMascleAmaon.png";
				}
			}
		} else {
			if (horizontal == true) {
				if (direccio > 0) {
					img = "Taurons/TauroFamellaDreta.png";
				} else {
					img = "Taurons/TauroFamellaEsquerra.png";
				}
			} else {
				if (direccio > 0) {
					img = "Taurons/TauroFamellaAbaix.png";
				} else {
					img = "Taurons/TauroFamellaAmon.png";
				}
			}
		}
		imatge = new GImage(img, posicioX, posicioY);
	}

	/**
	 * 3 tauro mata peix
	 */

	/*
	 * public int xoca(Animal p){ int resultat=0;
	 * if(this.getPosicio().intersects(p.getPosicio())){ resultat=3; } return
	 * resultat; }
	 */
	@Override
	public int xoca(Animal t) {
		int resultat = 0;
		if (t.getClass().equals(Peix.class)) {
			if (this.getPosicio().intersects(t.getPosicio())) {
				resultat = 3;
			}
		} else if (t.getClass().equals(Tauro.class)) {
			if (this.getPosicio().intersects(t.getPosicio())) {
				if (this.getMascle() == t.getMascle()) {
					resultat = 1;
				} else {
					if (this.getEsteril() == false && t.getEsteril() == false) {
						resultat = 2;
					}
				}
			}
		}
		return resultat;
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
			if (imatge.getLocation().getX() > midaFinestraX) {
				imatge.setLocation(0 - imatge.getBounds().getWidth(), posicioY);
			} else if (imatge.getLocation().getX() < 0 - imatge.getBounds().getWidth()) {
				imatge.setLocation(midaFinestraX, posicioY);
			}
		} else {
			if (imatge.getLocation().getY() > midaFinestraY) {
				imatge.setLocation(posicioX, 0 - imatge.getBounds().getHeight());
			} else if (imatge.getLocation().getY() < 0 - imatge.getBounds().getHeight()) {
				imatge.setLocation(posicioX, midaFinestraY);
			}
		}

		contedorEsteril = contedorEsteril - velocitat;
		if (contedorEsteril <= 0) {
			esteril = false;
		}
	}
}
