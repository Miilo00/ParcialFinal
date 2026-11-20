package co.edu.poli.Examen2.aplicacion;

import co.edu.poli.Examen2.dominio.ExamenSangre;

import java.util.List;

/**
 * Estrategia del patrón Strategy para definir criterios de orden.
 */
public interface EstrategiaOrdenExamenes {
    List<ExamenSangre> ordenar(List<ExamenSangre> examenes);
}
