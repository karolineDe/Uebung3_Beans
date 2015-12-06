package visualizeImageBean;

import java.awt.Image;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class VisualizeImageBeanBeanInfo extends SimpleBeanInfo{
	
//	public Image getIcon(int iconType){
//		switch ( iconType )
//	      {
//	         case ICON_MONO_16x16:
//	            return loadImage( "VisualizeImageIcon.gif" );
//	         case ICON_MONO_32x32:
//	            return loadImage( "VisualizeImageIcon.gif" );
//	         case ICON_COLOR_16x16:
//	            return loadImage( "VisualizeImageIcon.gif" );
//	         case ICON_COLOR_32x32:
//	            return loadImage( "VisualizeImageIcon.gif" );
//	         default:
//	            return null;
//	      }
//	}

	@Override
	public PropertyDescriptor[] getPropertyDescriptors(){
		
		try{
			PropertyDescriptor pd1 = new PropertyDescriptor("width", VisualizeImageBean.class);
			PropertyDescriptor pd2 = new PropertyDescriptor("height", VisualizeImageBean.class);
			
			return new PropertyDescriptor[]{pd1, pd2};
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
