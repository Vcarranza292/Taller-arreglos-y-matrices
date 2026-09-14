package Arreglos;

import java.util.Scanner;

public class Ejercicio10 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] A = new int[7];
        int[] B = new int[4];

        for (int i = 0; i < 7; i++) {
            System.out.print("Digite un número: ");
            A[i] = scanner.nextInt();
        }

        B[0] = A[0] + A[6];
        B[1] = A[1] + A[5];
        B[2] = A[2] + A[4];
        B[3] = A[3];

        System.out.println("Arreglo resultante:");

        for (int i = 0; i < 4; i++) {
            System.out.print(B[i] + " ");
        }

        scanner.close();
    }
}