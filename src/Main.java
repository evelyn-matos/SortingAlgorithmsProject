import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Algorithms.BubbleSort;
import Algorithms.HeapSort;
import Algorithms.InsertionSort;
import Algorithms.MergeSort;
import Algorithms.SelectionSort;
import Algorithms.Interface.SortAlgorithm;
import util.ArrayGenerator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Projeto de Algoritmos de Ordenação Iniciado");

        Scanner scanner = new Scanner(System.in);
        
        // Escolher o tamanho do conjunto de dados
        System.out.println("Digite a quantidade de números a serem gerados (ex: 100000):");
        int numElements = scanner.nextInt();
        
        // Loop para gerar todos os tipos de conjuntos de dados
        for (int choice = 1; choice <= 6; choice++) {
            // Geração do conjunto de dados baseado na escolha do usuário
            int[] array = generateArray(choice, numElements);
            if (array == null) {
                System.out.println("Opção inválida.");
                continue; // Se não for um tipo válido, pula para a próxima iteração
            }

            // Instância dos algoritmos de ordenação
            SortAlgorithm bubbleSort = new BubbleSort();
            SortAlgorithm insertionSort = new InsertionSort();
            SortAlgorithm selectionSort = new SelectionSort();
            SortAlgorithm mergeSort = new MergeSort();
            SortAlgorithm heapSort = new HeapSort();

            
            StringBuilder results = new StringBuilder();

            
            long totalTimeBubbleSort = measureSortTime(bubbleSort, array);
            results.append("Algoritmo: Bubble Sort\nTempo de execução: " + totalTimeBubbleSort + " ms\n");

            
            long totalTimeInsertionSort = measureSortTime(insertionSort, array.clone());
            results.append("Algoritmo: Insertion Sort\nTempo de execução: " + totalTimeInsertionSort + " ms\n");

            
            long totalTimeSelectionSort = measureSortTime(selectionSort, array.clone());
            results.append("Algoritmo: Selection Sort\nTempo de execução: " + totalTimeSelectionSort + " ms\n");

            
            long totalTimeMergeSort = measureSortTime(mergeSort, array.clone());
            results.append("Algoritmo: Merge Sort\nTempo de execução: " + totalTimeMergeSort + " ms\n");

            
            long totalTimeHeapSort = measureSortTime(heapSort, array.clone());
            results.append("Algoritmo: Heap Sort\nTempo de execução: " + totalTimeHeapSort + " ms\n");

            
            String datasetType = getDatasetType(choice);
            String filename = datasetType + "_" + numElements + ".txt";

            
            try {
                writeToFile("data/" + numElements, filename, array, results.toString());

                System.out.println(results.toString());
            } catch (IOException e) {
                System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
            }
        }

        scanner.close(); // Fecha o scanner após a leitura
    }

    private static int[] generateArray(int choice, int numElements) {
        switch (choice) {
            case 1:
                return ArrayGenerator.generateSortedArrayWithDuplicates(numElements, true);
            case 2:
                return ArrayGenerator.generateSortedArrayWithDuplicates(numElements, false);
            case 3:
                return ArrayGenerator.generateRandomArrayWithDuplicates(numElements);
            case 4:
                return ArrayGenerator.generateSortedArrayWithoutDuplicates(numElements, true);
            case 5:
                return ArrayGenerator.generateSortedArrayWithoutDuplicates(numElements, false);
            case 6:
                return ArrayGenerator.generateRandomArrayWithoutDuplicates(numElements);
            default:
                return null; 
        }
    }

    private static String getDatasetType(int choice) {
        switch (choice) {
            case 1:
                return "crescenteComRepeticao";
            case 2:
                return "decrescenteComRepeticao";
            case 3:
                return "aleatorioComRepeticao";
            case 4:
                return "crescenteSemRepeticao";
            case 5:
                return "decrescenteSemRepeticao";
            case 6:
                return "aleatorioSemRepeticao";
            default:
                return "invalido";
        }
    }

    private static long measureSortTime(SortAlgorithm sorter, int[] array) {
        long startTime = System.nanoTime();
        sorter.sort(array); // Chama o método sort do algoritmo
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000;
    }

    public static void writeToFile(String folder, String filename, int[] array, String content) throws IOException {
        String fullPath = folder + "/" + filename;
        BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath));
        writer.write(content);
        writer.write("Array ordenado:\n");
        
        for (int num : array) {
            writer.write(num + "\n");
        }
        writer.close();
    }
}
