package co.edu.poli.Examen2.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import co.edu.poli.Examen2.adaptadores.salida.FileSerializacionAdapter;
import co.edu.poli.Examen2.aplicacion.ExamenService;
import co.edu.poli.Examen2.adaptadores.salida.RepositorioExamenEnMemoria;
import co.edu.poli.Examen2.adaptadores.entrada.ControladorPrincipal;
import co.edu.poli.Examen2.puertos.PuertoExamenEntrada;

import java.io.IOException;

/**
 * Punto de entrada JavaFX y raíz de composición de dependencias.
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        PuertoExamenEntrada casoDeUso = new ExamenService(
                new RepositorioExamenEnMemoria(),
                new FileSerializacionAdapter("examenes.dat"));
        scene = new Scene(loadFXML("/co/edu/poli/Examen2/primary", casoDeUso), 640, 620);
        stage.setTitle("Exámenes de Sangre");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private static Parent loadFXML(String fxml, PuertoExamenEntrada casoDeUso) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        fxmlLoader.setControllerFactory(tipoControlador -> new ControladorPrincipal(casoDeUso));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}