package co.edu.poli.Examen2.dominio;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Entidad de dominio que representa un examen de sangre.
 * Valida sus datos obligatorios al construirse.
 */
public class ExamenSangre implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String codigoExamen;
    private final String nombrePaciente;
    private final BigDecimal costo;
    private final TipoSangre tipoSangre;
    private final FactorRH factorRH;

    /**
     * Crea un examen y valida las reglas invariantes del dominio.
     *
     * @param codigoExamen código único del examen
     * @param nombrePaciente nombre completo del paciente
     * @param costo costo del examen, mayor que cero
     * @param tipoSangre grupo sanguíneo
     * @param factorRH factor RH positivo o negativo
     * @throws IllegalArgumentException si algún dato no cumple las reglas
     */
    public ExamenSangre(String codigoExamen, String nombrePaciente, BigDecimal costo,
                        TipoSangre tipoSangre, FactorRH factorRH) {
        if (codigoExamen == null || codigoExamen.trim().isEmpty()) {
            throw new IllegalArgumentException("El código del examen es obligatorio.");
        }
        if (nombrePaciente == null || nombrePaciente.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del paciente es obligatorio.");
        }
        if (costo == null || costo.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El costo debe ser mayor que cero.");
        }
        if (tipoSangre == null) {
            throw new IllegalArgumentException("El tipo de sangre es obligatorio.");
        }
        if (factorRH == null) {
            throw new IllegalArgumentException("El factor RH es obligatorio.");
        }

        this.codigoExamen = codigoExamen.trim();
        this.nombrePaciente = nombrePaciente.trim();
        this.costo = costo;
        this.tipoSangre = tipoSangre;
        this.factorRH = factorRH;
    }

    public String getCodigoExamen() {
        return codigoExamen;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public TipoSangre getTipoSangre() {
        return tipoSangre;
    }

    public FactorRH getFactorRH() {
        return factorRH;
    }

    @Override
    public String toString() {
        return codigoExamen + " | " + nombrePaciente + " | $" + costo
                + " | " + tipoSangre + factorRH.getSimbolo();
    }
}