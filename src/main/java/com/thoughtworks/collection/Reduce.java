package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        // 获取数组中的最大值
//        return Collections.max(arrayList);
        return arrayList
                .stream()
                .max(Integer::compareTo)
                .get();
    }

    public double getMinimum() {
        //获取数组中的最小值
        return arrayList
                .stream()
                .min(Integer::compareTo)
                .get();
    }

    public double getAverage() {
        // 获取数组的平均值
        return arrayList
                .stream()
                .mapToInt(n -> n)
                .average()
                .getAsDouble();
    }

    public double getOrderedMedian() {
        // 获取数组中位数
        List<Integer> orderList = arrayList
                .stream()
                .sorted()
                .collect(Collectors.toList());
        int count = orderList.size();
        return (arrayList.get((count - 1) / 2) + arrayList.get(count / 2)) / 2.0;
    }

    public int getFirstEven() {
        for (int i = 0; i < arrayList.size(); i++) {
            if ((arrayList.get(i) & 1) == 0) {
                return arrayList.get(i);
            }
        }
        return 0;
    }

    public int getIndexOfFirstEven() {
        for (int i = 0; i < arrayList.size(); i++) {
            if ((arrayList.get(i) & 1) == 0) {
                return i;
            }
        }
        return 0;
    }

    public boolean isEqual(List<Integer> arrayList) {
        for (int i = 0; i < this.arrayList.size(); i++) {
            if (!arrayList.contains(this.arrayList.get(i))) {
                return false;
            }
        }
        return true;
//        return this.arrayList.equals(arrayList);
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        int count = arrayList.size();
        return (arrayList.get((count - 1) / 2) + arrayList.get(count / 2)) / 2.0;
    }

    public int getLastOdd() {
        int lastOdd = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if ((arrayList.get(i) & 1) == 1) {
                lastOdd = arrayList.get(i);
            }
        }
        return lastOdd;
    }

    public int getIndexOfLastOdd() {
        //获取数组中最后一个奇数的下标
        int lastOddIndex = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if ((arrayList.get(i) & 1) == 1) {
                lastOddIndex = i;
            }
        }
        return lastOddIndex;
    }
}
