package Arreglos;

import java.util.Scanner;

public class Ejercicio12 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] A = new int[8];
        int[] B = new int[8];

        int x;
        int contador = 0;

        for (int i = 0; i < 8; i++) {
            System.out.print("Digite un número: ");
            A[i] = scanner.nextInt();
        }

        System.out.print("Digite el valor X: ");
        x = scanner.nextInt();

        for (int i = 0; i < 8; i++) {

            if (A[i] == x) {
                B[contador] = i + 1;
                contador++;
            }
        }

        System.out.println("Posiciones donde aparece " + x + ":");

        for (int i = 0; i < contador; i++) {
            System.out.print(B[i] + " ");
        }

        scanner.close();
    }
}