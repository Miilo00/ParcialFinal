package co.edu.poli.Examen2.puertos;

import co.edu.poli.Examen2.dominio.ExamenSangre;

import java.util.List;

/**
 * Puerto de entrada que expone los casos de uso a los adaptadores de interfaz.
 */
public interface PuertoExamenEntrada {
    ExamenSangre registrar(String codigo, String nombre, String costo,
                           String tipoSangre, String factorRH);
    List<ExamenSangre> listar();
    void serializar();
    void deserializar();
}
