package org.maestra.datos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Singleton que guarda TODOS los datos que quieres compartir
 * entre cualquier ventana de la aplicación.
 * Es el "cerebro" central de tu programa.
 */
public class DatosCompartidos {

    // =========================================================
    // 1. INSTANCIA ÚNICA (Singleton)
    // =========================================================
    private static final DatosCompartidos INSTANCE = new DatosCompartidos();

    // Constructor privado → nadie puede hacer "new DatosCompartidos()"
    private DatosCompartidos() {
        // Aquí podrías cargar los datos al iniciar la app
        cargarSesion();
    }

    public static DatosCompartidos getInstance() {
        return INSTANCE;
    }

    // =========================================================
    // 2. TUS DATOS (puedes añadir todos los que necesites)
    // =========================================================
    private String nombreJugador = "";
    private int puntuacion = 0;
    private int nivel = 1;
    //private LocalDateTime ultimaConexion = LocalDateTime.now();
    private List<String> logros = new ArrayList<>();

    // =========================================================
    // 3. GETTERS Y SETTERS SIMPLES
    // =========================================================
    public String getNombreJugador() { return nombreJugador; }
    public void setNombreJugador(String nombreJugador) { this.nombreJugador = nombreJugador; }

    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }

    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }

    public List<String> getLogros() { return logros; }

    // =========================================================
    // 4. MÉTODOS ÚTILES (puedes poner aquí toda la lógica que quieras)
    // =========================================================
    public void sumarPuntos(int puntos) {
        this.puntuacion += puntos;
        comprobarLogros();
    }

    public void restarPuntos(int puntos) {
        this.puntuacion = Math.max(0, this.puntuacion - puntos);
    }

    private void comprobarLogros() {
        if (puntuacion >= 1000 && !logros.contains("Mil puntos")) {
            logros.add("Mil puntos");
        }
        if (puntuacion >= 5000 && !logros.contains("Leyenda")) {
            logros.add("Leyenda");
        }
    }

    public String getResumen() {
        return "Jugador: " + (nombreJugador.isEmpty() ? "Anónimo" : nombreJugador) +
                       " | Nivel " + nivel +
                       " | Puntos: " + puntuacion;
    }

    // =========================================================
    // 5. GUARDAR Y CARGAR SESIÓN (en JSON, muy moderno y fácil)
    // =========================================================
    // Guardar justo al lado del .jar (ideal para distribución)
    private static final String RUTA_CARPETA = ".";                    // carpeta actual
    private static final String ARCHIVO = "sesion.json";               // directamente en la raíz
    private static final Gson gson = new Gson();

    /** Guarda automáticamente todos los datos al cerrar la app */
    public void guardarSesion() {
        try {
            EstadoGuardado estado = new EstadoGuardado();
            estado.nombreJugador = this.nombreJugador;
            estado.puntuacion = this.puntuacion;
            estado.nivel = this.nivel;
            estado.ultimaConexion = LocalDateTime.now().toString();  // ← sigue guardando la hora actual
            estado.logros = new ArrayList<>(this.logros);

            String json = gson.toJson(estado);
            Path archivo = Paths.get("sesion.json");
            Files.write(archivo, json.getBytes("UTF-8"),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("Sesión guardada en: " + archivo.toAbsolutePath());
        } catch (Exception e) {
            System.err.println("ERROR al guardar:");
            e.printStackTrace();
        }
    }

    public void cargarSesion() {
        Path archivo = Paths.get("sesion.json");
        if (!Files.exists(archivo)) {
            System.out.println("No hay sesión previa");
            return;
        }

        try {
            String json = Files.readString(archivo);
            EstadoGuardado estado = gson.fromJson(json, EstadoGuardado.class);

            this.nombreJugador = estado.nombreJugador != null ? estado.nombreJugador : "";
            this.puntuacion = estado.puntuacion;
            this.nivel = estado.nivel;
            this.logros = estado.logros != null ? estado.logros : new ArrayList<>();

            System.out.println("Sesión cargada. Última conexión: " + estado.ultimaConexion);
            // ← Aquí ya sabes cuándo fue la última vez, aunque no lo guardes en un campo
        } catch (Exception e) {
            System.err.println("Error al cargar sesión:");
            e.printStackTrace();
        }
    }

    // =========================================================
    // 6. Clase interna solo para guardar/cargar en JSON
    // =========================================================
    // Dentro de DatosCompartidos.java → reemplaza toda la clase interna
    private static class EstadoGuardado {
        String nombreJugador;
        int puntuacion;
        int nivel;
        String ultimaConexion;     // ← ahora String en vez de LocalDateTime
        List<String> logros;
    }
}
