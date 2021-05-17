package com.strategy;

import java.util.List;

public class SelectionSort implements SortStrategy {
    @Override
    public void sort(List<Integer> ts) {
        for (int i = 0; i < ts.size(); i++) {
            for (int j = 0; j < ts.size(); j++) {
                if(ts.get(i) < ts.get(j)){
                    int temp = ts.get(i);
                    ts.set(i, ts.get(j));
                    ts.set(j, temp);
                }
            }
        }
    }
}
