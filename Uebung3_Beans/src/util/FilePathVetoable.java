package util;

import java.beans.*;
import java.io.File;

public class FilePathVetoable {
	
	private FilePathVetoable() {
    }

    public static boolean validate(PropertyChangeEvent evt)
    throws PropertyVetoException {

    	String path = evt.getPropertyName();
    	
        File file = new File(path);
        if(!file.exists() || file.isDirectory()) {
            String msg = evt.getPropertyName().toUpperCase() + " should target existing file.";
            throw new PropertyVetoException(msg, evt);
        }

        return true;
    }
}