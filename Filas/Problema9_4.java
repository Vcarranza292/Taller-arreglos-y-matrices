public class Problema9_4 {
    public static void eliminarIesimo(PilaLineal p, int i) throws Exception {
        PilaLineal aux = new PilaLineal();
        int contador = 1;

        while (!p.pilaVacia() && contador < i) {
            aux.insertar(p.quitar());
            contador++;
        }

        if (!p.pilaVacia()) {
            p.quitar(); // Eliminamos el elemento i-ésimo
        }

        while (!aux.pilaVacia()) {
            p.insertar(aux.quitar());
        }
    }
}