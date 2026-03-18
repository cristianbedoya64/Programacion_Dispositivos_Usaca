package com.usc.cine.bedoyamarin;

/**
 * Modelo de datos para una entrada de cine.
 */
public class EntradaCine {

    private int id;
    private String nombrePelicula;
    private String nombreCine;
    private String numeroSala;
    private String fecha;
    private String hora;
    private int numeroEntradas;
    private double costoTotal;
    private String estudiante;

    public EntradaCine(int id, String nombrePelicula, String nombreCine, String numeroSala,
                       String fecha, String hora, int numeroEntradas, double costoTotal,
                       String estudiante) {
        this.id = id;
        this.nombrePelicula = nombrePelicula;
        this.nombreCine = nombreCine;
        this.numeroSala = numeroSala;
        this.fecha = fecha;
        this.hora = hora;
        this.numeroEntradas = numeroEntradas;
        this.costoTotal = costoTotal;
        this.estudiante = estudiante;
    }

    public EntradaCine(String nombrePelicula, String nombreCine, String numeroSala,
                       String fecha, String hora, int numeroEntradas, double costoTotal,
                       String estudiante) {
        this.nombrePelicula = nombrePelicula;
        this.nombreCine = nombreCine;
        this.numeroSala = numeroSala;
        this.fecha = fecha;
        this.hora = hora;
        this.numeroEntradas = numeroEntradas;
        this.costoTotal = costoTotal;
        this.estudiante = estudiante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getNombreCine() {
        return nombreCine;
    }

    public void setNombreCine(String nombreCine) {
        this.nombreCine = nombreCine;
    }

    public String getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(String numeroSala) {
        this.numeroSala = numeroSala;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getNumeroEntradas() {
        return numeroEntradas;
    }

    public void setNumeroEntradas(int numeroEntradas) {
        this.numeroEntradas = numeroEntradas;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }
}
