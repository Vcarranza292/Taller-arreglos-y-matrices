package estructuras;

public class ListaEnlazada {

    private Nodo cabeza;
    private int cantidad;

    public ListaEnlazada(){
        this.cabeza = null;
        this.cantidad = 0;
    }

    //Agregar un elemento al final de la lista
    public void agregar(Object elemento){
        Nodo nuevoNodo = new Nodo(elemento);
        if (estaVacia()){
            cabeza = nuevoNodo;
        } else{
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null){
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        cantidad++;
    }

    //Elimina la primera aparición del elemento en la lista
    public boolean eliminar(Object elemento){
        if (estaVacia()){
            return false;
        }
        if (cabeza.getDato().equals(elemento)){
            cabeza = cabeza.getSiguiente();
            cantidad--;
            return true;
        }
        Nodo actual = cabeza;
        while (actual.getSiguiente() != null){
            if (actual.getSiguiente().getDato().equals(elemento)){
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                cantidad--;
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    //Verifica si la lista contiene el elemento
    public boolean contiene(Object elemento) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getDato().equals(elemento)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public boolean estaVacia() {
        return cantidad == 0;
    }

    public int tamanio() {
        return cantidad;
    }
}
