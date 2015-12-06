package util;

import java.beans.*;
import java.io.File;

public class FilePathVetoable {
	
	private FilePathVetoable() {
    }

    public static boolean validate(PropertyChangeEvent evt)
    throws PropertyVetoException {
        String newPath = StringVetoable.validate(evt);

        File file = new File(newPath);
        if(!file.exists() || file.isDirectory()) {
            String msg = evt.getPropertyName().toUpperCase() + " should target existing file.";
            throw new PropertyVetoException(msg, evt);
        }

        return true;
    }
}