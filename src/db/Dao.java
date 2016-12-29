package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import bean.Parola;

public class Dao {
	
	public boolean isPresente(String nome){
		Connection conn = DBConnect.getConnection();
		String query = "select * from parola where nome=?";
		try{
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, nome);
			ResultSet res = st.executeQuery();
			if(res.next()){
				return true;
			} else {
				return false;
			}
		}catch(SQLException e ){
			e.printStackTrace();
			return false;
		}
	}
	
	public int numeroParoleLunghezza(int lun){
		Connection conn = DBConnect.getConnection();
		String query = "select count(*) as conta from parola where LENGTH(nome)=?";
		int conta =-1;
		try{
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, lun);
			ResultSet res = st.executeQuery();
			if(res.next()){
				conta = res.getInt("conta");	
			}
			conn.close();
			return conta;
			
		}catch(SQLException e ){
			e.printStackTrace();
			return -1;
		}
	}
	
	public List<Parola> getParole(int lung){
		Connection conn = DBConnect.getConnection();
		String query ="select * from parola where LENGTH(nome)=?";
		List<Parola> que = new LinkedList<Parola>();
		try{
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt (1, lung);
			ResultSet res = st.executeQuery();
			while(res.next()){
				Parola p = new Parola(res.getInt("id"), res.getString("nome"));
				que.add(p);
			} 
			conn.close();
			return que;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
//	public boolean isPresente(String nome){
//		Connection conn =DBConnect.getConnection();
//		String query= "select * from parola where nome=?";
//		try{
//			PreparedStatement st = conn.prepareStatement(query);
//			st.setString(1, nome);
//			ResultSet res = st.executeQuery();
//			if(res.next()){
//				return true;
//			} else {
//				return false;
//			}
//			
//		}catch(SQLException e ){
//			e.printStackTrace();
//			return false;
//		}
//	}
//
//	public int contaParoleLunghezza(int lun){             //funziona
//		Connection conn =DBConnect.getConnection();
//		String query="select count(*) as conta from parola where LENGTH(nome)=?";
//		int conta=0;    //no parole di questa lunghezza
//		try{
//			PreparedStatement st = conn.prepareStatement(query);
//			st.setInt(1, lun);
//			ResultSet res = st.executeQuery();
//			if(res.next()){
//				conta=res.getInt("conta");
//			}
//			res.close();
//			st.close();
//			conn.close();		
//			return conta;		
//		}catch(SQLException e ){
//			e.printStackTrace();
//			return conta =-1;         //qualcosa è sbagliato
//		}
//	}
	
//	public List<String> getParoleLunghezza(int lun){             //funziona
//		Connection conn =DBConnect.getConnection();
//		String query="select *  from parola where LENGTH(nome)=?";
//		List<String> queste = new LinkedList<String>();
//		try{
//			PreparedStatement st = conn.prepareStatement(query);
//			st.setInt(1, lun);
//			ResultSet res = st.executeQuery();
//			while(res.next()){
//				queste.add(res.getString("nome"));				
//			}
//			conn.close();		
//			return queste;		
//		}catch(SQLException e ){
//			e.printStackTrace();
//			return null;      
//		}
//	}
//	
}
