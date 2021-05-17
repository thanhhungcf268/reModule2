package com;

import com.strategy.BubbleSort;
import com.strategy.SelectionSort;
import com.strategy.SortManagement;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> arrays = new ArrayList<>();
        arrays.add(5);
        arrays.add(1);
        arrays.add(6);
        arrays.add(8);
        arrays.add(4);
        arrays.add(3);
        SortManagement sortManagement = new SortManagement();
        sortManagement.setArrays(arrays);
        sortManagement.setSortStrategy(new BubbleSort());
        sortManagement.sort();
        System.out.println("Mang sau khi sap xep noi bot:\n");
        for (Integer element : arrays) {
            System.out.print(element + " ");
        }
        sortManagement.setSortStrategy(new SelectionSort());
        sortManagement.sort();
        System.out.println("Mang sau khi sap xep chon:\n");
        for (Integer element : arrays) {
            System.out.print(element + " ");
        }
    }
}
