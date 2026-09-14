package Matrices;

import java.util.Scanner;

public class Ejercicio19 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n, m;

        System.out.print("Digite el número de filas: ");
        n = scanner.nextInt();

        System.out.print("Digite el número de columnas: ");
        m = scanner.nextInt();

        int[][] A = new int[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                A[i][j] = 0;

                if (i == j) {
                    A[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                System.out.print(A[i][j] + " ");
            }

            System.out.println();
        }

        scanner.close();
    }
} 