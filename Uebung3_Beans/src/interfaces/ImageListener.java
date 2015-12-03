package interfaces;

import java.util.EventListener;

import util.ImageEvent;

public interface ImageListener extends EventListener{

	void onImage(ImageEvent e);
}
