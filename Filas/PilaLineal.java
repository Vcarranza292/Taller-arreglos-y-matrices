public class PilaLineal {
    private static final int TAMPILA = 49;
    private int cima;
    private final Object[] listaPila;

    public PilaLineal() {
        cima = -1;
        listaPila = new Object[TAMPILA];
    }

    public PilaLineal(int n) {
        cima = -1;
        listaPila = new Object[n];
    }

    public void insertar(Object elemento) throws Exception {
        if (pilaLlena()) {
            throw new Exception("Desbordamiento de la pila (Pila llena).");
        }
        cima++;
        listaPila[cima] = elemento;
    }

    public Object quitar() throws Exception {
        if (pilaVacia()) {
            throw new Exception("Pila vacía, no se puede extraer.");
        }
        Object aux = listaPila[cima];
        listaPila[cima] = null;
        cima--;
        return aux;
    }

    public Object cimaPila() throws Exception {
        if (pilaVacia()) {
            throw new Exception("Pila vacía.");
        }
        return listaPila[cima];
    }

    public boolean pilaVacia() {
        return cima == -1;
    }

    public boolean pilaLlena() {
        return cima == listaPila.length - 1;
    }

    public void limpiarPila() {
        while (!pilaVacia()) {
            listaPila[cima--] = null;
        }
    }
}