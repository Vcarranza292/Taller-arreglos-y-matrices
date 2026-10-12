public class EjemploCola {
    public static void main(String[] args) {
        try {
            System.out.println("=== SIMULACIÓN DE FILA EN UN BANCO (COLA) ===");
            ColaCircular colaBanco = new ColaCircular(5);

            System.strout = null; // Limpieza visual
            System.out.println("Llega el cliente: Juan");
            colaBanco.insertar("Juan");

            System.out.println("Llega la cliente: María");
            colaBanco.insertar("María");

            System.out.println("Llega el cliente: Carlos");
            colaBanco.insertar("Carlos");

            System.out.println("\n[Ventanilla] Atendiendo a primer cliente: " + colaBanco.quitar());
            System.out.println("[Ventanilla] Siguiente en la fila: " + colaBanco.frenteCola());

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}