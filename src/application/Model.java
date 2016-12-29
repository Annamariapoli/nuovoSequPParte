package application;

import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.Graphs;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;

import bean.Parola;
import db.Dao;

public class Model {
	
	private Dao dao = new Dao();
	private UndirectedGraph<Parola, DefaultEdge> grafo = null;
	
	public UndirectedGraph<Parola, DefaultEdge> getGrafo() {
		return grafo;
	}

	public void setGrafo(UndirectedGraph<Parola, DefaultEdge> grafo) {
		this.grafo = grafo;
	}

	public boolean isPresente(String nome){
		return dao.isPresente(nome);
	}
	
	public int conta(int lun){
		int conta = dao.numeroParoleLunghezza(lun);
		return conta;
	}
	
	public List<Parola> getParole(int lung){
		List<Parola> que = dao.getParole(lung);
		return que;
	}
	
	public boolean getUnaSolaLettera(String n1, String n2){    //ok
		int contaDifferenza =0;
		if(n1!=null && n2!=null){
		  if(isPresente(n1) && isPresente(n2)){
			 if(!n1.equals(n2)){
			    int lung1 = n1.length();
			    int lung2 = n2.length();
			    if(lung1==lung2){
				for(int i =0; i<n1.length() && i<n2.length() ;  i++){
					if(n1.charAt(i)!= n2.charAt(i)){
						contaDifferenza++;
					}
				 }
			  }
		   }
	     }
      }
		if(contaDifferenza==1){
			return true;
		}
		return false;
	}
	
	public UndirectedGraph<Parola, DefaultEdge> buildGraph(int lung){
		grafo = new SimpleGraph<Parola, DefaultEdge>(DefaultEdge.class);
		List<Parola> que = getParole(lung);
		Graphs.addAllVertices(grafo, que);  //vertici sono parole di quella lunghezza
		for(Parola p1 : que){
			for(Parola p2: que){
				if(getUnaSolaLettera(p1.getNome(), p2.getNome())){
					grafo.addEdge(p1, p2);
				}
			}
		}
		//System.out.println(grafo.toString());
		return grafo;
	}
	
	public int numeVertici(UndirectedGraph<Parola, DefaultEdge> grafo){   //ok
		int num = grafo.vertexSet().size();
		return num;	
	}
	
	public int numeArchi(UndirectedGraph<Parola, DefaultEdge> grafo){   //ok
		int num = grafo.edgeSet().size();
		return num;		
	}
	
	public Parola getNomePiuCollegamenti(UndirectedGraph<Parola, DefaultEdge> grafo){
		int max =0;
		Parola trovata = null;
		for(Parola p : grafo.vertexSet()){
			BreadthFirstIterator<Parola, DefaultEdge> visita = new BreadthFirstIterator<Parola, DefaultEdge>(grafo,p);
			int contatore=0;
			while(visita.hasNext()){
				Parola ptemp = visita.next();
				if(contatore !=0){
					contatore ++;
				}
			}
			if(contatore > max){
				trovata = p;
				max=contatore;
			}
		}
		System.out.println(trovata);
		return trovata;	
	}
	
	
	
	
	

	public static void main(String [] args){
		Model m = new Model();
	//	m.getUnaSolaLettera("cosa", "cose");
		UndirectedGraph<Parola, DefaultEdge> grafo = m.buildGraph(2);
		Parola p = m.getNomePiuCollegamenti(grafo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private UndirectedGraph<String, DefaultEdge> grafo = null;
//	
//	public boolean isPres(String nome){
//		return dao.isPresente(nome);
//	}
//
//	public int conta(int lun){
//		return dao.contaParoleLunghezza(lun);
//	}
//	
//	
//	public List<String> getParoleLung(int lungh){
//		List<String> qu = dao.getParoleLunghezza(lungh);
//		return qu;
//	}
	
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
	
//	public UndirectedGraph<String, DefaultEdge> buildGraph(int lung){                 //credo sia giusto
//		grafo = new SimpleGraph<>(DefaultEdge.class);
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
//		return grafo;
//		
//	}
//	
//	public int numeroArchi(Graph<String, DefaultEdge> grafo){
//		int numeroA= 0;
//		for(DefaultEdge edge :grafo.edgeSet()){
//        	numeroA++;
//        }
//		return numeroA;
//	}
//	
//
//	public int numeroVertici(Graph<String, DefaultEdge> grafo){
//		int numeroVertici = 0;
//		for(String v :grafo.vertexSet()){
//        	numeroVertici++;
//        }
//		return numeroVertici;
//	}
//	
//	
//	public String parolaPiuCollegata(UndirectedGraph<String, DefaultEdge> grafo){
//	int max = 0;
//	String best=null;
//	for (String v : grafo.vertexSet()) {
//		BreadthFirstIterator<String, DefaultEdge> bfs = new BreadthFirstIterator<String, DefaultEdge>(grafo, v);
//		int contatore = 0;
//		while (bfs.hasNext()) {                          //scandisce, itera
//			String temp = bfs.next();
//			contatore++;
//		}
//		if (contatore > max) {
//			 best = v;
//			max = contatore;
//		}
//	}
//		return best;
//	
//	}
//	
//	public List<String> getCammino(String s1, String s2){
//		DijkstraShortestPath<String, DefaultEdge> di = new DijkstraShortestPath<String, DefaultEdge>(grafo, s1, s2);
//		GraphPath <String, DefaultEdge> path= di.getPath();
//		if(path==null){
//			return null;
//		}
//		List<String> per = Graphs.getPathVertexList(path);
//		return per;
//	}
//	
//	
//	
//	public boolean  differiscono(String p1, String p2){     //funziona
//		int conta=0;
//		
//		int lung1= p1.length();
//		int lung2= p2.length();
//		if(p1.equals(p2)){
//			System.out.println(false);
//			return false;
//		}	
//		if(lung1!= lung2){
//			System.out.println(false);
//			return false;
//		}		
//		for(int i =0; i<p1.length() && i<p2.length(); i++){
//			if(p1.charAt(i) != p2.charAt(i)){
//				conta++;
//			}
//		}
//		if(conta==1){
//			System.out.println(true);
//			return true;
//		}
//		System.out.println(false);
//		return false;
//		
//		
//	}
	
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
