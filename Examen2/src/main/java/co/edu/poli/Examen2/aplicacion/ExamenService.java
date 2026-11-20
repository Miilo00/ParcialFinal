package co.edu.poli.Examen2.aplicacion;

import co.edu.poli.Examen2.dominio.ExamenSangre;
import co.edu.poli.Examen2.dominio.FabricaExamenSangre;
import co.edu.poli.Examen2.dominio.FabricaExamenSangreEstandar;
import co.edu.poli.Examen2.puertos.ExamenRepository;
import co.edu.poli.Examen2.puertos.PuertoExamenEntrada;
import co.edu.poli.Examen2.puertos.SerializacionPort;

import java.util.List;

/**
 * Caso de uso principal para registrar, consultar, ordenar y persistir exámenes.
 * Depende de puertos y no de implementaciones tecnológicas concretas.
 */
public class ExamenService implements PuertoExamenEntrada {
    private final ExamenRepository repositorio;
    private final SerializacionPort serializacion;
    private final FabricaExamenSangre fabricaExamen;
    private EstrategiaOrdenExamenes estrategiaOrden;

    /**
     * Construye el servicio con las implementaciones predeterminadas.
     *
     * @param repositorio puerto de persistencia en memoria
     * @param serializacion puerto de serialización
     */
    public ExamenService(ExamenRepository repositorio, SerializacionPort serializacion) {
        this(repositorio, serializacion,
                new FabricaExamenSangreEstandar(),
                new OrdenPorCodigo());
    }

    public ExamenService(ExamenRepository repositorio, SerializacionPort serializacion,
                         FabricaExamenSangre fabricaExamen,
                         EstrategiaOrdenExamenes estrategiaOrden) {
        this.repositorio = repositorio;
        this.serializacion = serializacion;
        this.fabricaExamen = fabricaExamen;
        this.estrategiaOrden = estrategiaOrden;
    }

    /**
     * Crea y registra un examen.
     *
     * @param codigo código del examen
     * @param nombre nombre del paciente
     * @param costo costo como texto
     * @param tipoSangre tipo sanguíneo
     * @param factorRH factor RH
     * @return examen creado y registrado
     */
    public ExamenSangre registrar(String codigo, String nombre, String costo,
                                  String tipoSangre, String factorRH) {
        ExamenSangre examen = fabricaExamen.crear(
                codigo, nombre, costo, tipoSangre, factorRH);
        repositorio.guardar(examen);
        return examen;
    }

    public List<ExamenSangre> listar() {
        return estrategiaOrden.ordenar(repositorio.listar());
    }

    public void cambiarEstrategiaOrden(EstrategiaOrdenExamenes nuevaEstrategia) {
        if (nuevaEstrategia == null) {
            throw new IllegalArgumentException("La estrategia de orden no puede ser nula.");
        }
        this.estrategiaOrden = nuevaEstrategia;
    }

    public void serializar() {
        serializacion.serializar(repositorio.listar());
    }

    public void deserializar() {
        repositorio.reemplazarTodos(serializacion.deserializar());
    }
}