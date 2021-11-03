package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import connessione.ConnettiSchema;
import interfacce.IDaoStudenti;
import modelli.Studenti;
import principale.Generica;

public class DaoStudenti implements IDaoStudenti {
	PreparedStatement pst=null;
	Studenti stu = new Studenti();
	Generica generica = new Generica();
	ConnettiSchema connetti = new ConnettiSchema();
	String query=null;
	
	
	@Override
	public Studenti creaOggetto() {
		// valorizzare gli attributi
		stu.setCognome(generica.insTesto("Inserire il cognome"));
		stu.setNome(generica.insTesto("Inserire il nome"));
		
		return stu;
	}

	@Override
	public void salvaOggetto(Studenti stu) { // query
		Connection connesso=connetti.connettiDB();
		query="INSERT INTO studenti (nome,cognome,facolta,matricola) VALUES (?,?,?,?)";
		try {
			pst=connesso.prepareStatement(query);
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
	
}
