package estructuras;

public class Cola{

        private Object[] datos;
        private int frente;
        private int fin;
        private int cantidad;
        
        public Cola(int capacidad){
            datos = new  Object[capacidad];
            frente = 0;
            fin = 0;
            cantidad = 0;
        }
        
        //Agregar un elemento al final de la cola 
        public void encolar(Object elementos){
            if (cantidad == datos.length){
                throw new IllegalStateException("La cola esta llena.");
            }
            datos[fin] = elementos;
            fin = (fin + 1 ) % datos.length;
            cantidad++;
        }

        //Quito y retorno al elemento del frente
        public Object desencolar(){
            if (estaVacia()){
                throw new IllegalStateException("La cola esta vacia.");
            }
            Object extraido = datos[frente];
            datos[frente] = null;
            frente = (frente + 1)% datos.length;
            cantidad--;
            return extraido;
        }
        
        //Retorna el elemento del frente sin quitarlo
        public Object frente(){
            if (estaVacia()){
                 throw new IllegalStateException("la cola esta vacia.");
            }
            return datos[frente];         
        }
        
        public boolean estaVacia(){
            return cantidad == 0;
        }
        public int tamanio(){
            return cantidad;
        }
}




