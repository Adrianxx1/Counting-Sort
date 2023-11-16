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

    /**
     * @param args the command line arguments
     */
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
}

    private static int getMaxValue(int[] array) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}