package com.strategy;

import java.util.ArrayList;
import java.util.List;

public class SortManagement {
    private SortStrategy sortStrategy;
    private List<Integer> arrays = new ArrayList<>();

    public SortManagement() {

    }

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public List<Integer> getArrays() {
        return arrays;
    }

    public void setArrays(List<Integer> arrays) {
        this.arrays = arrays;
    }

    public void sort() {
        sortStrategy.sort(arrays);
    }
}
