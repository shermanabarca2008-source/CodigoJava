package unidad3;
import java.util.Scanner;

public class matrices {

    public static void main(String[] args) {
        matrices objeto = new matrices();
        Scanner sc = new Scanner(System.in);
        String dato = "";
        
        int[][] m1 = new int[2][3];
        int[][] m2 = new int[2][3];
        int[][] resultado = null;

        objeto.completarMatrices(m1, m2);

        do {
            System.out.println("\nSeleccione la operacion a realizar '+', '-' y '*'. Escriba 'salir' para terminar.");
            dato = sc.nextLine();

            switch (dato) {
                case "+":
                    resultado = objeto.sumaMatrices(m1, m2);
                    break;
                case "-":
                    resultado = objeto.restaMatrices(m1, m2);
                    break;
                case "*":
                    resultado = objeto.multiplicacionMatrices(m1, m2);
                    break;
                case "salir":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Operación no disponible.");
                    break;
            }

            if (resultado != null) {
                objeto.mostrarResultados(resultado);
                resultado = null; // Limpiamos para la siguiente vuelta
            }

        } while (!dato.equalsIgnoreCase("salir"));
    }

    // Recibe las matrices creadas en el main y las llena
    public void completarMatrices(int[][] matriz1, int[][] matriz2) {
        Scanner sc = new Scanner(System.in); 
        System.out.println("Llenando la matriz 1:");
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                System.out.print("M1 - Fila " + i + ", Columna " + j + ": ");
                matriz1[i][j] = sc.nextInt(); 
            }
        }
        System.out.println("Llenando la matriz 2:");
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[i].length; j++) {
                System.out.print("M2 - Fila " + i + ", Columna " + j + ": ");
                matriz2[i][j] = sc.nextInt(); 
            }
        }
    }

    // Cambiamos VOID por INT[][] para que pueda devolver el resultado al MAIN
    public int[][] sumaMatrices(int[][] m1, int[][] m2) {
        int[][] res = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                res[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return res;
    }

    public int[][] restaMatrices(int[][] m1, int[][] m2) {
        int[][] res = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                res[i][j] = m1[i][j] - m2[i][j]; // Corregido a RESTA
            }
        }
        return res;
    }

    public int[][] multiplicacionMatrices(int[][] m1, int[][] m2) {
        int[][] res = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                res[i][j] = m1[i][j] * m2[i][j]; // Multiplicación simple posición a posición
            }
        }
        return res;
    }

    private void mostrarResultados(int[][] resultado) {
        System.out.println("El resultado es:");
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) {
                System.out.print(resultado[i][j] + "\t");
            }
            System.out.println(); // Salto de línea corregido
        }
    }
}