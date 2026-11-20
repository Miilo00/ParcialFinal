package co.edu.poli.Examen2.dominio;

import java.math.BigDecimal;

/**
 * Creador abstracto del patrón Factory Method.
 */
public abstract class FabricaExamenSangre {
    public abstract ExamenSangre crear(String codigo, String nombre, String costo,
                                       String tipoSangre, String factorRH);

    protected BigDecimal convertirCosto(String costo) {
        try {
            return new BigDecimal(costo == null ? "" : costo.trim());
        } catch (NumberFormatException excepcion) {
            throw new IllegalArgumentException("El costo debe ser un número válido.");
        }
    }
}
