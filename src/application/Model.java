package application;

import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;

import bean.Parola;
import db.Dao;

public class Model {
	
	private Dao dao = new Dao();
	private UndirectedGraph<String, DefaultEdge> grafo = null;
	
	public boolean isPres(String nome){
		return dao.isPresente(nome);
	}

	public int conta(int lun){
		return dao.contaParoleLunghezza(lun);
	}
	
	
	public List<String> getParoleLung(int lungh){
		List<String> qu = dao.getParoleLunghezza(lungh);
		return qu;
	}
	
//	
//	public int numeroVertici(int lun){
//		int numeroVertici = getParoleLung(lun).size();
//		return numeroVertici;
//	}
//	
//	public int numeroArchi(int lun){
//		int numeroA=0;
//        for(DefaultEdge edge :grafo.edgeSet()){
//        	numeroA++;
//        }
//        System.out.println(numeroA);
//		return numeroA;
//	}
//	
	
//	public void buildGraph(int lung){                 //credo sia giusto
//		grafo= new SimpleGraph<>(DefaultEdge.class);
//		List<String> vertici= getParoleLung(lung);
//		Graphs.addAllVertices(grafo, vertici);
//		for(String p1 : vertici){
//			for(String p2 : vertici){
//				if(differiscono(p1,p2)){
//					grafo.addEdge(p1, p2);
//				}
//			}
//		}
//		System.out.println(grafo.toString());
//		
//	}
	
	public UndirectedGraph<String, DefaultEdge> buildGraph(int lung){                 //credo sia giusto
		grafo = new SimpleGraph<>(DefaultEdge.class);
		List<String> vertici= getParoleLung(lung);
		Graphs.addAllVertices(grafo, vertici);
		for(String p1 : vertici){
			for(String p2 : vertici){
				if(differiscono(p1,p2)){
					grafo.addEdge(p1, p2);
				}
			}
		}
		System.out.println(grafo.toString());
		return grafo;
		
	}
	
	public int numeroArchi(Graph<String, DefaultEdge> grafo){
		int numeroA= 0;
		for(DefaultEdge edge :grafo.edgeSet()){
        	numeroA++;
        }
		return numeroA;
	}
	

	public int numeroVertici(Graph<String, DefaultEdge> grafo){
		int numeroVertici = 0;
		for(String v :grafo.vertexSet()){
        	numeroVertici++;
        }
		return numeroVertici;
	}
	
	
	public String parolaPiuCollegata(UndirectedGraph<String, DefaultEdge> grafo){
	int max = 0;
	String best=null;
	for (String v : grafo.vertexSet()) {
		BreadthFirstIterator<String, DefaultEdge> bfs = new BreadthFirstIterator<String, DefaultEdge>(grafo, v);
		int contatore = 0;
		while (bfs.hasNext()) {                          //scandisce, itera
			String temp = bfs.next();
			contatore++;
		}
		if (contatore > max) {
			 best = v;
			max = contatore;
		}
	}
		return best;
	
	}
	
	
	
	
	
	public boolean  differiscono(String p1, String p2){     //funziona
		int conta=0;
		
		int lung1= p1.length();
		int lung2= p2.length();
		if(p1.equals(p2)){
			System.out.println(false);
			return false;
		}
		if(p1.equals(p2)){
			System.out.println(false);
			return false;
		}		
		if(lung1!= lung2){
			System.out.println(false);
			return false;
		}		
		for(int i =0; i<p1.length() && i<p2.length(); i++){
			if(p1.charAt(i) != p2.charAt(i)){
				conta++;
			}
		}
		if(conta==1){
			System.out.println(true);
			return true;
		}
		System.out.println(false);
		return false;
		
		
	}
	
//	public static void main(String [] args){
//		Model m = new Model();
//		Parola p1 = new Parola(1, "casa");
//		Parola p2 = new Parola(2, "casa");
//		
//		
//		m.buildGraph(2);
//		m.numeroArchi(2);
//		m.numeroVertici(1);
//		m.numeroArchi(1);
//	}
}