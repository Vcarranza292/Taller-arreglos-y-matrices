package Matrices;

import java.util.Scanner;

public class Ejercicio21 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] A = new int[3][3];
        int[] B = new int[3];

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                System.out.print("Digite un número: ");
                A[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (A[i][j] % 2 == 0) {
                    B[i] = B[i] + A[i][j];
                }
            }
        }

        System.out.println("Vector resultante:");

        for (int i = 0; i < 3; i++) {
            System.out.print(B[i] + " ");
        }

        scanner.close();
    }
}