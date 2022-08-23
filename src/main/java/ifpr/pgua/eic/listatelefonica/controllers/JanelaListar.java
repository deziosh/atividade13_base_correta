package ifpr.pgua.eic.listatelefonica.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.listatelefonica.App;
import ifpr.pgua.eic.listatelefonica.models.Contato;
import ifpr.pgua.eic.listatelefonica.models.ListaTelefonica;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class JanelaListar implements Initializable{

    @FXML
    private ListView<Contato> ltvContatos;

    @FXML
    private TextArea taDetalhes;

    @FXML
    private TextField tfPesquisar;

    private ListaTelefonica listaTelefonica;

    public JanelaListar(ListaTelefonica ListaTelefonica){
        this.listaTelefonica = ListaTelefonica;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
 
        ltvContatos.getItems().clear();
        
        ltvContatos.getItems().addAll(listaTelefonica.getContatos());    
    }

    @FXML
    private void mostrarDetalhes(MouseEvent evento){
        Contato contatos = ltvContatos.getSelectionModel().getSelectedItem();

        if(contatos != null){
            taDetalhes.clear();
            taDetalhes.appendText("Nome: "+contatos.getNome()+"\n");
            taDetalhes.appendText("Telefone: "+contatos.getTelefone()+"\n");
            taDetalhes.appendText("Email: "+contatos.getEmail()+"\n");
        }
    }

    @FXML
    private void pesquisar(){
        String nome = tfPesquisar.getText();

        ltvContatos.getItems().clear();

        ltvContatos.getItems().addAll(listaTelefonica.buscaPorNome(nome));

    }

    @FXML
    private void voltar(){
        App.popScreen();
    }

}
