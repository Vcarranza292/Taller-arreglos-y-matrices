import java.util.HashMap;
import java.util.Scanner;
import modelo.Estudiante;

public class Main {
  
    public static void main(String[] args) {
       HashMap<String, Estudiante> estudiantes = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n=== GESTION DE ESTUDIANTES ===");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Buscar estudiante por ID");
            System.out.println("3. Listar estudiantes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un numero valido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    if (estudiantes.containsKey(id)) {
                        System.out.println("Ya existe un estudiante registrado con ese ID.");
                        break;
                    }
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Semestre: ");
                    int semestre;
                    try {
                        semestre = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Semestre invalido. Registro cancelado.");
                        break;
                    }

                    Estudiante nuevo = new Estudiante(id, nombre, email, semestre);
                    estudiantes.put(id, nuevo);
                    System.out.println("Estudiante registrado exitosamente.");
                    break;
                
                case 2:
                    System.out.print("Ingrese el ID a buscar: ");
                    String idBuscar = sc.nextLine();
                    Estudiante encontrado = estudiantes.get(idBuscar);
                    if (encontrado == null) {
                        System.out.println("No existe ningun estudiante con el ID: " + idBuscar);
                    } else {
                        System.out.println("\n--- Datos del Estudiante ---");
                        encontrado.mostrarInformacion();
                    }
                    break;

                case 3:
                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        System.out.println("\n--- Lista de Estudiantes ---");
                        for (Estudiante e : estudiantes.values()) {
                            e.mostrarInformacion();
                            System.out.println("----------------------------");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        }
        sc.close();
    }
}