package ua.ronaldo173.library.web.validators;

/**
 * Created by Developer on 19.04.2016.
 */
public class Test {
    public static void main(String[] args) {
//        B b = new B();

        A a = new B();
    }
}

class A {
    public A() {
        print();
    }

    final void print() {
        System.out.println("A");
    }
}

class B extends A {
    void print1() {
        System.out.println("B");
    }
}