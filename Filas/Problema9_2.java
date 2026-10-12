public class Problema9_2 {
    public static boolean sonIdenticas(PilaLineal p1, PilaLineal p2) throws Exception {
        PilaLineal aux1 = new PilaLineal();
        PilaLineal aux2 = new PilaLineal();
        boolean identicas = true;

        while (!p1.pilaVacia() && !p2.pilaVacia()) {
            Object o1 = p1.quitar();
            Object o2 = p2.quitar();
            aux1.insertar(o1);
            aux2.insertar(o2);
            if (!o1.equals(o2)) {
                identicas = false;
            }
        }

        if (!p1.pilaVacia() || !p2.pilaVacia()) {
            identicas = false; // Tienen tamaños diferentes
        }

        // Restauramos las pilas originales
        while (!aux1.pilaVacia()) p1.insertar(aux1.quitar());
        while (!aux2.pilaVacia()) p2.insertar(aux2.quitar());

        return identicas;
    }
}