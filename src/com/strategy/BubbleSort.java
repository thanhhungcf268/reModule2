package com.strategy;


import java.util.List;

public class BubbleSort implements SortStrategy {

    @Override
    public void sort(List<Integer> ts) {
        for (int i = 0; i < ts.size(); i++) {
            for (int j = ts.size() - 1; j > i; j--) {
                if (ts.get(j - 1) < ts.get(j)) {
                    int temp = ts.get(j - 1);
                    ts.set(j - 1, ts.get(j));
                    ts.set(j, temp);
                }
            }
        }
    }
}
