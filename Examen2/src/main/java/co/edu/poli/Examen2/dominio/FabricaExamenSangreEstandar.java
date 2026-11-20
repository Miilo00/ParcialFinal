package co.edu.poli.Examen2.dominio;

import java.math.BigDecimal;

public class FabricaExamenSangreEstandar extends FabricaExamenSangre {
    @Override
    public ExamenSangre crear(String codigo, String nombre, String costo,
                              String tipoSangre, String factorRH) {
        BigDecimal costoDecimal = convertirCosto(costo);
        return new ExamenSangre(
                codigo,
                nombre,
                costoDecimal,
                TipoSangre.desdeTexto(tipoSangre),
                FactorRH.desdeTexto(factorRH));
    }
}
