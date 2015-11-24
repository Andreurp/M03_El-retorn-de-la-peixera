package RetornDeLaPpeixera;

import acm.graphics.GImage;

public class Peix extends Animal {

	public Peix(int midaFinestaX, int midaFinestaY, boolean mascle) {
		super(midaFinestaX, midaFinestaY, mascle);
		// TODO Auto-generated constructor stub
	}

	// Depen de la direcció agafa una imatge o una altre
	@Override
	protected void generaImatge() {
		String img = "";
		if (mascle == true) {
			if (horizontal == true) {
				if (direccio > 0) {
					img = "Peixos/MascleDreta.png";
				} else {
					img = "Peixos/MascleEsquerra.png";
				}
			} else {
				if (direccio > 0) {
					img = "Peixos/MascleAbaix.png";
				} else {
					img = "Peixos/MascleAmon.png";
				}
			}
		} else {
			if (horizontal == true) {
				if (direccio > 0) {
					img = "Peixos/FamellaDreta.png";
				} else {
					img = "Peixos/FamellaEsquerra.png";
				}
			} else {
				if (direccio > 0) {
					img = "Peixos/FamellaAbaix.png";
				} else {
					img = "Peixos/FamellaAmon.png";
				}
			}
		}
		imatge = new GImage(img, posicioX, posicioY);

	}

	@Override
	public int xoca(Animal p) {
		int resultat = 0;
		if (p.getClass().equals(Peix.class)) {
			if (this.getPosicio().intersects(p.getPosicio())) {
				if (this.getMascle() == p.getMascle()) {
					resultat = 1;
				} else {
					if (this.getEsteril() == false && p.getEsteril() == false) {
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
