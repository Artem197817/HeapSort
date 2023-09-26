package org.example;

import java.util.Arrays;

public class HeapSort {

    public void sort(int[] arr) {
        int size = arr.length;
        // Построение кучи (перегруппируем массив)
        for (int i = size / 2 - 1; i >= 0; i--)
            heapCreate(arr, size, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = size - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapCreate(arr, i, 0);
        }
    }

    public void heapCreate(int[] arr, int size, int root) {

        int largest = root; // Инициализируем наибольший элемент как корень
        int left = 2 * root + 1; // левый = 2*i + 1
        int right = 2 * root + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (left < size && arr[left] > arr[largest])
            largest = left;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (right < size && arr[right] > arr[largest])
            largest = right;

        // Если самый большой элемент не корень
        if (largest != root) {
            int swap = arr[root];
            arr[root] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapCreate(arr, size, largest);
        }
    }
}