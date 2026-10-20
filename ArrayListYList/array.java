package ArrayListYList;package ArrayListYList;
// ============================================================================
// EJEMPLO 2 - INTERFAZ LIST: NOTAS DE UN CURSO Y FILA DE TURNOS
// Materia: Programación III | AF2
// Qué hace: Parte 1 guarda estudiantes y notas, calcula promedios y filtra a
//           los que aprueban. Parte 2 simula la fila de una taquilla de cine.
// Qué es List: NO es una clase, es una INTERFAZ (un "contrato" con métodos como
//           add, get, remove, size). ArrayList y LinkedList lo cumplen.
// Por qué la uso: escribo  List<X> lista = new ArrayList<>();  La variable es
//           List y el objeto real es ArrayList. Si quiero cambiar a LinkedList
//           solo cambio el "new" y lo demás sigue igual. Eso es POLIMORFISMO.
// ============================================================================

import java.util.ArrayList;   // Lista respaldada por un arreglo (rápida para leer con get)
import java.util.LinkedList;  // Lista de nodos enlazados (buena para agregar/quitar al inicio)
import java.util.List;        // La interfaz, que uso como tipo de las variables

// CLASE ESTUDIANTE: nombre + lista de notas
class Estudiante {
    private String nombre;
    private List<Double> notas;  // Declarada como List (interfaz), no como ArrayList

    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList<>();  // Aquí elijo la implementación: ArrayList, vacía al inicio
    }
