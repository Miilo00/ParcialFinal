module co.edu.poli.Examen2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.poli.Examen2.adaptadores.entrada to javafx.fxml;

    exports co.edu.poli.Examen2.vista;
    exports co.edu.poli.Examen2.dominio;
    exports co.edu.poli.Examen2.aplicacion;
    exports co.edu.poli.Examen2.puertos;
    exports co.edu.poli.Examen2.adaptadores.entrada;
    exports co.edu.poli.Examen2.adaptadores.salida;
}
