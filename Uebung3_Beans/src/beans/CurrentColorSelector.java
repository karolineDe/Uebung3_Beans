package beans;

import java.beans.PropertyEditorSupport;

public class CurrentColorSelector extends PropertyEditorSupport {

	public String[] getTags() {
	    String colors[] = { "red", "yellow", 
	      "green", "blue" };
	    return colors;
	  }

}
