package RetornDeLaPpeixera;

import java.util.ArrayList;
import java.util.List;

public class Peixera {

	private static final int N_Peixos = 4;
	private static final int N_Taurons = 4;
	private static final int N_Tortugues = 4;
	private static final int N_Dofins = 4;
	private static final int N_Crancs = 2;
	private static final int N_Pops = 2;
	
	List<Animal> animals = new ArrayList<Animal>();
	List<Animal> aMorts = new ArrayList<>();
	List<Animal> aBebe = new ArrayList<>();
	
	private int nPeixos;
	private int nTaurons;
	private int nTortugues;
	private int nDofins;

	public Peixera() {
		nPeixos = 0;
		nTaurons = 0;
		nTortugues=0;
		nDofins=0;
		// crear peixos
		for (int i = 0; i < N_Peixos; i++) {
			boolean sexe = (nPeixos % 2 == 0);
			Animal p = new Peix(1000, 600, sexe);
			animals.add(p);
			nPeixos++;
		}
		for (int i = 0; i < N_Taurons; i++) {
			boolean sexe = (nTaurons % 2 == 0);
			Tauro t = new Tauro(1000, 600, sexe);
			animals.add(t);
			nTaurons++;
		}
		for (int i = 0; i < N_Tortugues; i++) {
			boolean sexe = (nTortugues % 2 == 0);
			Tortuga t = new Tortuga(1000, 600, sexe);
			animals.add(t);
			nTortugues++;
		}
		for (int i = 0; i < N_Dofins; i++) {
			boolean sexe = (nDofins% 2 == 0);
			Dofi t = new Dofi(1000, 600, sexe);
			animals.add(t);
			nDofins++;
		}
		for (int i = 0; i < N_Crancs; i++) {
			Cranc t = new Cranc(1000, 600, true);
			animals.add(t);
		}
		for (int i = 0; i < N_Pops; i++) {
			Pop t = new Pop(1000, 600, true);
			animals.add(t);
		}
	}

	public void mou() {
		for (Animal p : animals) {
			p.mou();
		}

		// mata o cria
		aBebe.clear();
		aMorts.clear();
		for (Animal p : animals) {
			for (Animal q : animals) {
				if (!p.equals(q)) {
					switch (p.xoca(q)) {
					case 0:
						// no cal fer res
						break;
					case 1:
						// mata
						aMorts.add(q);
						aMorts.add(p);
						break;
					case 2:
						// cria
						if (p.getClass().equals(Peix.class)) {
							boolean sexe = (nPeixos % 2 == 0);
							Peix b = new Peix(1000, 600, sexe);
							aBebe.add(b);
							nPeixos++;
						}else if (p.getClass().equals(Tauro.class)) {
							boolean sexe = (nTaurons % 2 == 0);
							Tauro b = new Tauro(1000, 600, sexe);
							aBebe.add(b);
							nTaurons++;
						}else if (p.getClass().equals(Tortuga.class)) {
							boolean sexe = (nTortugues % 2 == 0);
							Tortuga b = new Tortuga(1000, 600, sexe);
							aBebe.add(b);
							nTortugues++;
						}
						else if (p.getClass().equals(Dofi.class)) {
							boolean sexe = (nDofins % 2 == 0);
							Dofi b = new Dofi(1000, 600, sexe);
							aBebe.add(b);
							nDofins++;
						}
						p.setEsteril(true);
						q.setEsteril(true);
						break;
					case 3:
						aMorts.add(q);
						break;
					default:
						break;
					}
				}
			}
		}
		
		// eliminar els peixos morts de la llista de peixos
		for (Animal m : aMorts) {
			animals.remove(m);
		}
		// afageix el bebe a la llista peixos
		for (Animal b : aBebe) {
			animals.add(b);
		}
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public List<Animal> getMorts() {
		return aMorts;
	}

	public List<Animal> getBebes() {
		return aBebe;
	}

	// para el joc
	public boolean gameOver() {
		return (animals.size() <= 1);
	}
}
