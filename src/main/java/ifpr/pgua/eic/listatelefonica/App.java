package ifpr.pgua.eic.listatelefonica;

import ifpr.pgua.eic.listatelefonica.controllers.JanelaCadastro;
import ifpr.pgua.eic.listatelefonica.controllers.JanelaListar;
import ifpr.pgua.eic.listatelefonica.controllers.JanelaPrincipal;
import ifpr.pgua.eic.listatelefonica.models.ListaTelefonica;
import ifpr.pgua.eic.listatelefonica.utils.BaseAppNavigator;
import ifpr.pgua.eic.listatelefonica.utils.ScreenRegistryFXML;

public class App extends BaseAppNavigator {

    private ListaTelefonica listatelefonica;

    @Override
    public void init() throws Exception {
        super.init();

        listatelefonica = new ListaTelefonica();
    }

    @Override
    public String getHome() {
        return "PRINCIPAL";
    }

    @Override
    public String getAppTitle() {
        return "Lista Telefonica";
    }

    //registro de todas as telas da aplicação
    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(App.class, "principal.fxml", o->new JanelaPrincipal()));
        registraTela("CADASTRO", new ScreenRegistryFXML(App.class, "cadastro.fxml", o->new JanelaCadastro(listatelefonica)));
        registraTela("LISTAR", new ScreenRegistryFXML(App.class, "listar.fxml", o->new JanelaListar(listatelefonica)));
        
    }

    

}