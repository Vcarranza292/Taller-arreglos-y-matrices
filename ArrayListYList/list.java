package ArrayListYList;
// ============================================================================
// EJEMPLO 1 - ARRAYLIST: INVENTARIO DE UNA TIENDA
// Materia: Programación III | AF2
// Qué hace: guarda los productos de una tienda y permite agregar, ver, buscar,
//           modificar y eliminar.
// Por qué ArrayList: en una tienda no sé cuántos productos habrá. Un arreglo
//           tiene tamaño fijo; el ArrayList crece y se encoge solo y ya trae
//           métodos (add, get, remove, size), sin llevar contadores a mano.
// ============================================================================

import java.util.ArrayList;  // Importo ArrayList (vive en java.util)
import java.util.Scanner;    // Importo Scanner para leer del teclado

// CLASE PRODUCTO: representa UN producto. El ArrayList guardará muchos de estos.
class Producto {
    private String nombre;  // Nombre (private = encapsulamiento)
    private double precio;  // Precio (double porque puede tener decimales)
    private int stock;      // Unidades disponibles

    public Producto(String nombre, double precio, int stock) {  // Constructor: deja el objeto listo al hacer new
        this.nombre = nombre;  // this.nombre es el atributo; nombre es el parámetro
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() { return nombre; }  // Getter: leer el nombre
    public void setPrecio(double precio) { this.precio = precio; }  // Setter: cambiar el precio
    public void setStock(int stock) { this.stock = stock; }         // Setter: cambiar el stock

    @Override
    public String toString() {  // Define cómo se imprime el producto (sin esto saldría Producto@1b6d3586)
        return nombre + " | Precio: $" + String.format("%,.0f", precio) + " | Stock: " + stock;
    }
}