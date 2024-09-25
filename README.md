# Projeto de Algoritmos de Ordenação

Este repositório contém a implementação e análise de desempenho de diversos algoritmos clássicos de ordenação em Java. O objetivo é comparar a eficiência de cada algoritmo na ordenação de grandes conjuntos de números inteiros, sob diferentes condições e distribuições de dados. A análise inclui medições de tempo de execução para cada algoritmo e diversos tipos de conjuntos de dados.

### Algoritmos de Ordenação Implementados
Os seguintes algoritmos de ordenação foram implementados:

* Bubble Sort
* Insertion Sort
* Selection Sort
* Merge Sort
* Quick Sort
* Heap Sort
  
Cada algoritmo foi implementado para ser capaz de:

1. Ler uma sequência de números inteiros a partir de um arquivo de entrada.
2. Ordenar a sequência.
3. Gravar a sequência ordenada em um arquivo de saída.

### Entrada e Saída

* Entrada: Um arquivo de texto contendo números inteiros, um por linha.
* Saída: Um arquivo de texto com os números ordenados em ordem crescente, um por linha.
  
### Tipos de Conjuntos de Dados Testados

Os algoritmos foram testados com diferentes tipos de conjuntos de dados, organizados de várias formas:

1. Crescente com repetição: Números em ordem crescente com alguns valores repetidos.
2. Decrescente com repetição: Números em ordem decrescente com alguns valores repetidos.
3. Aleatório com repetição: Números gerados aleatoriamente com alguns valores repetidos.
4. Crescente sem repetição: Números em ordem crescente, sem repetições.
5. Decrescente sem repetição: Números em ordem decrescente, sem repetições.
6. Aleatório sem repetição: Números gerados aleatoriamente, sem repetições.


### Análise de Desempenho

O desempenho de cada algoritmo foi medido com base no tempo de execução para diferentes tamanhos de entrada, variando de 100.000 a 700.000 números inteiros, com incrementos de 60.000. Para cada cenário, os algoritmos foram executados no mínimo 3 vezes, e a média dos tempos de execução foi utilizada para as conclusões.

Tamanhos de Entrada Testados

* 100.000 elementos
* 160.000 elementos
* 220.000 elementos
* 280.000 elementos
* 340.000 elementos
* 400.000 elementos
* 460.000 elementos
* 520.000 elementos
* 580.000 elementos
* 640.000 elementos
* 700.000 elementos

  
### Métricas de Desempenho

Os tempos de execução foram comparados e tabulados para os diferentes tipos de conjuntos de dados. Gráficos de "número de elementos x tempo de execução" foram gerados para analisar:

* Qual algoritmo apresenta o melhor desempenho com dados ordenados de forma crescente.
* Qual algoritmo é mais eficiente com dados ordenados de forma decrescente.
* Qual algoritmo é mais estável em relação à variação do tempo de processamento, independentemente de como os dados estão organizados.

### Como Executar

Para executar o projeto, siga os seguintes passos:

Compilar o código:
