package ifpr.pgua.eic.listatelefonica.controllers;

import ifpr.pgua.eic.listatelefonica.models.ListaTelefonica;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class JanelaCadastro{
    
    //declaração dos componentes JavaFX. O nome do atributo
    //deve ser igual a propriedade fx:id no FXML.

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfEmail;

    private ListaTelefonica listaTelefonica;

    public JanelaCadastro(ListaTelefonica listaTelefonica){
        this.listaTelefonica = listaTelefonica;
    }


    @FXML
    private void cadastrar(){
        String nome = tfNome.getText();
        String telefone = tfTelefone.getText();
        String email = tfEmail.getText();

        if(listaTelefonica.adicionarContato(nome, telefone, email)){
            Alert alert = new Alert(AlertType.INFORMATION,"Contato adicionado!");
            alert.showAndWait();
            limpar();
        }else{
            Alert alert = new Alert(AlertType.INFORMATION,"Contato não adicionado!");
            alert.showAndWait();  
        }
    }

    private void limpar(){
        tfNome.clear();
        tfTelefone.clear();
        tfEmail.clear();
    }

}
