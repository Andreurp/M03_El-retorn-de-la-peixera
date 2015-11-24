package RetornDeLaPpeixera;

import java.util.List;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class Main extends GraphicsProgram{

	private static final int MIDA_Altura_Finestre = 650;
	private static final int MIDA_Amplada_Finestre = 1350;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() {
		//mida de la pantalla i color fons
	    setSize(MIDA_Amplada_Finestre, MIDA_Altura_Finestre);
	    GImage fons = new GImage("fons.jpg");
		fons.setSize(MIDA_Amplada_Finestre, MIDA_Altura_Finestre);
		add(fons);
	}
	
	public void run(){
		
		//crea la paixera
		Peixera aquari=new Peixera();
		List<Animal>animals=aquari.getAnimals();
		//dibuixar peixos
		for(Animal p: animals){
			add(p.getImatge());
		}
		
		
		while(!aquari.gameOver()){
			aquari.mou();
			//eliminar de la pantalla els morts
			for(Animal p:	aquari.getMorts()){
				remove(p.getImatge());
			}
			//afagir a la pantalla els bebes
			for(Animal p:	aquari.getBebes()){
				add(p.getImatge());
			}
			pause(100);
		}
	}
}
