package com.keep.easy;

import java.util.*;

/**
 * 问题是这样的：
 * 我的输入是一个正整数n（int类型，且n>0）
 * 通过这个n，可以生成一个分数数列，生成规则是
 * 1/1, 1/2, 2/2, 1/3, 2/3, 3/3,......,1/n,2/n, ... ,n/n
 * 把这个分数的数列，按照数值的大小，从小到大排个序，然后输出出来。
 * 每行一个分数，格式为“分子/分母”。
 * 例如，当n=3的时候，
 * 生成的数列为：1/1,1/2,2/2,1/3,2/3,3/3
 * 排序后输出的结果为：1/3,1/2,2/3,1/1.2/2,3/3
 * 如果有分数值相等，先后顺序无所谓，比如上面1/1,2/2,3/3都是1，谁前谁后都可以。
 * 说明一下，排序如果能用系统提供的方法，可以直接用
 * 如果直接在这个文本上有困难，可以开个ide，写好贴过来
 */
public class 分数数列生成 {

    public static void method(int n) {
        HashMap<String, Double> tempMap = new HashMap<>();
        List<String> resultList = new ArrayList<>();
        List<String> tempList = new ArrayList<>();

        // 生成列表
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                double num = new Double(j / (double) i);
                // 拼接并加入列表
                tempMap.put(j + "/" + i, num);

                Set<Map.Entry<String,Double>> stringSet = tempMap.entrySet();
                Iterator<Map.Entry<String,Double>> iterator = stringSet.iterator();
                while (iterator.hasNext()) {
                    // 转为数值
                    if (num < iterator.next().getValue()) {
                        resultList.add(iterator.next().getKey());
                    }
                }
            }
        }
        // 排序
        System.out.println(resultList);
//        List<Map.Entry<String,Double>> list = new ArrayList<>(resultMap.entrySet());
//
//        //然后通过比较器来实现排序
//        Collections.sort(list,new Comparator<Map.Entry<String,Double>>() {
//            @Override
//            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
//                return o1.getValue().compareTo(o2.getValue());
//            }
//        });
//        System.out.println(list);
    }

    public static void main(String[] args) {
        method(3);
    }

}
