public class Problema9_3 {
    public static void cimaAlFondo(PilaLineal p) throws Exception {
        if (p.pilaVacia()) return;

        Object cimaElem = p.quitar();
        if (p.pilaVacia()) {
            p.insertar(cimaElem);
            return;
        }

        PilaLineal aux = new PilaLineal();
        while (!p.pilaVacia()) {
            aux.insertar(p.quitar());
        }

        p.insertar(cimaElem); // El elemento original de la cima pasa a ser el primero en entrar (fondo)

        while (!aux.pilaVacia()) {
            p.insertar(aux.quitar());
        }
    }
}