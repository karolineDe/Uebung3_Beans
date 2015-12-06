package dilateImage;

import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class DilateImageBeanInfo extends SimpleBeanInfo {

	@Override
	public PropertyDescriptor[] getPropertyDescriptors(){
		
		try{
			PropertyDescriptor propDesc = new PropertyDescriptor("radius", DilateImage.class);
			return new PropertyDescriptor[]{propDesc};
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}
