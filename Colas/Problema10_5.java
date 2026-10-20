public class Problema10_5 {

    // EL MÉTODO MAIN (Necesario para que Java pueda ejecutar el programa)
    public static void main(String[] args) {
        try {
            // Creamos una cola de prueba con capacidad de 5 elementos
            ColaCircular cola = new ColaCircular(5);
            cola.insertar("Elemento A");
            cola.insertar("Elemento B");
            cola.insertar("Elemento C");

            System.out.println("=== COLA ORIGINAL CREADA ===");
            
            // Ejecutamos la inversión
            invertirCola(cola);
            
            System.out.println("=== ¡COLA INVERTIDA CON ÉXITO! ===");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Método principal para resolver el Problema 10.5
    public static void invertirCola(ColaCircular c) throws Exception {
        PilaAuxiliar pila = new PilaAuxiliar();

        // 1. Pasamos todo de la cola a la pila (esto invierte el orden)
        while (!c.colaVacia()) {
            pila.insertar(c.quitar());
        }

        // 2. Regresamos los elementos de la pila a la cola
        while (!pila.pilaVacia()) {
            c.insertar(pila.quitar());
        }
    }

    // Pila interna auxiliar autocontenida
    private static class PilaAuxiliar {
        private int cima = -1;
        private final Object[] datos = new Object[100];

        public void insertar(Object x) {
            datos[++cima] = x;
        }

        public Object quitar() {
            return datos[cima--];
        }

        public boolean pilaVacia() {
            return cima == -1;
        }
    }
}
