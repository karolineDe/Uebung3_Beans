package beans;

import java.awt.Image;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class SimpleTestBeanInfo extends SimpleBeanInfo {

	public Image getIcon(int iconType){
		switch ( iconType )
	      {
	         case ICON_MONO_16x16:
	            return loadImage( "SimpleTestIcon.gif" );
	         case ICON_MONO_32x32:
	            return loadImage( "SimpleTestIcon.gif" );
	         case ICON_COLOR_16x16:
	            return loadImage( "SimpleTestIcon.gif" );
	         case ICON_COLOR_32x32:
	            return loadImage( "SimpleTestIcon.gif" );
	         default:
	            return null;
	      }
	}
	
	public PropertyDescriptor[] getPropertyDescriptors() {
		
		try {
		      PropertyDescriptor p1;
		      p1 = new PropertyDescriptor("currentColor", SimpleTest.class);
		      p1.setPropertyEditorClass(CurrentColorSelector.class);
		      PropertyDescriptor pds[] = { p1 };
		      return pds;
		    }
        catch (IntrospectionException e) {
            throw new Error(e.toString());
        }
        
	}

}
