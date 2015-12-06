package util;

import java.beans.*;

public class IntegerVetoable {
	 
	private IntegerVetoable() {
	    }

	    public static int validate(PropertyChangeEvent evt, int minValue)
	    throws PropertyVetoException {

	    	int integerValue = 0;
	    	
	    	if(evt != null){
	    		integerValue = (int) evt.getNewValue();
	    	}
	    	

	        if (integerValue < minValue) {
	            String msg = evt.getPropertyName().toUpperCase() + " should be > " + minValue + ".";
	            throw new PropertyVetoException(msg, evt);
	        }

	        return integerValue;
	    }

	    public static int validate(PropertyChangeEvent evt, int minValue, int maxValue)
	    throws PropertyVetoException {

	    	int integerValue = 0;
	    	
	    	if(evt != null){
	    		integerValue = (int) evt.getNewValue();
	    	}

	        if (integerValue < minValue || integerValue > maxValue) {

	            String msg = evt.getPropertyName().toUpperCase() +" should be in range from \"" +
	                         minValue + "\" to \"" + maxValue + "\".";
	            throw new PropertyVetoException(msg, evt);
	        }

	        return integerValue;
	    }
	}