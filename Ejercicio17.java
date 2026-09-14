package Matrices;

import java.util.Scanner;

public class Ejercicio17 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] A = new int[3][3];

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                System.out.print("Digite un número: ");
                A[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Matriz:");

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                System.out.print(A[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println("Suma de cada fila:");

        for (int i = 0; i < 3; i++) {

            int suma = 0;

            for (int j = 0; j < 3; j++) {
                suma = suma + A[i][j];
            }

            System.out.println("Fila " + (i + 1) + ": " + suma);
        }

        System.out.println("Suma de cada columna:");

        for (int j = 0; j < 3; j++) {

            int suma = 0;

            for (int i = 0; i < 3; i++) {
                suma = suma + A[i][j];
            }

            System.out.println("Columna " + (j + 1) + ": " + suma);
        }

        scanner.close();
    }
}