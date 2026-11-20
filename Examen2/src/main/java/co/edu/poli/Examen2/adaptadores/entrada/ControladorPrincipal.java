package co.edu.poli.Examen2.adaptadores.entrada;

import co.edu.poli.Examen2.dominio.ExamenSangre;
import co.edu.poli.Examen2.puertos.PuertoExamenEntrada;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorPrincipal {
    private final PuertoExamenEntrada casoDeUso;

    public ControladorPrincipal(PuertoExamenEntrada casoDeUso) {
        this.casoDeUso = casoDeUso;
    }

    @FXML private TextField txtCodigoExamen;
    @FXML private TextField txtNombrePaciente;
    @FXML private TextField txtCosto;
    @FXML private ComboBox<String> cmbTipoSangre;
    @FXML private RadioButton rbPositivo;
    @FXML private TextArea txtAreaMensajes;

    @FXML
    public void initialize() {
    }

    @FXML
    private void handleGuardar() {
        try {
            String factorRH = rbPositivo.isSelected() ? "POSITIVO" : "NEGATIVO";
            ExamenSangre examen = casoDeUso.registrar(
                    txtCodigoExamen.getText(),
                    txtNombrePaciente.getText(),
                    txtCosto.getText(),
                    cmbTipoSangre.getValue(),
                    factorRH);
            txtAreaMensajes.setText("Examen guardado: " + examen);
        } catch (RuntimeException excepcion) {
            txtAreaMensajes.setText("Error: " + excepcion.getMessage());
        }
    }

    @FXML
    private void handleLimpiar() {
        txtCodigoExamen.clear();
        txtNombrePaciente.clear();
        txtCosto.clear();
        cmbTipoSangre.getSelectionModel().clearSelection();
        rbPositivo.setSelected(true);
        txtAreaMensajes.clear();
    }

    @FXML
    private void handleSerializar() {
        try {
            casoDeUso.serializar();
            txtAreaMensajes.setText("Exámenes serializados correctamente.");
        } catch (RuntimeException excepcion) {
            txtAreaMensajes.setText("Error: " + excepcion.getMessage());
        }
    }

    @FXML
    private void handleDeserializar() {
        try {
            casoDeUso.deserializar();
            txtAreaMensajes.setText("Exámenes deserializados correctamente.");
            handleListar();
        } catch (RuntimeException excepcion) {
            txtAreaMensajes.setText("Error: " + excepcion.getMessage());
        }
    }

    @FXML
    private void handleListar() {
        java.util.List<ExamenSangre> examenes = casoDeUso.listar();
        if (examenes.isEmpty()) {
            txtAreaMensajes.setText("No hay exámenes registrados.");
            return;
        }
        StringBuilder salida = new StringBuilder();
        for (ExamenSangre examen : examenes) {
            salida.append(examen).append(System.lineSeparator());
        }
        txtAreaMensajes.setText(salida.toString());
    }
}
