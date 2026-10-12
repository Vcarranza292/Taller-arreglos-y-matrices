public class Problema10_5 {
    
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
}