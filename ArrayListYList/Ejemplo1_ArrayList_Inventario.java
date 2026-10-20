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

// CLASE PRINCIPAL
public class Ejemplo1_ArrayList_Inventario {

    // Lista dinámica que SOLO acepta objetos Producto (<Producto> es un genérico)
    static ArrayList<Producto> inventario = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);  // Un solo Scanner para todo el programa

    public static void main(String[] args) {  // Aquí empieza el programa
        // add() agrega al FINAL de la lista; la lista crece sola
        inventario.add(new Producto("Arroz 1kg", 4500, 40));
        inventario.add(new Producto("Aceite 1L", 12000, 15));
        inventario.add(new Producto("Leche 1L", 4200, 30));

        boolean salir = false;  // Mientras sea false, el menú se repite
        while (!salir) {
            System.out.println("\n===== INVENTARIO TIENDA =====");
            System.out.println("1. Agregar  2. Ver todos  3. Buscar  4. Modificar  5. Eliminar  6. Salir");
            int opcion = leerEntero("Elige una opción: ");

            switch (opcion) {  // Ejecuta el caso que coincida con la opción
                case 1: agregarProducto(); break;   // break evita que siga con el siguiente caso
                case 2: verProductos(); break;
                case 3: buscarProducto(); break;
                case 4: modificarProducto(); break;
                case 5: eliminarProducto(); break;
                case 6: System.out.println("¡Hasta luego!"); salir = true; break;  // Cambio la bandera: el while termina
                default: System.out.println("Opción no válida.");
            }
        }
    }

    // AGREGAR: usa add()
    static void agregarProducto() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        double precio = leerDouble("Precio: ");
        int stock = leerEntero("Stock: ");
        inventario.add(new Producto(nombre, precio, stock));  // Creo el producto y lo meto a la lista
        System.out.println("Agregado. Ahora hay " + inventario.size() + " productos.");  // size() = cuántos elementos hay
    }

    // VER TODOS: recorre con for-each
    static void verProductos() {
        if (inventario.isEmpty()) {  // isEmpty() es true si no hay elementos
            System.out.println("El inventario está vacío.");
            return;  // Salgo del método: no hay nada que mostrar
        }
        int numero = 1;  // Contador solo para numerar en pantalla
        for (Producto p : inventario) {  // "para cada Producto p dentro de inventario"
            System.out.println(numero + ". " + p);  // Al concatenar p se llama su toString()
            numero++;
        }
    }

    // BUSCAR: for normal con get(i)
    static void buscarProducto() {
        System.out.print("Nombre a buscar: ");
        String buscado = scanner.nextLine().toLowerCase();  // A minúsculas para que "Arroz" y "arroz" coincidan
        boolean encontrado = false;  // Bandera: ¿apareció al menos uno?
        for (int i = 0; i < inventario.size(); i++) {  // for normal porque necesito la posición i
            Producto p = inventario.get(i);  // get(i) devuelve el elemento de la posición i
            if (p.getNombre().toLowerCase().contains(buscado)) {  // contains: basta con parte del nombre
                System.out.println("Posición " + i + ": " + p);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("No hay productos con ese nombre.");
    }

    // MODIFICAR: get() + setters
    static void modificarProducto() {
        verProductos();  // Muestro la lista para que vea los números
        if (inventario.isEmpty()) return;
        int num = leerEntero("Número del producto: ");
        if (num < 1 || num > inventario.size()) {  // Valido el rango para evitar IndexOutOfBoundsException
            System.out.println("Número fuera de rango.");
            return;
        }
        Producto p = inventario.get(num - 1);  // Resto 1: yo muestro desde 1 pero la lista empieza en 0
        p.setPrecio(leerDouble("Nuevo precio: "));  // p es el MISMO objeto de la lista, así que el cambio queda guardado
        p.setStock(leerEntero("Nuevo stock: "));
        System.out.println("Actualizado: " + p);
    }

     // ELIMINAR: remove()
    static void eliminarProducto() {
        verProductos();
        if (inventario.isEmpty()) return;
        int num = leerEntero("Número del producto: ");
        if (num < 1 || num > inventario.size()) {
            System.out.println("Número fuera de rango.");
            return;
        }
        Producto eliminado = inventario.remove(num - 1);  // remove(posición) quita y devuelve el elemento; los demás se corren solos
        System.out.println("Eliminado: " + eliminado.getNombre());
    }

    // AUXILIARES: leen números sin que el programa se caiga
    static int leerEntero(String mensaje) {
        while (true) {  // Repite hasta que escriba algo válido
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine().trim());  // Convierte el texto a int (uso nextLine para no dejar "Enter" pendiente)
            } catch (NumberFormatException e) {  // Si escribió letras, parseInt lanza esta excepción
                System.out.println("Eso no es un número entero.");
            }
        }
    }

    static double leerDouble(String mensaje) {  // Igual que leerEntero pero para decimales
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Eso no es un número válido.");
            }
        }
    }
}