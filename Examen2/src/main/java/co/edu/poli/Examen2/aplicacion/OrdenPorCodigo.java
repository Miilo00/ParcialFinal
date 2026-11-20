package co.edu.poli.Examen2.aplicacion;

import co.edu.poli.Examen2.dominio.ExamenSangre;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenPorCodigo implements EstrategiaOrdenExamenes {
    @Override
    public List<ExamenSangre> ordenar(List<ExamenSangre> examenes) {
        List<ExamenSangre> ordenados = new ArrayList<>(examenes);
        ordenados.sort(Comparator.comparing(ExamenSangre::getCodigoExamen));
        return ordenados;
    }
}
