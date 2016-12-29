package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBConnect {
	
//
//	private static final String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root&password=" ;
//	
//	private static ComboPooledDataSource dataSource = null ;  //memorizzo una variabile ke si ricorda se il connection pool è gia stato creato oppure no
//	
//	public static Connection getConnection() {
//		
//		Connection conn;
//		try {
//			if(dataSource==null) {      //mi kiedo se il datasource è gia stato creato
//				                       //se è ancora null devo crearlo e attivarlo
//				                      //altrimenti restituisco la connessione
//				
//				// creare ed attivare il Connection Pool
//				dataSource = new ComboPooledDataSource() ;    //creo nuovo connection pool
//				dataSource.setJdbcUrl(jdbcURL);              //dico a ogg datasource a cosa collegarsi
//			}
//			
//			return dataSource.getConnection();        //restituisco la connessione  //kiedo la connessione al datasource stesso 
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new RuntimeException("Errore nella connessione", e) ;
//		}
//	}

	
private final static String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root&password=" ;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
		} catch (ClassNotFoundException e) {
			      e.printStackTrace();
			      throw new RuntimeException("Driver JDBC non trovato", e) ; 
		        }
		Connection c;
		try {
			c = DriverManager.getConnection(jdbcURL);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossibile connettersi al database", e) ; 
		}
		
		return c ;
		
	}
}
