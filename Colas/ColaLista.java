public class ColaLista {
    private static class Nodo {
        Object elemento;
        Nodo siguiente;

        public Nodo(Object x) {
            elemento = x;
            siguiente = null;
        }
    }

    private Nodo frente;
    private Nodo fin;

    public ColaLista() {
        frente = null;
        fin = null;
    }

    public void insertar(Object elemento) {
        Nodo nuevo = new Nodo(elemento);
        if (colaVacia()) {
            frente = nuevo;
        } else {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
    }

    public Object quitar() throws Exception {
        if (colaVacia()) {
            throw new Exception("Cola vacía, no se puede extraer.");
        }
        Object aux = frente.elemento;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null; // Si se vació por completo
        }
        return aux;
    }

    public Object frenteCola() throws Exception {
        if (colaVacia()) {
            throw new Exception("Cola vacía.");
        }
        return frente.elemento;
    }

    public boolean colaVacia() {
        return frente == null;
    }

    public void borrarCola() {
        frente = null;
        fin = null;
    }
}