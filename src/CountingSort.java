import java.util.Scanner;

public class CountingSort {

    public static void countingSort(int[] array) {
        // llamado para encontar el valor maximo dentro del arreglo
        int max = getMaxValue(array);
        // count para almacenar la frecuencia de cada elemento
        int[] count = new int[max + 1];
        // para almacenar los elementos ordenados
        int[] sortedArray = new int[array.length];

        // Contar la frecuencia de cada elemento
        for (int i : array) {
            count[i]++;
        }

        // Actualizar el array de conteo para contener las posiciones reales de los elementos en el array ordenado
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Construir el array ordenado
        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copiar el array ordenado de vuelta al array original
        System.arraycopy(sortedArray, 0, array, 0, array.length);
    }

    private static int getMaxValue(int[] array) {
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ingresar el numero de elementos que el arreglo va a contener
        System.out.print("Ingresa el tamaño del arreglo: ");
        int size = scanner.nextInt();

        // Ingresa el valor de los arreglos 
        int[] array = new int[size];
        System.out.println("Ingresa los valores del arreglo:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        System.out.println("Array original:");
        printArray(array);

        countingSort(array);

        System.out.println("Array ordenado:");
        printArray(array);

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
