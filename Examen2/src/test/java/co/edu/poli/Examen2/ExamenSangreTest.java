package co.edu.poli.Examen2;

import co.edu.poli.Examen2.dominio.ExamenSangre;
import co.edu.poli.Examen2.dominio.FactorRH;
import co.edu.poli.Examen2.dominio.TipoSangre;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ExamenSangreTest {
    @Test
    void rechazaCostoNoPositivo() {
        assertThrows(IllegalArgumentException.class, () ->
                new ExamenSangre("EX-1", "Ana", BigDecimal.ZERO,
                        TipoSangre.A, FactorRH.POSITIVO));
    }

    @Test
    void rechazaCamposObligatorios() {
        assertThrows(IllegalArgumentException.class, () ->
                new ExamenSangre("", "Ana", new BigDecimal("10"),
                        TipoSangre.O, FactorRH.NEGATIVO));
    }
}
