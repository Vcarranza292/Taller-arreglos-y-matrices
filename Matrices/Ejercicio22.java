package Matrices;

import java.util.Scanner;

public class Ejercicio22 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int filas, columnas;
        int mayor, menor;
        int filaMayor = 0;
        int columnaMayor = 0;
        int filaMenor = 0;
        int columnaMenor = 0;

        System.out.print("Digite el número de filas: ");
        filas = scanner.nextInt();

        System.out.print("Digite el número de columnas: ");
        columnas = scanner.nextInt();

        int[][] A = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                System.out.print("Digite un número: ");
                A[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Matriz:");

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {
                System.out.print(A[i][j] + " ");
            }

            System.out.println();
        }

        mayor = A[0][0];
        menor = A[0][0];

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                if (A[i][j] > mayor) {

                    mayor = A[i][j];
                    filaMayor = i;
                    columnaMayor = j;
                }

                if (A[i][j] < menor) {

                    menor = A[i][j];
                    filaMenor = i;
                    columnaMenor = j;
                }
            }
        }

        System.out.println("El número mayor es: " + mayor);
        System.out.println("Posición: fila " + (filaMayor + 1) +
                ", columna " + (columnaMayor + 1));

        System.out.println("El número menor es: " + menor);
        System.out.println("Posición: fila " + (filaMenor + 1) +
                ", columna " + (columnaMenor + 1));

        scanner.close();
    }
}