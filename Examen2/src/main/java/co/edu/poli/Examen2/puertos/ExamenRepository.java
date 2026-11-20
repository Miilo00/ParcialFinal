package co.edu.poli.Examen2.puertos;

import co.edu.poli.Examen2.dominio.ExamenSangre;

import java.util.List;

/**
 * Puerto de salida para guardar y recuperar exámenes.
 */
public interface ExamenRepository {
    void guardar(ExamenSangre examen);
    List<ExamenSangre> listar();
    void reemplazarTodos(List<ExamenSangre> examenes);
}