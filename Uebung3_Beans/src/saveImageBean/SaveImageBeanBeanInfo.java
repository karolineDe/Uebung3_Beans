package saveImageBean;

import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class SaveImageBeanBeanInfo extends SimpleBeanInfo{

	@Override
	public PropertyDescriptor[] getPropertyDescriptors(){
		
		try{
			PropertyDescriptor pd1 = new PropertyDescriptor("filename", SaveImageBean.class);
			return new PropertyDescriptor[]{pd1};
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
