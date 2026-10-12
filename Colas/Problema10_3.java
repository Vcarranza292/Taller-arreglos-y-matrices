public class Problema10_3 {
    public static void imprimirCola(ColaCircular c) throws Exception {
        if (c.colaVacia()) {
            System.out.println("La cola está vacía.");
            return;
        }

        ColaCircular aux = new ColaCircular();
        System.out.print("Elementos de la cola: [ ");
        
        while (!c.colaVacia()) {
            Object elemento = c.quitar();
            System.out.print(elemento + " ");
            aux.insertar(elemento);
        }
        System.out.println("]");

        // Restauramos los datos a la cola original
        while (!aux.colaVacia()) {
            c.insertar(aux.quitar());
        }
    }
}