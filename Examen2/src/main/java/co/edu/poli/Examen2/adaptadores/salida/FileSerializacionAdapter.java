package co.edu.poli.Examen2.adaptadores.salida;

import co.edu.poli.Examen2.dominio.ExamenSangre;
import co.edu.poli.Examen2.puertos.SerializacionPort;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileSerializacionAdapter implements SerializacionPort {
    private final Path archivo;

    public FileSerializacionAdapter(String rutaArchivo) {
        this.archivo = Paths.get(rutaArchivo);
    }

    @Override
    public void serializar(List<ExamenSangre> examenes) {
        try {
            Path carpeta = archivo.getParent();
            if (carpeta != null) {
                Files.createDirectories(carpeta);
            }
            try (ObjectOutputStream salida =
                         new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(archivo)))) {
                salida.writeObject(new ArrayList<>(examenes));
            }
        } catch (IOException excepcion) {
            throw new IllegalStateException("No fue posible guardar el archivo: " + excepcion.getMessage(), excepcion);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ExamenSangre> deserializar() {
        if (!Files.exists(archivo)) {
            throw new IllegalStateException("No existe un archivo para deserializar.");
        }
        try (ObjectInputStream entrada =
                     new ObjectInputStream(new BufferedInputStream(Files.newInputStream(archivo)))) {
            Object objeto = entrada.readObject();
            if (!(objeto instanceof List)) {
                throw new IllegalStateException("El archivo no contiene una lista de exámenes.");
            }
            return new ArrayList<>((List<ExamenSangre>) objeto);
        } catch (IOException | ClassNotFoundException excepcion) {
            throw new IllegalStateException("No fue posible leer el archivo: " + excepcion.getMessage(), excepcion);
        }
    }
}