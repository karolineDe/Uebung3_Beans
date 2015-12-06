package visualizeImageBean;

import java.beans.EventSetDescriptor;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

import util.MethodHelper;
import util.PropertyHelper;

public class VisualizeImageBeanBeanInfo extends SimpleBeanInfo{
	
	public VisualizeImageBeanBeanInfo() {
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        return PropertyHelper.getPropertyDescriptors(VisualizeImageBean.class);
    }

    @Override
    public EventSetDescriptor[] getEventSetDescriptors() {
        return new EventSetDescriptor[]{};
    }

    @Override
    public MethodDescriptor[] getMethodDescriptors() {
        return MethodHelper.getMethodDescriptors(VisualizeImageBean.class);
    }
}
