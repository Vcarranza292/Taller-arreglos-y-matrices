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
            if (estaVacia){
                throw new IllegalStateException("La cola esta vacia.");
            }
            Object extraido = datos[frente];
            datos[frente] = null;
            frente = (frente + 1)% datos.lenght;
            

        }




}

