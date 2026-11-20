package co.edu.poli.Examen2;

import co.edu.poli.Examen2.adaptadores.salida.RepositorioExamenEnMemoria;
import co.edu.poli.Examen2.aplicacion.ExamenService;
import co.edu.poli.Examen2.aplicacion.OrdenPorNombrePaciente;
import co.edu.poli.Examen2.dominio.ExamenSangre;
import co.edu.poli.Examen2.puertos.ExamenRepository;
import co.edu.poli.Examen2.puertos.SerializacionPort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExamenServiceTest {
    @Test
    void registraYListaExamenes() {
        ExamenRepository repositorio = new RepositorioExamenEnMemoria();
        ExamenService servicio = new ExamenService(repositorio, new SerializacionPort() {
            @Override
            public void serializar(List<ExamenSangre> examenes) {
            }

            @Override
            public List<ExamenSangre> deserializar() {
                return new ArrayList<>();
            }
        });

        servicio.registrar("EX-1", "Juan Pérez", "25000", "AB", "POSITIVO");

        assertEquals(1, servicio.listar().size());
        assertEquals("EX-1", servicio.listar().get(0).getCodigoExamen());
    }

    @Test
    void puedeCambiarLaEstrategiaDeOrden() {
        ExamenRepository repositorio = new RepositorioExamenEnMemoria();
        ExamenService servicio = new ExamenService(repositorio, new SerializacionPort() {
            @Override
            public void serializar(List<ExamenSangre> examenes) {
            }

            @Override
            public List<ExamenSangre> deserializar() {
                return new ArrayList<>();
            }
        });

        servicio.registrar("EX-2", "Zoe", "100", "A", "POSITIVO");
        servicio.registrar("EX-1", "Ana", "100", "O", "NEGATIVO");
        servicio.cambiarEstrategiaOrden(new OrdenPorNombrePaciente());

        assertEquals("Ana", servicio.listar().get(0).getNombrePaciente());
    }
}
