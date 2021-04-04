package ru.DmN.reflect;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeClassCast {
    static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (Exception ignored)
        {
            return null;
        }
    }

    public static Object cast(Object instance, Object to) {
        Unsafe unsafe = getUnsafe();
        unsafe.putInt(instance, 8L, unsafe.getInt(to, 8L));
        return instance;
    }
}
