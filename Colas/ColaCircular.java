public class ColaCircular {
    private static final int CAPACIDAD_DEFAULT = 99;
    private int frente;
    private int fin;
    private int contador;
    private final Object[] listaCola;

    public ColaCircular() {
        this(CAPACIDAD_DEFAULT);
    }

    public ColaCircular(int capacidad) {
        frente = 0;
        fin = 0;
        contador = 0;
        listaCola = new Object[capacidad];
    }

    public void insertar(Object elemento) throws Exception {
        if (colaLlena()) {
            throw new Exception("Desbordamiento de la cola (Cola llena).");
        }
        listaCola[fin] = elemento;
        fin = (fin + 1) % listaCola.length;
        contador++;
    }

    public Object quitar() throws Exception {
        if (colaVacia()) {
            throw new Exception("Cola vacía, no se puede extraer elementos.");
        }
        Object elemento = listaCola[frente];
        listaCola[frente] = null;
        frente = (frente + 1) % listaCola.length;
        contador--;
        return elemento;
    }

    public Object frenteCola() throws Exception {
        if (colaVacia()) {
            throw new Exception("Cola vacía.");
        }
        return listaCola[frente];
    }

    public boolean colaVacia() {
        return contador == 0;
    }

    public boolean colaLlena() {
        return contador == listaCola.length;
    }

    public void borrarCola() {
        frente = 0;
        fin = 0;
        contador = 0;
        for (int i = 0; i < listaCola.length; i++) {
            listaCola[i] = null;
        }
    }

    public int tamaño() {
        return contador;
    }
}