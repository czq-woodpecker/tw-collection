package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        //根据给定数字无限分割至等于0(提示：9-2=7,7-2=5 ...)
        List<Integer> resultList = new ArrayList<>();
        while (number > 2) {
            number -= 2;
            resultList.add(number);
        }
        return resultList;
    }
}
