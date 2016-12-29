package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import bean.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SampleController {
	private Model model= new Model();
	
	public void setModel(Model model){
		this.model=model;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtLung;

    @FXML
    private Button btnCarica;

    @FXML
    private TextField txtIniziale;

    @FXML
    private TextField txtFinale;

    @FXML
    private Button btnCerca;

    @FXML
    private TextArea txtResult;

    @FXML
    void doCarica(ActionEvent event) {
    	txtResult.clear();
    	try{
    		int lun = Integer.parseInt(txtLung.getText());
    		if(lun ==0){
    			txtResult.appendText("Non ci sono parole di questa lunghezza!\n");
    			return;
    		}
    		
    		int conta = model.conta(lun);
    		UndirectedGraph<Parola, DefaultEdge> grafo = model.buildGraph(lun);
    		int vertici = model.numeVertici(grafo);
    		int archi =model.numeArchi(grafo);
    		Parola p = model.getNomePiuCollegamenti(grafo);
    		
    		txtResult.appendText("Il numero delle parole di questa lunghezza è : " +conta+" \n ");
    		txtResult.appendText("Il numero totale di vertici del grafo è : " +vertici+" \n");
    		txtResult.appendText("Il numero totale di archi del grafo è : " +archi+" \n");
    		txtResult.appendText("La parola che ha piu collegamenti è : "+ p.getNome());
    	
    	}catch(Exception e ){
    		txtResult.appendText("Errore nel formato!\n");
    		return;
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
//    	txtResult.clear();
//    	try{
//    	int lunghezza= Integer.parseInt(txtLung.getText());
//    	int numero = model.conta(lunghezza);
//    	if(numero==0){
//    		txtResult.appendText("Non ci sono parole di quella lunghezza!\n");
//    		return;
//    	}
//    	txtResult.appendText("Le parola di questa lunghezza sono : "+numero+"\n ");
//    	UndirectedGraph<String , DefaultEdge> grafo = model.buildGraph(lunghezza);
//    	int numeroV = model.numeroVertici(grafo);  	
//    	int numeroA=model.numeroArchi(grafo);
//    	String parola = model.parolaPiuCollegata(grafo);	
//    	txtResult.appendText("E' stato costruito un grafo di :"+numeroV+" vertici, e di "+numeroA+"  archi!\n La parola piu collegata è "+parola);
//    	
//    	model.buildGraph(lunghezza);   	
//    	int vertici = model.numeroVertici(lunghezza);
//    	int archi =model.numeroArchi(lunghezza);  	
//    	String parola = model.parolaPiuCollegata(grafo);
//    	txtResult.appendText("E' stato costruito un grafo di :"+vertici+" vertici, e di "+archi+"  archi!\n");
//    	}catch(Exception e ){
//    		txtResult.appendText("Errore, inserisci un numero valido! \n ");
//    		return;
//    	}
//    }

    @FXML
    void doCerca(ActionEvent event) {
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
//    	txtResult.appendText("\n");
//    	String in = txtIniziale.getText();
//    	String fin =txtFinale.getText();
//    	if(in == null || fin == null){
//    		txtResult.appendText("Inserisci due parole!\n");
//    		return;
//    	}
//    	for(int i =0; i<fin.length() && i<in.length(); i++){
//    		if(!Character.isLetter(fin.charAt(i))  ||!Character.isLetter(in.charAt(i)) ){
//    			txtResult.appendText("Il formato non è corretto!\n");
//    			return;
//    		}
//    	}
//    	int lunghezza= Integer.parseInt(txtLung.getText());
//    	int l1 = in.length();
//    	int l2 = fin.length();
//    	
//    	if(l1 == l2 && l2 ==lunghezza){
//    		if(model.isPres(in) && model.isPres(fin)){
//    			List<String> percorso = model.getCammino(in, fin);
//    			if(percorso.isEmpty()){
//    				txtResult.appendText("Il cammino non esiste!\n");
//    				return;
//    				
//    			} else {
//    				txtResult.appendText("il cammino è : "+percorso.toString());
//    			}
//    	    	
//        	  }
//    		    else {
//        		txtResult.appendText("Una delle due parole non è presente nel dizionario!\n ");
//        		return;		
//    	        }
//    	}else {
////    			txtResult.appendText("La lunghezza delle parole non è corretta!\n");
//    			return;
//    		}
//    	

    }

    @FXML
    void initialize() {
        assert txtLung != null : "fx:id=\"txtLung\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnCarica != null : "fx:id=\"btnCarica\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txtIniziale != null : "fx:id=\"txtIniziale\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txtFinale != null : "fx:id=\"txtFinale\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Sample.fxml'.";

    }
}

