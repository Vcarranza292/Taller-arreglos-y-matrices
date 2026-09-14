package Arreglos;

import java.util.Scanner;

public class Ejercicio9 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] A = new int[10];
        int numero;
        int contador = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite un número: ");
            A[i] = scanner.nextInt();
        }

        System.out.print("Digite el número que desea buscar: ");
        numero = scanner.nextInt();

        for (int i = 0; i < 10; i++) {

            if (A[i] == numero) {
                contador++;
            }
        }

        System.out.println("El número " + numero + " se encuentra " + contador + " veces");

        scanner.close();
    }
}