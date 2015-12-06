package util;

public enum JAIMethods {
	
	 	THRESHOLD("threshold"),
	    THRESHOLD_X("ThresholdX"),
	    THRESHOLD_Y("ThresholdY"),
	    MEDIAN("MedianFilter"),
	    ERODE("erode"),
	    DILATE("dilate"),
	    INVERT("invert"),
	    FILE_LOAD("fileload"),
	    FILE_STORE("filestore");

	    private final String _operatorValue;

	    JAIMethods(String operatorValue) {
	        _operatorValue = operatorValue;
	    }

	    /**
	     * Returns the JAI string
	     */
	    public String getOperatorValue() {
	        return _operatorValue;
	    }
	}
