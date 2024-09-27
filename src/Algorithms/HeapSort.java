package Algorithms;

import Algorithms.Interface.SortAlgorithm;

public class HeapSort implements SortAlgorithm {

    @Override
    public void sort(int[] array) {
        int n = array.length;

        // Constrói o heap (reorganiza o array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Extrai os elementos do heap um por um
        for (int i = n - 1; i > 0; i--) {
            // Move a raiz atual para o final
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Chama heapify no heap reduzido
            heapify(array, i, 0);
        }
    }

    private void heapify(int[] array, int n, int i) {
        int largest = i;  // Inicializa o maior como raiz
        int left = 2 * i + 1;  // Filho esquerdo
        int right = 2 * i + 2;  // Filho direito

        // Se o filho esquerdo é maior que a raiz
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // Se o filho direito é maior que o maior até agora
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // Se o maior não for a raiz
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursivamente heapifica a subárvore afetada
            heapify(array, n, largest);
        }
    }
}
