package util;

import java.awt.image.BufferedImage;
import java.util.EventObject;


public class ImageEvent extends EventObject {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage _buffImage;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ImageEvent(Object source, BufferedImage bufferedImage) {
        super(source);

        this._buffImage = bufferedImage;
    }

    public BufferedImage getImage() {
        return _buffImage;
    }
}
