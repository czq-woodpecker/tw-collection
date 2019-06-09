package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Flaten {

    Integer[][] array;

    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        //把二维数组变成一维数组
        return Arrays.stream(array)
                .flatMap(sonArray -> Arrays.stream(sonArray))
                .collect(Collectors.toList());
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        // 把二维数组变成一维数组,消除重复,按照第一次出现的顺序排列最后的输出结果
        return Arrays.stream(array)
                .flatMap(sonArray -> Arrays.stream(sonArray))
                .distinct()
                .collect(Collectors.toList());
    }
}
