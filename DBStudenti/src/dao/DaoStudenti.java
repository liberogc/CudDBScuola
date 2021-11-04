package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import connessione.ConnettiSchema;
import interfacce.IDaoStudenti;
import modelli.Studenti;
import principale.Generica;

public class DaoStudenti extends ConnettiSchema implements IDaoStudenti {
	PreparedStatement pst=null;
	Statement st=null;
	
	Studenti stu = new Studenti();
	Generica generica = new Generica();
	ArrayList<Studenti> alstu = new ArrayList<Studenti>();
	ResultSet rs=null;
	String query=null;	
	
	@Override
	public Studenti creaOggetto() {
		// valorizzare gli attributi
		stu.setCognome(generica.insTesto("Inserire il cognome"));
		stu.setNome(generica.insTesto("Inserire il nome"));
		stu.setFacolta(generica.insTesto("Inserire la Facoltà"));
		stu.setMatricola(generica.insNumero("Inserire una Matricola"));
		return stu;
	}

	@Override
	public void salvaOggetto(Studenti stu) { // query
		query="INSERT INTO studenti (nome,cognome,facolta,matricola) VALUES (?,?,?,?)";
		try {
			pst=connettiDB().prepareStatement(query);
			pst.setString(1, stu.getNome());
			pst.setString(2, stu.getCognome());
			pst.setString(3, stu.getFacolta());
			pst.setInt(4, 22);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}		
	}

	@Override
	public ArrayList<Studenti> RsToArray(ResultSet result) {
		try {
			while(result.next()) {
				Studenti stu = new Studenti();
				stu.setNome(result.getString("nome"));
				stu.setCognome(result.getString("cognome"));
				stu.setFacolta(result.getString("facolta"));
				stu.setMatricola(result.getInt("matricola"));
				alstu.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return alstu;
	}

	@Override
	public void listaStudenti(ArrayList<Studenti> al) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet cercaFacoltaStu() {
		String cercafacolta=generica.insTesto("Filtra la Facoltà:");
		query = "SELECT * FROM studenti WHERE facolta=?";
		try {
			pst=connettiDB().prepareStatement(query);
			pst.setString(1, cercafacolta);
			rs=pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
	
}
