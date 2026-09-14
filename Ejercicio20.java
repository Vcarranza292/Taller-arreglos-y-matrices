package Matrices;

public class Ejercicio20 {

    public static void main(String[] args) {

        int[][] A = new int[10][10];

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                if (j >= i) {
                    A[i][j] = 0;
                } else {
                    A[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {
                System.out.print(A[i][j] + " ");
            }

            System.out.println();
        }
    }
}