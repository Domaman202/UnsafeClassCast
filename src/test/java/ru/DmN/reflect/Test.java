package ru.DmN.reflect;

public class Test {
    public static void main(String[] args) {
        // Instance
        A obj = new A();

        System.out.println("Нормальный класс:");
        obj.foo();

        System.out.println("\n\nМодифицированный в класс B:");
        UnsafeClassCast.cast(obj, new B());
        obj.foo();

        System.out.println("\n\nМодифицированный в класс C:");
        UnsafeClassCast.cast(obj, new C());
        obj.foo();

        System.out.println("\n\nМодифицированный в класс D:");
        UnsafeClassCast.cast(obj, new D());
        obj.foo();
    }
}

class A {
    int i = 12;

    public void foo() {
        System.out.println("i => " + i);
    }
}

class B {
    int i = 21;
    int j;

    public void foo() {
        i += 5;
        j = -3;
        System.out.println("i += 5 => " + i);
        System.out.println("j => " + j);
    }
}

class C extends A {
    public void foo() {
        i -= 2;
        System.out.println("i -= 2 => " + i);
    }
}

class D extends A {
    int j;

    public void foo() {
        i += 9;
        j += 8;
        System.out.println("i += 9 => " + i);
        System.out.println("j += 8 => " + j);
    }
}