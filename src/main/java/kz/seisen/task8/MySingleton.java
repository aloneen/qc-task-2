package kz.seisen.task8;

import java.io.ObjectStreamException;
import java.io.Serial;
import java.io.Serializable;

public final class MySingleton implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // reflection
    private static boolean initialized = false;

    private MySingleton() {
        if (initialized) {
            throw new RuntimeException("Use getInstance()");
        }
        initialized = true;
    }

    // lazy and thread
    private static class Holder {
        private static final MySingleton INSTANCE = new MySingleton();
    }

    public static MySingleton getInstance() {
        return Holder.INSTANCE;
    }

    // serialization
    @Serial
    private Object readResolve() {
        return getInstance();
    }


}
