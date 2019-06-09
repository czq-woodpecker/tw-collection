package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        //求leftBorder 和rightBorder之间的偶数和
        int sum = 0;
        int max, min;
        if (leftBorder > rightBorder) {
            max = leftBorder;
            min = rightBorder;
        } else {
            max = rightBorder;
            min = leftBorder;
        }
        for (int i = min; i <= max; i++) {
            if ((i & 1) == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        //求leftBorder 和rightBorder之间的奇数和
        int sum = 0;
        int max, min;
        if (leftBorder > rightBorder) {
            max = leftBorder;
            min = rightBorder;
        } else {
            max = rightBorder;
            min = leftBorder;
        }
        for (int i = min; i <= max; i++) {
            if ((i & 1) == 1) {
                sum += i;
            }
        }
        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        //求数组中每个元素的3倍加2的和
        return arrayList.stream().mapToInt(n -> 3 * n + 2).sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        //求数组中奇数元素的3倍加2，偶数元素不变的数组
        return arrayList.stream()
                .map(n -> (n & 1) == 1 ? 3 * n + 2 : n)
                .collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        //求数组中奇数元素的3倍加5的和
        return arrayList
                .stream()
                .filter(n -> (n & 1) == 1)
                .mapToInt(n -> n * 3 + 5).sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        //求数组中所有偶数组成的数组的中位数
        List<Integer> evenList = arrayList
                .stream()
                .filter(n -> (n & 1) == 0)
                .sorted()
                .collect(Collectors.toList());
        int count = evenList.size();
        return (evenList.get((count - 1) / 2) + evenList.get(count / 2)) / 2.0;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        //求数组中所有偶数的平均数
        OptionalDouble optionalDouble = arrayList
                .stream()
                .filter(n -> (n & 1) == 0)
                .mapToInt(n -> n)
                .average();
        return optionalDouble.isPresent() ? optionalDouble.getAsDouble() : 0;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        // 求数组中所有偶数组成的数组是否包含某特定的数specialElment
        Set<Integer> evenSet = arrayList
                .stream()
                .filter(n -> (n & 1) == 0)
                .collect(Collectors.toSet());
        return evenSet.contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        //找出数组中的所有偶数，从中剔除重复数据并返回
        return arrayList
                .stream()
                .filter(n -> (n & 1) == 0)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        //排序数组 结果使数组偶数在递增在前，奇数递减在后
        List<Integer> evenList = arrayList
                .stream().filter(n -> (n & 1) == 0)
                .sorted()
                .collect(Collectors.toList());
        List<Integer> oddList = arrayList
                .stream()
                .filter(n -> (n & 1) == 1)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        evenList.addAll(oddList);
        return evenList;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        // 数组中前一个元素和后一个元素的和的3倍的数组
        List<Integer> resultList = new LinkedList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            resultList.add((arrayList.get(i) + arrayList.get(i + 1)) * 3);
        }
        return resultList;
    }
}
