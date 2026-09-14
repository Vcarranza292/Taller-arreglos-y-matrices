package Matrices;

import java.util.Scanner;

public class Ejercicio24 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] produccion = new int[4][12];

        int suma = 0;
        int mayor = 0;
        int mesMayor = 0;

        int mesesMayor = 0;
        int mesesMenor = 0;

        String[] cereales = {"Arroz", "Avena", "Cebada", "Trigo"};

        for (int i = 0; i < 4; i++) {

            System.out.println("Producción de " + cereales[i]);

            for (int j = 0; j < 12; j++) {

                System.out.print("Digite las toneladas del mes " + (j + 1) + ": ");
                produccion[i][j] = scanner.nextInt();

                suma = suma + produccion[i][j];

                if (produccion[i][j] > mayor) {
                    mayor = produccion[i][j];
                    mesMayor = j + 1;
                }
            }
        }

        double promedio = (double) suma / 48;

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 12; j++) {

                if (produccion[i][j] > promedio) {
                    mesesMayor++;
                }

                if (produccion[i][j] < promedio) {
                    mesesMenor++;
                }
            }
        }

        System.out.println("Promedio anual: " + promedio);
        System.out.println("Meses con producción superior al promedio: " + mesesMayor);
        System.out.println("Meses con producción inferior al promedio: " + mesesMenor);
        System.out.println("El mes con mayor producción fue el mes: " + mesMayor);

        scanner.close();
    }
}