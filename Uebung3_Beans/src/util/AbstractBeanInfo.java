package util;

import java.beans.*;
import java.beans.SimpleBeanInfo;
import java.util.EventListener;
import java.util.EventObject;

public class AbstractBeanInfo<T extends V, U extends EventObject, V extends EventListener> extends SimpleBeanInfo {
	private final Class<T> _beanClass;
	private final Class<U> _eventClass;
	private final Class<V> _listenerClass;

	protected AbstractBeanInfo(Class<T> beanClass, Class<U> eventClass, Class<V> listenerClass) {
		super();
		_beanClass = beanClass;
		_eventClass = eventClass;
		_listenerClass = listenerClass;
	}

	@Override
	public PropertyDescriptor[] getPropertyDescriptors() {
		return PropertyHelper.getPropertyDescriptors(_beanClass);
	}

	@Override
	public EventSetDescriptor[] getEventSetDescriptors() {
		return EventHelper.getEventSetDescriptors(_beanClass, _eventClass, _listenerClass);
	}

	@Override
	public MethodDescriptor[] getMethodDescriptors() {
		return MethodHelper.getMethodDescriptors(_beanClass);
	}
}
