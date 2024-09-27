package Algorithms;

import Algorithms.Interface.SortAlgorithm;

public class SelectionSort implements SortAlgorithm {

    @Override
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            // Troca o menor elemento com o primeiro elemento não ordenado
            int temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
        }
    }
}
