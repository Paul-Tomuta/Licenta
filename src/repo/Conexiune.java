package repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import date.Persoana;
import main.Main;

public class Conexiune {
	
	
	public final static String interogarePersoane="SELECT * FROM `persoana`;";
	
	public final static String interograreSMS="SELECT * FROM `mesajesms`;";
	
	public final static String interograreEmail="SELECT * FROM `email`;";
	
	public final static String interograreEmailHtml="SELECT * FROM `emailhtml`;";
	
	private final String DB_NAME="DISEMINARE_APP";
	private final String user="root";
	private final String password="";
	
	private static Conexiune conexiune=null;
	private Connection connection;
	
	private Conexiune() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/diseminare_app",user,password);
			Statement stmt=connection.createStatement();  
			if(stmt!=null)
				Main.logger.info("Conexiune la baza de date cu succes!");
			else
				Main.logger.info("ERROR!");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}    
	}
	

	public String getDB_NAME() {
		return DB_NAME;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public Connection getConnection() {
		return connection;
	}
	
	public static Conexiune getInstance() {
		if(conexiune==null)
			conexiune=new Conexiune();
		return conexiune;
	}

}
