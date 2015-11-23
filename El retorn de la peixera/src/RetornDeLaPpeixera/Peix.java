package RetornDeLaPpeixera;

import acm.graphics.GImage;

public class Peix extends Animal{

	public Peix(int midaFinestaX, int midaFinestaY, boolean mascle) {
		super(midaFinestaX, midaFinestaY, mascle);
		// TODO Auto-generated constructor stub
	}

	//Depen de la direcció agafa una imatge o una altre
	@Override
	protected void generaImatge() {
		String img="";
		if(mascle==true){
			if(horizontal==true){
				if(direccio>0){
					img="Peixos/PeixMascleDreta.png";
				}else{
					img="Peixos/PeixMascleEsquerra.png";
				}
			}else{
				if(direccio>0){
					img="Peixos/PeixMascleAbaix.png";
				}else{
					img="Peixos/PeixMascleAmon.png";
				}
			}
		}else{
			if(horizontal==true){
				if(direccio>0){
					img="Peixos/PeixFamellaDreta.png";
				}else{
					img="Peixos/PeixFamellaEsquerra.png";
				}
			}else{
				if(direccio>0){
					img="Peixos/PeixFamellaAbaix.png";
				}else{
					img="Peixos/PeixFamellaAmon.png";
				}
			}
		}
		imatge=new GImage(img, posicioX,posicioY);
		
	}

	@Override
	public int xoca(Animal p) {
		int resultat=0;
		if(this.getPosicio().intersects(p.getPosicio())){
			if(this.getMascle()==p.getMascle()){
				resultat=1;
			}else{
				if(this.getEsteril()==false && p.getEsteril()==false){
					resultat=2;
				}
			}
		}
		return resultat;
	}

}
