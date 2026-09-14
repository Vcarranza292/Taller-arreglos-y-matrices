package Arreglos;

import java.util.Scanner;

public class Ejercicio11 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] A = new int[10];
        int[] negativos = new int[10];
        int[] ceros = new int[10];
        int[] positivos = new int[10];

        int n = 0;
        int c = 0;
        int p = 0;

        for (int i = 0; i < 10; i++) {

            System.out.print("Digite un número: ");
            A[i] = scanner.nextInt();

            if (A[i] < 0) {

                negativos[n] = A[i];
                n++;

            } else {

                if (A[i] == 0) {

                    ceros[c] = A[i];
                    c++;

                } else {

                    positivos[p] = A[i];
                    p++;
                }
            }
        }

        System.out.println("Números negativos:");

        for (int i = 0; i < n; i++) {
            System.out.print(negativos[i] + " ");
        }

        System.out.println("\nNúmeros cero:");

        for (int i = 0; i < c; i++) {
            System.out.print(ceros[i] + " ");
        }

        System.out.println("\nNúmeros positivos:");

        for (int i = 0; i < p; i++) {
            System.out.print(positivos[i] + " ");
        }

        scanner.close();
    }
}