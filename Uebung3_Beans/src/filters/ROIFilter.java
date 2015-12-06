package filters;

import java.awt.Rectangle;
import java.security.InvalidParameterException;

import javax.media.jai.PlanarImage;

import interfaces.Readable;
import interfaces.Writeable;
import util.ImageEvent;

public class ROIFilter extends EnhancedDataTransformationFilter<ImageEvent> {

    private final Rectangle _roi;

    public ROIFilter(Readable<ImageEvent> input, Writeable<ImageEvent> output, Rectangle roi)
    throws InvalidParameterException {
        super(input, output);
        _roi = roi;
    }

    public ROIFilter(Readable<ImageEvent> input, Rectangle roi)
    throws InvalidParameterException {
        super(input);
        _roi = roi;
    }

    public ROIFilter(Writeable<ImageEvent> output, Rectangle roi)
    throws InvalidParameterException {
        super(output);
        _roi = roi;
    }

    @Override
    protected ImageEvent process(ImageEvent imageEvent) {
        PlanarImage image = imageEvent.getImage();

        //Recreating a new Planar Image cropped by given _roi Rectangle.
        PlanarImage roiImage = PlanarImage.wrapRenderedImage(
            image.getAsBufferedImage(
                _roi,
                image.getColorModel()
            )
        );

        //Setting shift value to event.
        return new ImageEvent(this, roiImage, (int) _roi.getX(), (int) _roi.getY());
    }
}
