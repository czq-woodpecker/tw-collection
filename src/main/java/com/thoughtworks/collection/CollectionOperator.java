package com.thoughtworks.collection;


import java.util.*;
import java.util.stream.Collectors;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        //选出给定区间中所有的数字
        List<Integer> resultList = new LinkedList<>();
        if (left > right) {
            for (int i = left; i >= right; i--) {
                resultList.add(i);
            }
        } else {
            for (int i = left; i <= right; i++) {
                resultList.add(i);
            }
        }
        return resultList;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        //选出给定区间中所有的偶数
        CollectionOperator collectionOperator = new CollectionOperator();
        List<Integer> listByInterval = collectionOperator.getListByInterval(left, right);
        return listByInterval
                .stream()
                .filter(n -> (n & 1) == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        //选出给定区间中所有的偶数
        return Arrays.stream(array)
                .filter(n -> (n & 1) == 0)
                .boxed()
                .collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        //弹出集合最后一个元素
        return array == null || array.length == 0 ?
                0 : array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        //弹出两个集合的交集
        List<Integer> firstList = new ArrayList<>();
        for (int i = 0; i < firstArray.length; i++) {
            firstList.add(firstArray[i]);
        }
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < secondArray.length; i++) {
            if(firstList.contains(secondArray[i])) {
                resultList.add(secondArray[i]);
            }
        }
        return resultList;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        // 将集合二中与集合一不同的元素加入集合一
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < firstArray.length; i++) {
            resultList.add(firstArray[i]);
        }
        for (int i = 0; i < secondArray.length; i++) {
            if(!resultList.contains(secondArray[i])) {
                resultList.add(secondArray[i]);
            }
        }
        return resultList;

    }
}
