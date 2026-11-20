package co.edu.poli.Examen2;

import co.edu.poli.Examen2.dominio.ExamenSangre;
import co.edu.poli.Examen2.dominio.FabricaExamenSangre;
import co.edu.poli.Examen2.dominio.FabricaExamenSangreEstandar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FabricaExamenSangreTest {
    @Test
    void laFabricaConstruyeEntidadesValidas() {
        FabricaExamenSangre fabrica = new FabricaExamenSangreEstandar();

        ExamenSangre examen = fabrica.crear(
                "EX-10", "Laura", "35000", "AB", "POSITIVO");

        assertEquals("EX-10", examen.getCodigoExamen());
        assertEquals("Laura", examen.getNombrePaciente());
    }
}
