package SalasDeCine;

import java.util.Scanner;

// ============================================
// CLASE PELÍCULA
// ============================================
class Pelicula {
    private String nombre;
    private String idioma;
    private String tipo;
    private int duracion;
    private String genero;

    public Pelicula(String nombre, String idioma, String tipo, int duracion, String genero) {
        this.nombre = nombre;
        this.idioma = idioma;
        this.tipo = tipo;
        this.duracion = duracion;
        this.genero = genero;
    }

    public String getNombre() { return nombre; }
    public String getIdioma() { return idioma; }
    public String getTipo() { return tipo; }
    public int getDuracion() { return duracion; }
    public String getGenero() { return genero; }

    @Override
    public String toString() {
        return nombre + " (" + genero + ", " + tipo + ", " + idioma + ") - " + duracion + " min";
    }
}

// ============================================
// CLASE SALA
// ============================================
class Sala {
    private int numero;
    private int capacidadMaxima;

    public Sala(int numero) {
        this.numero = numero;
        this.capacidadMaxima = 102; // 6 filas gen * 12 sillas + 2 filas pref * 9 sillas
    }

    public int getNumero() { return numero; }
    public int getCapacidadMaxima() { return capacidadMaxima; }
}

// ============================================
// CLASE FUNCIÓN (CONTIENE LAS SILLAS)
// ============================================
class Funcion {
    private Sala sala;
    private Pelicula pelicula;
    private String horario;
    private char[][] sillas;
    private String[] filas = {"A", "B", "C", "D", "E", "F", "G", "H"};
    private int columnasGenerales = 12;
    private int columnasPreferencial = 9;

    public Funcion(Sala sala, Pelicula pelicula, String horario) {
        this.sala = sala;
        this.pelicula = pelicula;
        this.horario = horario;
        this.sillas = new char[8][12];
        inicializarSillas();
    }

