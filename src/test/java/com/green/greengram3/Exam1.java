package com.green.greengram3;

import org.apache.http.util.Asserts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Exam1 {

    @Test
    @DisplayName("이것은 무엇무엇을 테스트")
    public void test1() {
        System.out.println("test1");
        int sum = 2 + 2;
        Assertions.assertEquals(4, sum);
    }

    @Test
    public void test2() {
        System.out.println("test2");
        int multi = 2 * 3;
        Assertions.assertEquals(6, multi);
    }

    @Test
    public void test3() {
        Assertions.assertEquals(4, MyUtils.sum(2, 2), "1test");
        Assertions.assertEquals(5, MyUtils.sum(2, 3), "2test");
        Assertions.assertEquals(15, MyUtils.sum(12, 3));
        Assertions.assertEquals(18, MyUtils.sum(5, 13));
    }

    @Test
    public void test4() {
        MyUtils utils = new MyUtils();
        Assertions.assertEquals(15, utils.multi(5, 3));
        Assertions.assertEquals(35, utils.multi(5, 7));
        Assertions.assertEquals(7, utils.multi(1, 7));
    }
}
