package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        HeapSort heapSort = new HeapSort();
        int [] arr = {56,-45,48,5,-78,95,43,-12,98,33,47,-85,88,64};
        heapSort.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}