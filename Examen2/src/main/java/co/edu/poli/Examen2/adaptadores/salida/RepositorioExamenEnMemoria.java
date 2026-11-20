package co.edu.poli.Examen2.adaptadores.salida;

import co.edu.poli.Examen2.dominio.ExamenSangre;
import co.edu.poli.Examen2.puertos.ExamenRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RepositorioExamenEnMemoria implements ExamenRepository {
    private final Map<String, ExamenSangre> examenes = new LinkedHashMap<>();

    @Override
    public void guardar(ExamenSangre examen) {
        examenes.put(examen.getCodigoExamen(), examen);
    }

    @Override
    public List<ExamenSangre> listar() {
        return new ArrayList<>(examenes.values());
    }

    @Override
    public void reemplazarTodos(List<ExamenSangre> nuevosExamenes) {
        examenes.clear();
        if (nuevosExamenes != null) {
            for (ExamenSangre examen : nuevosExamenes) {
                examenes.put(examen.getCodigoExamen(), examen);
            }
        }
    }
}
