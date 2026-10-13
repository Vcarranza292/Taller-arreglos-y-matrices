public class Problema9_6 {
    public static boolean esPalindromo(String texto) throws Exception {
        String limpio = texto.replaceAll("\\s+", "").toLowerCase();
        PilaLineal p = new PilaLineal(limpio.length());

        for (int i = 0; i < limpio.length(); i++) {
            p.insertar(limpio.charAt(i));
        }

        for (int i = 0; i < limpio.length(); i++) {
            char letraPila = (char) p.quitar();
            if (letraPila != limpio.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}