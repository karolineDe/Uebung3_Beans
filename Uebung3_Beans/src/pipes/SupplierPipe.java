package pipes;

import java.io.StreamCorruptedException;
import interfaces.Readable;

public class SupplierPipe<T> implements Readable<T> {

	private final T _value;

    public SupplierPipe(T value) {
        _value = value;
    }
	
    @Override
    public T read() throws StreamCorruptedException {
        return _value;
    }

}
