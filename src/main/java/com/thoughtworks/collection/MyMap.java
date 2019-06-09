package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        //将集合A中的元素映射成集合B中的元素：B[i] = 3 * A[i]
        return array
                .stream()
                .map(n -> n * 3)
                .collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        //数字映射为字母
        return array
                .stream()
                .map(n -> String.valueOf((char) ('a' + (n - 1))))
                .collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        //字母表映射 1->a 13->m 27->aa 53->ba 即26进制
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (Integer i : array) {
            i = i - 1;
            if (i > 25) {
                sb.append(letters[i / 26 - 1]);
                sb.append(letters[i % 26]);
            } else {
                sb.append(letters[i]);
            }
            result.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return result;
    }

    public List<Integer> sortFromBig() {
        //从大到小排序
        return array
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        //从小到大排序
        return array
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
