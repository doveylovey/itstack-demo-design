package org.itstack.demo.design.test;

import org.itstack.demo.design.Singleton_00;
import org.itstack.demo.design.Singleton_01;
import org.itstack.demo.design.Singleton_02;
import org.itstack.demo.design.Singleton_03;
import org.itstack.demo.design.Singleton_04;
import org.itstack.demo.design.Singleton_05;
import org.itstack.demo.design.Singleton_06;
import org.itstack.demo.design.Singleton_07;
import org.junit.Test;

public class ApiTest {
    @Test
    public void testSingleton_00() {
        System.out.println(Singleton_00.cache);
        System.out.println(Singleton_00.cache);
    }

    @Test
    public void testSingleton_01() {
        System.out.println(Singleton_01.getInstance());
        System.out.println(Singleton_01.getInstance());
    }

    @Test
    public void testSingleton_02() {
        System.out.println(Singleton_02.getInstance());
        System.out.println(Singleton_02.getInstance());
    }

    @Test
    public void testSingleton_03() {
        System.out.println(Singleton_03.getInstance());
        System.out.println(Singleton_03.getInstance());
    }

    @Test
    public void testSingleton_04() {
        System.out.println(Singleton_04.getInstance());
        System.out.println(Singleton_04.getInstance());
    }

    @Test
    public void testSingleton_05() {
        System.out.println(Singleton_05.getInstance());
        System.out.println(Singleton_05.getInstance());
    }

    @Test
    public void testSingleton_06() {
        System.out.println(Singleton_06.getInstance());
        System.out.println(Singleton_06.getInstance());
    }

    @Test
    public void testSingleton_07() {
        Singleton_07.INSTANCE.test();
    }
}
