package application;

import java.net.URL;
import java.util.ResourceBundle;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;

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
    	int lunghezza= Integer.parseInt(txtLung.getText());
    	int numero = model.conta(lunghezza);
    	if(numero==0){
    		txtResult.appendText("Non ci sono parole di quella lunghezza!\n");
    		return;
    	}
    	txtResult.appendText("Le parola di questa lunghezza sono : "+numero+"\n ");
    	UndirectedGraph<String , DefaultEdge> grafo = model.buildGraph(lunghezza);
    	int numeroV = model.numeroVertici(grafo);  	
    	int numeroA=model.numeroArchi(grafo);
    	String parola = model.parolaPiuCollegata(grafo);	
    	txtResult.appendText("E' stato costruito un grafo di :"+numeroV+" vertici, e di "+numeroA+"  archi!\n La parola piu collegata è "+parola);
    	
//    	model.buildGraph(lunghezza);   	
//    	int vertici = model.numeroVertici(lunghezza);
//    	int archi =model.numeroArchi(lunghezza);  	
//    	String parola = model.parolaPiuCollegata(grafo);
//    	txtResult.appendText("E' stato costruito un grafo di :"+vertici+" vertici, e di "+archi+"  archi!\n");
    	}catch(Exception e ){
    		txtResult.appendText("Errore, inserisci un numero valido! \n ");
    		return;
    	}
    }

    @FXML
    void doCerca(ActionEvent event) {

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