    // Inicializar sillas independientes para esta función
    private void inicializarSillas() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 12; j++) {
                if (i < 6) {
                    sillas[i][j] = (j < columnasGenerales) ? '-' : ' ';
                } else {
                    sillas[i][j] = (j < columnasPreferencial) ? '-' : ' ';
                }
            }
        }
    }

    public Sala getSala() { return sala; }
    public Pelicula getPelicula() { return pelicula; }
    public String getHorario() { return horario; }

    public void mostrarSillas() {
        System.out.println("\n┌─────────────── SALA " + sala.getNumero() + " ──────────────┐");
        System.out.println("                  PANTALLA");
        System.out.println("            ─────────────────────");
        for (int i = 0; i < 8; i++) {
            System.out.print("  " + filas[i] + "  ");
            for (int j = 0; j < 12; j++) {
                if (sillas[i][j] != ' ') {
                    System.out.print(sillas[i][j] + "  ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        System.out.println("└──────────────────────────────────────┘");
        System.out.println("  X = Ocupada    - = Disponible");
    }

    public boolean comprarSilla(String fila, int columna) {
        int filaIndex = -1;
        for (int i = 0; i < filas.length; i++) {
            if (filas[i].equals(fila.toUpperCase())) {
                filaIndex = i;
                break;
            }
        }

        if (filaIndex == -1 || columna < 1 || columna > 12) {
            System.out.println("❌ Silla inválida. Intenta con A1, B5, etc.");
            return false;
        }

        if (sillas[filaIndex][columna - 1] == '-') {
            sillas[filaIndex][columna - 1] = 'X';
            return true;
        } else {
            System.out.println("❌ La silla " + fila.toUpperCase() + columna + " no está disponible");
            return false;
        }
    }

    public boolean esPreferencial(String fila) {
        return fila.toUpperCase().equals("G") || fila.toUpperCase().equals("H");
    }

    public int contarDisponibles() {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 12; j++) {
                if (sillas[i][j] == '-') count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "Sala " + sala.getNumero() + " - " + horario + ": " + pelicula.getNombre();
    }
}

// ============================================
// CLASE PRINCIPAL - CINEMA APP
// ============================================
public class CinemaApp {
    private Pelicula[] peliculas = new Pelicula[100];
    private int countPeliculas = 0;
    private Funcion[] funciones = new Funcion[20];
    private int countFunciones = 0;
    private Sala[] salas = new Sala[3];
    private String[] horarios = {"14:00-16:30", "16:30-19:00", "19:00-21:00"};
    private Scanner scanner = new Scanner(System.in);

    public CinemaApp() {
        salas[0] = new Sala(1);
        salas[1] = new Sala(2);
        salas[2] = new Sala(3);
        cargarPeliculasEjemplo();
        cargarFuncionesEjemplo();
    }

    // ============================================
    // CARGAR PELÍCULAS DE EJEMPLO
    // ============================================
    private void cargarPeliculasEjemplo() {
        peliculas[countPeliculas++] = new Pelicula("John Wick", "Inglés", "35mm", 130, "Acción");
        peliculas[countPeliculas++] = new Pelicula("Rápido y Furioso 10", "Inglés", "35mm", 141, "Acción");
        peliculas[countPeliculas++] = new Pelicula("The Dark Knight", "Inglés", "35mm", 152, "Acción");
        peliculas[countPeliculas++] = new Pelicula("Mad Max: Fury Road", "Inglés", "35mm", 120, "Acción");
        peliculas[countPeliculas++] = new Pelicula("Misión Imposible", "Inglés", "35mm", 131, "Acción");
        peliculas[countPeliculas++] = new Pelicula("El Aro", "Español", "35mm", 115, "Terror");
        peliculas[countPeliculas++] = new Pelicula("La Maldición", "Inglés", "35mm", 92, "Terror");
        peliculas[countPeliculas++] = new Pelicula("Insidious", "Inglés", "35mm", 103, "Terror");
        peliculas[countPeliculas++] = new Pelicula("Sinister", "Inglés", "35mm", 110, "Terror");
        peliculas[countPeliculas++] = new Pelicula("La Llorona", "Español", "35mm", 97, "Terror");
        peliculas[countPeliculas++] = new Pelicula("Superbad", "Inglés", "35mm", 113, "Comedia");
        peliculas[countPeliculas++] = new Pelicula("La Sopa de Caracol", "Español", "35mm", 105, "Comedia");
        peliculas[countPeliculas++] = new Pelicula("Jungla de Cristal", "Inglés", "35mm", 99, "Comedia");
        peliculas[countPeliculas++] = new Pelicula("Get Hard", "Inglés", "35mm", 100, "Comedia");
        peliculas[countPeliculas++] = new Pelicula("Avatar: The Way of Water", "Inglés", "3D", 192, "Aventura");
    }

    // ============================================
    // CARGAR FUNCIONES DE EJEMPLO
    // ============================================
    private void cargarFuncionesEjemplo() {
        funciones[countFunciones++] = new Funcion(salas[0], peliculas[0], horarios[0]);
        funciones[countFunciones++] = new Funcion(salas[0], peliculas[1], horarios[1]);
        funciones[countFunciones++] = new Funcion(salas[0], peliculas[2], horarios[2]);
        funciones[countFunciones++] = new Funcion(salas[1], peliculas[5], horarios[0]);
        funciones[countFunciones++] = new Funcion(salas[1], peliculas[10], horarios[1]);
        funciones[countFunciones++] = new Funcion(salas[1], peliculas[8], horarios[2]);
        funciones[countFunciones++] = new Funcion(salas[2], peliculas[14], horarios[0]);
    }

    // ============================================
    // MENÚ PRINCIPAL
    // ============================================
    public void mostrarMenuPrincipal() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║      🎬 CINEMA STAR - CALI CITY        ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║  1. Crear/Ver Películas                ║");
            System.out.println("║  2. Asignar Funciones                  ║");
            System.out.println("║  3. Vender Entradas                    ║");
            System.out.println("║  4. Salir                              ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.print("Selecciona una opción: ");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        menuPeliculas();
                        break;
                    case 2:
                        menuFunciones();
                        break;
                    case 3:
                        menuVentas();
                        break;
                    case 4:
                        System.out.println("\n✨ ¡Gracias por usar Cinema Star! Hasta luego 👋");
                        salir = true;
                        break;
                    default:
                        System.out.println("❌ Opción inválida");
                }
            } catch (Exception e) {
                System.out.println("❌ Entrada inválida");
                scanner.nextLine();
            }
        }
    }

    // ============================================
    // MENÚ PELÍCULAS
    // ============================================
    private void menuPeliculas() {
        System.out.println("\n--- GESTIÓN DE PELÍCULAS ---");
        System.out.println("1. Ver películas registradas");
        System.out.println("2. Añadir nueva película");
        System.out.print("Selecciona: ");

        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                if (countPeliculas == 0) {
                    System.out.println("No hay películas registradas");
                } else {
                    System.out.println("\n╔════════════════════════════════════════════════════════╗");
                    System.out.println("║           🎞️  PELÍCULAS DISPONIBLES                   ║");
                    System.out.println("╚════════════════════════════════════════════════════════╝");
                    for (int i = 0; i < countPeliculas; i++) {
                        System.out.println((i + 1) + ". " + peliculas[i]);
                    }
                }
            } else if (opcion == 2) {
                System.out.print("Nombre de la película: ");
                String nombre = scanner.nextLine();
                System.out.print("Idioma (Español/Inglés): ");
                String idioma = scanner.nextLine();
                System.out.print("Tipo (35mm/3D): ");
                String tipo = scanner.nextLine();
                System.out.print("Duración (minutos): ");
                int duracion = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Género: ");
                String genero = scanner.nextLine();

                if (countPeliculas < 100) {
                    peliculas[countPeliculas] = new Pelicula(nombre, idioma, tipo, duracion, genero);
                    countPeliculas++;
                    System.out.println("✅ Película añadida correctamente");
                } else {
                    System.out.println("❌ Límite de películas alcanzado");
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Entrada inválida");
            scanner.nextLine();
        }
    }

    // ============================================
    // MENÚ FUNCIONES
    // ============================================
    private void menuFunciones() {
        System.out.println("\n--- ASIGNAR FUNCIONES A SALAS ---");

        if (countPeliculas == 0) {
            System.out.println("❌ Primero debes crear películas");
            return;
        }

        System.out.println("\nSelecciona la película:");
        for (int i = 0; i < countPeliculas; i++) {
            System.out.println((i + 1) + ". " + peliculas[i]);
        }
        System.out.print("Opción: ");

        try {
            int opPeli = scanner.nextInt();
            scanner.nextLine();

            if (opPeli < 1 || opPeli > countPeliculas) {
                System.out.println("Película inválida");
                return;
            }

            Pelicula peliculaSeleccionada = peliculas[opPeli - 1];

            System.out.println("\nSelecciona la sala:");
            System.out.println("1. Sala 1 (General 35mm)");
            System.out.println("2. Sala 2 (General 35mm)");
            System.out.println("3. Sala 3 (Solo 3D)");
            System.out.print("Opción: ");
            int opSala = scanner.nextInt();
            scanner.nextLine();

            if (opSala < 1 || opSala > 3) {
                System.out.println("Sala inválida");
                return;
            }

            Sala salaSeleccionada = salas[opSala - 1];

            // Validar tipo de película según sala
            if (opSala == 3 && !peliculaSeleccionada.getTipo().equals("3D")) {
                System.out.println("❌ La Sala 3 solo permite películas 3D");
                return;
            }

            if ((opSala == 1 || opSala == 2) && peliculaSeleccionada.getTipo().equals("3D")) {
                System.out.println("❌ Las Salas 1 y 2 no pueden proyectar 3D");
                return;
            }

            System.out.println("\nSelecciona el horario:");
            for (int i = 0; i < 3; i++) {
                System.out.println((i + 1) + ". " + horarios[i]);
            }
            System.out.print("Opción: ");
            int opHora = scanner.nextInt();
            scanner.nextLine();

            if (opHora < 1 || opHora > 3) {
                System.out.println("Horario inválido");
                return;
            }

            // Verificar no hay solapamiento
            for (int i = 0; i < countFunciones; i++) {
                if (funciones[i].getSala().getNumero() == salaSeleccionada.getNumero() &&
                    funciones[i].getHorario().equals(horarios[opHora - 1])) {
                    System.out.println("❌ Ya existe una película en esta sala y horario");
                    return;
                }
            }

            if (countFunciones < 20) {
                funciones[countFunciones] = new Funcion(salaSeleccionada, peliculaSeleccionada, horarios[opHora - 1]);
                countFunciones++;
                System.out.println("✅ Función asignada correctamente");
            } else {
                System.out.println("❌ Límite de funciones alcanzado");
            }
        } catch (Exception e) {
            System.out.println("❌ Entrada inválida");
            scanner.nextLine();
        }
    }

    // ============================================
    // MENÚ VENTAS
    // ============================================
    private void menuVentas() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║              💳 VENDER ENTRADAS                        ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");

        if (countFunciones == 0) {
            System.out.println("❌ No hay funciones disponibles");
            return;
        }

        System.out.println("\nSelecciona una función:");
        for (int i = 0; i < countFunciones; i++) {
            Funcion f = funciones[i];
            int disponibles = f.contarDisponibles();
            System.out.println((i + 1) + ". " + f + " (" + disponibles + " sillas)");
        }
        System.out.print("Opción: ");

        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion < 1 || opcion > countFunciones) {
                System.out.println("Función inválida");
                return;
            }

            Funcion funcionSeleccionada = funciones[opcion - 1];
            Pelicula pelicula = funcionSeleccionada.getPelicula();

            System.out.println("\n📽️  Película: " + pelicula.getNombre());
            System.out.println("🎪 Sala: " + funcionSeleccionada.getSala().getNumero());
            System.out.println("⏰ Horario: " + funcionSeleccionada.getHorario());

            boolean seguirComprando = true;
            double totalPagar = 0;
            int boletasGenerales = 0;
            int boletasPreferencial = 0;

            while (seguirComprando) {
                funcionSeleccionada.mostrarSillas();

                System.out.print("\n🪑 Ingresa una silla (ej: A1, B5) o 'salir': ");
                String entrada = scanner.nextLine();

                if (entrada.equalsIgnoreCase("salir")) {
                    seguirComprando = false;
                    break;
                }

                if (entrada.length() < 2) {
                    System.out.println("❌ Formato inválido. Usa A1, B2, etc.");
                    continue;
                }

                try {
                    String fila = entrada.substring(0, 1);
                    int columna = Integer.parseInt(entrada.substring(1));

                    if (funcionSeleccionada.comprarSilla(fila, columna)) {
                        System.out.println("✅ ¡Silla comprada!");

                        if (funcionSeleccionada.esPreferencial(fila)) {
                            totalPagar += 12000;
                            boletasPreferencial++;
                            System.out.println("   💰 Precio: $12.000 (Preferencial)");
                        } else if (pelicula.getTipo().equals("3D")) {
                            totalPagar += 10000;
                            boletasGenerales++;
                            System.out.println("   💰 Precio: $10.000 (3D)");
                        } else {
                            totalPagar += 8000;
                            boletasGenerales++;
                            System.out.println("   💰 Precio: $8.000 (General)");
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ Ingreso inválido. Usa letras y números (A1, C3, etc)");
                    continue;
                }

                System.out.print("¿Comprar otra silla? (s/n): ");
                String resp = scanner.nextLine();
                if (!resp.equalsIgnoreCase("s")) {
                    seguirComprando = false;
                }
            }

            if (totalPagar > 0) {
                System.out.println("\n╔════════════════════════════════════════╗");
                System.out.println("║        💵 FACTURA DE VENTA            ║");
                System.out.println("╠════════════════════════════════════════╣");
                System.out.println("║ Película: " + pelicula.getNombre());
                System.out.println("║ Sala: " + funcionSeleccionada.getSala().getNumero() + " | Horario: " + funcionSeleccionada.getHorario());
                System.out.println("║────────────────────────────────────────║");
                System.out.println("║ Boletas Generales: " + boletasGenerales + " x $8.000");
                System.out.println("║ Boletas Preferencial: " + boletasPreferencial + " x $12.000");
                System.out.println("║────────────────────────────────────────║");
                System.out.println("║ TOTAL A PAGAR: $" + String.format("%,.0f", totalPagar));
                System.out.println("╚════════════════════════════════════════╝");
                System.out.println("✅ ¡Compra realizada exitosamente!");
            }
        } catch (Exception e) {
            System.out.println("❌ Entrada inválida");
            scanner.nextLine();
        }
    }

    // ============================================
    // MAIN
    // ============================================
    public static void main(String[] args) {
        CinemaApp app = new CinemaApp();
        app.mostrarMenuPrincipal();
    }
}
