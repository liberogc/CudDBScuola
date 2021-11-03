package interfacce;

import modelli.Studenti;

public interface IDaoStudenti {
	public Studenti creaOggetto();
	public void salvaOggetto(Studenti stu);
}
