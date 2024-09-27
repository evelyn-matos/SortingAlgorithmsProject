package util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ArrayGenerator {

    // Função para gerar um array ordenado com repetição
    public static int[] generateSortedArrayWithDuplicates(int numElements, boolean ascending) {
        int[] array = new int[numElements];
        Random random = new Random();
        int baseNumber = random.nextInt(100); // Número base para repetição

        for (int i = 0; i < numElements; i++) {
            array[i] = baseNumber + random.nextInt(10); // Adiciona números com base no número base
        }

        if (ascending) {
            java.util.Arrays.sort(array); // Ordena o array
        } else {
            java.util.Arrays.sort(array);
            reverse(array); // Inverte para ordem decrescente
        }
        return array;
    }

    // Função para gerar um array ordenado sem repetição
    public static int[] generateSortedArrayWithoutDuplicates(int numElements, boolean ascending) {
        int[] array = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            array[i] = i; // Adiciona números sequenciais
        }
        if (!ascending) {
            reverse(array); // Inverte para ordem decrescente
        }
        return array;
    }

    // Função para gerar um array aleatório com repetição
    public static int[] generateRandomArrayWithDuplicates(int numElements) {
        int[] array = new int[numElements];
        Random random = new Random();
        for (int i = 0; i < numElements; i++) {
            array[i] = random.nextInt(1000); // Faixa de números gerados
        }
        return array;
    }

    // Função para gerar um array aleatório sem repetição
    public static int[] generateRandomArrayWithoutDuplicates(int numElements) {
        int[] array = new int[numElements];
        
        // Preencher o array com uma sequência única de números
        for (int i = 0; i < numElements; i++) {
            array[i] = i;
        }
        
        // Embaralhar o array para gerar uma sequência aleatória
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Troca os elementos
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        
        return array;
    }
    

    // Função para inverter um array
    public static void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
