package util;

import java.util.EventObject;

import javax.media.jai.PlanarImage;


public class ImageEvent extends EventObject {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final PlanarImage _planarImage;
    private final int _shiftX;
    private final int _shiftY;

    /**
     * Prototype Event
     *
     * @param source the Event-throwing object
     * @param shiftX used to store shift for x
     * @param shiftY used to store shift for y
     * @throws IllegalArgumentException if source == null
     */
    public ImageEvent(Object source, PlanarImage planarImage, int shiftX, int shiftY) {
        super(source);
        _planarImage = planarImage;
        _shiftX = shiftX;
        _shiftY = shiftY;
    }

    public PlanarImage getImage() {
        return _planarImage;
    }

    public int getShiftX() {
        return _shiftX;
    }

    public int getShiftY() {
        return _shiftY;
    }
}
