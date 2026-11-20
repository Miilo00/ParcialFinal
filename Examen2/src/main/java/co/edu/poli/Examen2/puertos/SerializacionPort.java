package co.edu.poli.Examen2.puertos;

import co.edu.poli.Examen2.dominio.ExamenSangre;

import java.util.List;

/**
 * Puerto de salida para serializar y restaurar exámenes.
 */
public interface SerializacionPort {
    void serializar(List<ExamenSangre> examenes);
    List<ExamenSangre> deserializar();
}