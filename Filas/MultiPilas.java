public class MultiPilas {
    private static final int MAX = 100;
    private final Object[] vector = new Object[MAX];
    private final int[] cima = new int[3];

    public MultiPilas() {
        cima[0] = -1;
        cima[1] = 33;
        cima[2] = 66;
    }

    public void insertar(int numPila, Object elemento) throws Exception {
        int inicio = (numPila == 0) ? 33 : (numPila == 1) ? 66 : MAX - 1;
        int fin = (numPila == 0) ? 66 : (numPila == 1) ? 99 : MAX - 1;

        if (cima[numPila] >= fin) {
            throw new Exception("Pila " + numPila + " llena.");
        }
        vector[++cima[numPila]] = elemento;
    }

    public Object quitar(int numPila) throws Exception {
        int inicio = (numPila == 0) ? -1 : (numPila == 1) ? 33 : 66;
        if (cima[numPila] == inicio) {
            throw new Exception("Pila " + numPila + " vacía.");
        }
        Object aux = vector[cima[numPila]];
        vector[cima[numPila]--] = null;
        return aux;
    }
}