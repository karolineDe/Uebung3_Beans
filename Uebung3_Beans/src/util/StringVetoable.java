package util;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;

public class StringVetoable {

	public static String validate(PropertyChangeEvent evt)
		    throws PropertyVetoException {
		        String newString = (String) evt.getNewValue();

		        if (newString == null || newString.trim().isEmpty()) {
		            String msg = evt.getPropertyName().toUpperCase() + " should not be empty.";
		            throw new PropertyVetoException(msg, evt);
		        }

		        return newString;
		    }
}
