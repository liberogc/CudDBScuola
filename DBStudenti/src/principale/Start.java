package principale;

import dao.DaoStudenti;
import modelli.Studenti;

public class Start {

	public static void main(String[] args) {
		boolean continua=true;
		Generica generica = new Generica();
		DaoStudenti daostu = new DaoStudenti();
		
		while(continua){
			generica.menu1();
			int scelta=generica.insNumero("Inserire una Scelta");
			
			switch (scelta) {
			case 0:
				continua=false;
				break;
			case 1:
				// inserire studenti
				Studenti studente=daostu.creaOggetto();
				daostu.salvaOggetto(studente);
				break;
			case 2:
				
				break;
			case 3:
							
				break;
			case 4:
				
				break;
			}
		}

	}

}
