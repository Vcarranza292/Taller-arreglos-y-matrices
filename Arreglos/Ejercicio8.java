package Arreglos;

import java.util.Scanner;

public class Ejercicio8 {

    public static void main(String[] args) {

        int[] A = new int[30];

        int mayor, menor;
        int vecesMayor = 0;
        int vecesMenor = 0;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 30; i++) {
            System.out.print("Digite un número: ");
            A[i] = scanner.nextInt();
        }

        mayor = A[0];
        menor = A[0];

        for (int i = 1; i < 30; i++) {

            if (A[i] > mayor) {
                mayor = A[i];
            }

            if (A[i] < menor) {
                menor = A[i];
            }
        }

        for (int i = 0; i < 30; i++) {

            if (A[i] == mayor) {
                vecesMayor++;
            }

            if (A[i] == menor) {
                vecesMenor++;
            }
        }

        System.out.println("El número mayor es: " + mayor);
        System.out.println("Se repite " + vecesMayor + " veces");

        System.out.println("El número menor es: " + menor);
        System.out.println("Se repite " + vecesMenor + " veces");

        scanner.close();
    }
}