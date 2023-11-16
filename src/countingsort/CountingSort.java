/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package countingsort;

/**
 *
 * @author Adrian
 */


 public class CountingSort {

    public static void countingSort(int[] array) {
        int max = getMaxValue(array);
        int[] count = new int[max + 1];
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
        int[] array = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Array original:");
        printArray(array);

        countingSort(array);

        System.out.println("Array ordenado:");
        printArray(array);
    }
}
