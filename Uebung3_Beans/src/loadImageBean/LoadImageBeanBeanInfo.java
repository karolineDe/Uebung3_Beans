package loadImageBean;

import java.awt.Image;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class LoadImageBeanBeanInfo extends SimpleBeanInfo{
	
//	public Image getIcon(int iconType){
//		switch ( iconType )
//	      {
//	         case ICON_MONO_16x16:
//	            return loadImage( "LoadImageIcon.gif" );
//	         case ICON_MONO_32x32:
//	            return loadImage( "LoadImageIcon.gif" );
//	         case ICON_COLOR_16x16:
//	            return loadImage( "LoadImageIcon.gif" );
//	         case ICON_COLOR_32x32:
//	            return loadImage( "LoadImageIcon.gif" );
//	         default:
//	            return null;
//	      }
//	}

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
