package ru.job4j.solid.dip;

public class Example {

}

// example 1

class A {

}

class B {
    private A a = new A();
}

// example 2

class C {
    public A method() {
        return new A();
    }
}

// example 3

class D {
    public D(A a) {
    }
}