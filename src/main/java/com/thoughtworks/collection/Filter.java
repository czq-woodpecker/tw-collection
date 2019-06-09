package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    public List<Integer> filterEven() {
        //求数组中的偶数
        return array
                .stream()
                .filter(n -> (n & 1) == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> filterMultipleOfThree() {
        //求数组中3的倍数
        return array
                .stream()
                .filter(n -> n % 3 == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        //求两数组的公共元素
        return firstList
                .stream()
                .filter(n -> secondList.contains(n))
                .collect(Collectors.toList());
    }

    public List<Integer> getDifferentElements() {
        //去除数组中的重复元素
        return array
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }
}