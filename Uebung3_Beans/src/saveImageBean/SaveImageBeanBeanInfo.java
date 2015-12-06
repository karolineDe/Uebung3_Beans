package saveImageBean;

import java.awt.Image;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class SaveImageBeanBeanInfo extends SimpleBeanInfo{
	
	public Image getIcon(int iconType){
		switch ( iconType )
	      {
	         case ICON_MONO_16x16:
	            return loadImage( "SaveImageIcon.gif" );
	         case ICON_MONO_32x32:
	            return loadImage( "SaveImageIcon.gif" );
	         case ICON_COLOR_16x16:
	            return loadImage( "SaveImageIcon.gif" );
	         case ICON_COLOR_32x32:
	            return loadImage( "SaveImageIcon.gif" );
	         default:
	            return null;
	      }
	}

	@Override
	public PropertyDescriptor[] getPropertyDescriptors(){
		
		try{
			PropertyDescriptor pd1 = new PropertyDescriptor("savePath", SaveImageBean.class);
			return new PropertyDescriptor[]{pd1};
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
