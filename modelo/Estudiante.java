 package modelo;

import estructuras.ListaEnlazada;

public class Estudiante extends Persona {

    private int semestre;
    private ListaEnlazada historialMaterias;

    public Estudiante(String id, String nombre, String email, int semestre) {
        super(id, nombre, email);
        this.semestre = semestre;
        this.historialMaterias = new ListaEnlazada();
    }

    public int getSemestre() {
        return semestre;
    }

    public ListaEnlazada getHistorialMaterias() {
        return historialMaterias;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Email: " + getEmail());
        System.out.println("Semestre: " + semestre);
    }
}