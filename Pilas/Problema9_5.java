public class Problema9_5 {
    public static void main(String[] args) {
        try {
            MultiPilas mp = new MultiPilas();
            mp.insertar(0, "A");
            mp.insertar(1, "B");
            System.strOut = null; // Referencia auxiliar
            System.out.println("Elementos insertados en multipilas correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}