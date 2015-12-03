package util;

import java.util.LinkedList;
import java.util.List;

import interfaces.EventHandler;
import interfaces.ImageListener;

public abstract class ImageEventHandler implements EventHandler<ImageListener, ImageEvent>{

	 private static final List<ImageListener> IMAGE_LISTENER_LIST = new LinkedList<>();

	public ImageEventHandler(){}
	
	 @Override
	    public void addImageListener(ImageListener listener) {
		 IMAGE_LISTENER_LIST.add(listener);
	    }

	    @Override
	    public void removeImageListener(ImageListener listener) {
	    	IMAGE_LISTENER_LIST.remove(listener);
	    }

	    @Override
	    public void notifyAllListeners(ImageEvent imageEvent) {
	    	IMAGE_LISTENER_LIST.forEach(listener -> listener.onImage(imageEvent));
	    }
	
}
