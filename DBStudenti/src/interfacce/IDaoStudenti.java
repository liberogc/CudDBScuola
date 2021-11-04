package interfacce;

import java.sql.ResultSet;
import java.util.ArrayList;

import modelli.Studenti;

public interface IDaoStudenti {
	public Studenti creaOggetto();
	public void salvaOggetto(Studenti stu);
	
	public ResultSet cercaFacoltaStu();
	public ArrayList<Studenti> RsToArray(ResultSet result);
	public void listaStudenti(ArrayList<Studenti> al);
}
