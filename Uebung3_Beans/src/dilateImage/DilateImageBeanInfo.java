package dilateImage;

import dilateImage.DilateImage;
import interfaces.ImageListener;
import util.AbstractBeanInfo;
import util.ImageEvent;

public class DilateImageBeanInfo extends AbstractBeanInfo<DilateImage, ImageEvent, ImageListener> {

	public DilateImageBeanInfo() {
		super(DilateImage.class, ImageEvent.class, ImageListener.class);
	}

}
