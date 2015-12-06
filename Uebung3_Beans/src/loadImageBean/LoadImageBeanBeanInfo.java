package loadImageBean;

import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

import util.PropertyHelper;

public class LoadImageBeanBeanInfo extends SimpleBeanInfo{
	
	public class ImageLoaderBeanInfo extends SimpleBeanInfo {

	    public ImageLoaderBeanInfo() {
	    }

	    @Override
	    public PropertyDescriptor[] getPropertyDescriptors() {
	        return PropertyHelper.getPropertyDescriptors(LoadImageBean.class);
	    }

	    @Override
	    public MethodDescriptor[] getMethodDescriptors() {
	        return new MethodDescriptor[]{};
	    }
	}
}
