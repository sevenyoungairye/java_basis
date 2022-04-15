package top.lel.design.pattern.builder;

import org.junit.jupiter.api.Test;

/**
 * @author echo lovely
 * @date 2021/4/24 19:02
 * @description <p>
 *     Appendable
 *     AbstractStringBuilder
 * </p>
 */

public class JdkBuilderDemo {

    @Test
    void test() {

        StringBuilder sb = new StringBuilder("hhh");
        sb.append("~~");
        sb.indexOf("h");
        System.out.println(sb);

    }

}
