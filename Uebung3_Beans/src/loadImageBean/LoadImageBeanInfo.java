package loadImageBean;

import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class LoadImageBeanInfo extends SimpleBeanInfo{

	@Override
	public PropertyDescriptor[] getPropertyDescriptors(){
		
		try{
			PropertyDescriptor propDesc = new PropertyDescriptor("path", LoadImageBean.class);
			return new PropertyDescriptor[]{propDesc};
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
