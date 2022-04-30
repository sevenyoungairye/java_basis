package top.lel.jvm.sdk.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author echo lovely
 * @date 2022/4/30 11:29
 * @description simple stream demo
 */

public class StreamDemo {

    public static void main(String[] args) {


        parallelShow();
    }

    static void parallelShow() {

        List<String> collect = Stream.of("hello", "world", "okay", "i", "am", "your", "dad").collect(Collectors.toList());
        collect.parallelStream().distinct().forEach(item -> System.out.println(item + "\t" + Thread.currentThread().getName()));
        System.out.println("============");

        collect.stream().distinct().forEach(item -> System.out.println(item + "\t" + Thread.currentThread().getName()));
    }


}
