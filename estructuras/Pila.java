package estructuras;

public class Pila {
    
    private Object[] datos;
    private int tope;
    
    public Pila(int capacidadInicial){
        int capacidad = 0;
        datos = new Object[capacidad];
        tope = -1;
    }
    
    //Agrega un elemento arriba de la pila
    public void apilar(Object elemento){
        if (tope == datos.length - 1){
            Object[] nuevo = new Object[datos.length * 2];
            for (int i = 0; i < datos.length; i++){
                nuevo[i] = datos[i];
            }
            datos = nuevo;
        }
        tope++;
        datos[tope] = elemento;
    }
    
    //Quito y retorno el elemento del tope y daria erro si esta vacia 
    public Object desapilar(){
        if (estaVacia()){
            throw new IllegalStateException("La pila esta vacia.");
        }
        Object elemento = datos[tope];
        datos[tope] = null;
        tope--;
        return elemento;
    }
    
    //Retorna el elemento de arriba sin quitarlo
    public Object cima(){
        if (estaVacia()){
            throw new IllegalStateException("La pila esta vacia.");
        }
        return datos[tope];
    }
    
    public boolean estaVacia(){
        return tope == -1;
    }
    
    public int tamanio(){
        return tope + 1;
    }
}