package connessione;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnettiSchema {
	Connection conn;
	public Connection connettiDB() {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/scuola";
		String user="root";
		String pw="";
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("collegamento off "+e);
		}
		return conn;
		
		
	}
}
