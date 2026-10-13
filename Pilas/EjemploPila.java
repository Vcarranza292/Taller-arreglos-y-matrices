public class EjemploPila {
    public static void main(String[] args) {
        try {
            System.out.println("=== PRUEBA PRÁCTICA: HISTORIAL DE UN NAVEGADOR WEB (PILA) ===");
            PilaLineal historial = new PilaLineal();

            System.out.println("-> Entrando a: google.com");
            historial.insertar("google.com");
            
            System.out.println("-> Entrando a: youtube.com");
            historial.insertar("youtube.com");
            
            System.out.println("-> Entrando a: github.com");
            historial.insertar("github.com");

            System.out.println("\n[Pantalla] Página actual en la que estás: " + historial.cimaPila());

            Object paginaCerrada = historial.quitar();
            System.out.println("<- Presionaste 'Atrás'. Saliendo de: " + paginaCerrada);

            System.out.println("[Pantalla] Nueva página actual: " + historial.cimaPila());

            System.out.println("\nLimpiando el historial de navegación...");
            historial.limpiarPila();
            System.out.println("¿El historial está vacío?: " + historial.pilaVacia());

        } catch (Exception e) {
            System.err.println("Ocurrió un error: " + e.getMessage());
        }
    }
}