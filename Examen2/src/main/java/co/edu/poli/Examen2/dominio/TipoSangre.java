package co.edu.poli.Examen2.dominio;

public enum TipoSangre {
    A,
    B,
    AB,
    O;

    public static TipoSangre desdeTexto(String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("Debe seleccionar un tipo de sangre.");
        }
        try {
            return valueOf(texto.trim().toUpperCase());
        } catch (IllegalArgumentException excepcion) {
            throw new IllegalArgumentException("El tipo de sangre no es válido.");
        }
    }
}