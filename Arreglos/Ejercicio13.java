package Arreglos;

import java.util.Scanner;

public class Ejercicio13 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] A = new int[10];
        int[] mayores = new int[10];
        int[] menores = new int[10];

        int suma = 0;
        double media;

        int m = 0;
        int n = 0;

        for (int i = 0; i < 10; i++) {

            System.out.print("Digite un número: ");
            A[i] = scanner.nextInt();

            suma = suma + A[i];
        }

        media = (double) suma / 10;

        for (int i = 0; i < 10; i++) {

            if (A[i] > media) {

                mayores[m] = A[i];
                m++;

            } else {

                if (A[i] < media) {
                    menores[n] = A[i];
                    n++;
                }
            }
        }

        System.out.println("La media es: " + media);

        System.out.println("Números mayores que la media:");

        for (int i = 0; i < m; i++) {
            System.out.print(mayores[i] + " ");
        }

        System.out.println("\nNúmeros menores que la media:");

        for (int i = 0; i < n; i++) {
            System.out.print(menores[i] + " ");
        }

        scanner.close();
    }
}