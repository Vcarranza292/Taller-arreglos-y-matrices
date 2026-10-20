package ArrayListYList;
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

    public String getNombre() { return nombre; }

    public void agregarNota(double nota) {
        if (nota >= 0.0 && nota <= 5.0) {
            notas.add(nota);  // add() agrega al final (Java convierte double a Double solo: autoboxing)
        } else {
            System.out.println("   Nota inválida (" + nota + ") para " + nombre + ": debe estar entre 0 y 5.");
        }
    }

    public double calcularPromedio() {
        if (notas.isEmpty()) return 0.0;  // Sin notas devuelvo 0 para no dividir entre cero
        double suma = 0;                  // Acumulador
        for (double n : notas) {          // for-each: toma cada nota de la lista
            suma += n;
        }
        return suma / notas.size();       // Promedio = suma / cantidad (size())
    }

    public boolean aprueba() {
        return calcularPromedio() >= 3.0;  // Aprueba con 3.0 o más
    }

    @Override
    public String toString() {  // Al imprimir una List Java ya la muestra como [4.5, 3.8]
        return nombre + " -> notas: " + notas + " | promedio: " + String.format("%.2f", calcularPromedio());
    }
}

// CLASE PRINCIPAL
public class Ejemplo2_List {

    public static void main(String[] args) {

        // ===== PARTE 1: LIST<ESTUDIANTE> CON ARRAYLIST =====
        System.out.println("===== PARTE 1: NOTAS DEL CURSO =====");
        List<Estudiante> curso = new ArrayList<>();  // Tipo List, objeto ArrayList

        Estudiante laura = new Estudiante("Laura");
        Estudiante carlos = new Estudiante("Carlos");
        curso.add(laura);    // add() agrega al final de la lista
        curso.add(carlos);

        laura.agregarNota(4.5);
        laura.agregarNota(3.8);
        carlos.agregarNota(2.5);
        carlos.agregarNota(3.0);
        carlos.agregarNota(6.0);  // Inválida a propósito: prueba la validación

        for (Estudiante e : curso) {  // Recorro la lista de estudiantes
            System.out.println(e);    // println llama al toString() de Estudiante
        }

        List<Estudiante> aprobados = new ArrayList<>();  // Otra lista, vacía, para filtrar
        for (Estudiante e : curso) {
            if (e.aprueba()) aprobados.add(e);  // Solo agrego a los que cumplen la condición
        }
         System.out.println("Aprobados: " + aprobados.size() + " de " + curso.size());

        curso.remove(carlos);  // remove(objeto) lo quita; los demás se corren solos
        System.out.println("Tras retirar a Carlos quedan: " + curso.size());

        // ===== PARTE 2: LA MISMA INTERFAZ, OTRA IMPLEMENTACIÓN (LINKEDLIST) =====
        System.out.println("\n===== PARTE 2: FILA DE TURNOS EN LA TAQUILLA =====");
        List<String> fila = new LinkedList<>();  // Mismo tipo List, pero el objeto es LinkedList

        fila.add("Andrés");     // Llega Andrés (primero)
        fila.add("Mariana");
        fila.add("Sofía");
        fila.add(0, "Pedro");   // add(posición, elemento): Pedro pasa de primero y los demás se corren
        System.out.println("Fila: " + fila);

        mostrarSiguiente(fila);  // Paso la LinkedList a un método que recibe List

        String atendido = fila.remove(0);  // remove(0) saca al primero y lo devuelve
        System.out.println("Atendido: " + atendido + " | Fila ahora: " + fila);

        fila.set(2, "Sofía (con cupón)");  // set(posición, nuevo): reemplaza lo que había en la posición 2
        System.out.println("Actualizada: " + fila);

        // Polimorfismo: el MISMO método sirve con un ArrayList
        List<String> filaVip = new ArrayList<>();
        filaVip.add("Camila");
        mostrarSiguiente(filaVip);
    }

    // Recibe List<String> (la interfaz), por eso sirve para CUALQUIER lista: ArrayList, LinkedList...
    static void mostrarSiguiente(List<String> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay nadie en la fila.");
        } else {
            System.out.println("Siguiente: " + lista.get(0));  // get(0) mira al primero sin sacarlo
        }
    }
}