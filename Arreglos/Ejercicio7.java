package Arreglos;

import java.util.Scanner;

public class Ejercicio7 {

    public static void main(String[] args) {

        // Declaración de variables
        int[] A = new int[10];
        int[] pares = new int[10];
        int[] impares = new int[10];

        int p = 0;
        int i = 0;

        Scanner scanner = new Scanner(System.in);

        // Leer los 10 números
        for (int j = 0; j < 10; j++) {

            System.out.print("Digite un número: ");
            A[j] = scanner.nextInt();

            // Verificar si el número es par o impar
            if (A[j] % 2 == 0) {

                pares[p] = A[j];
                p++;

            } else {

                impares[i] = A[j];
                i++;
            }
        }

        // Mostrar los números pares
        System.out.println("Números pares:");

        for (int j = 0; j < p; j++) {
            System.out.print(pares[j] + " ");
        }

        // Mostrar los números impares
        System.out.println("\nNúmeros impares:");

        for (int j = 0; j < i; j++) {
            System.out.print(impares[j] + " ");
        }

        scanner.close();
    }
}