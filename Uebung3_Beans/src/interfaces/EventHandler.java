package interfaces;

import java.util.EventListener;
import java.util.EventObject;

public interface EventHandler<T1 extends EventListener, T2 extends EventObject> {

	void addImageListener(T1 listener);
	void removeImageListener(T1 listener);
	void notifyAllListeners(T2 event);
}
