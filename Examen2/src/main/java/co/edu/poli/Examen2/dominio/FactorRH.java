package co.edu.poli.Examen2.dominio;

public enum FactorRH {
    POSITIVO("+"),
    NEGATIVO("-");

    private final String simbolo;

    FactorRH(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public static FactorRH desdeTexto(String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("Debe seleccionar el factor RH.");
        }
        String valor = texto.trim().toUpperCase();
        if (valor.equals("POSITIVO") || valor.equals("+") || valor.equals("RH+")) {
            return POSITIVO;
        }
        if (valor.equals("NEGATIVO") || valor.equals("-") || valor.equals("RH-")) {
            return NEGATIVO;
        }
        throw new IllegalArgumentException("El factor RH no es válido.");
    }
}