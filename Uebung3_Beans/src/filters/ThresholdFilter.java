package filters;

import java.awt.image.renderable.ParameterBlock;
import java.security.InvalidParameterException;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;

import interfaces.Readable;
import interfaces.Writeable;
import util.ImageEvent;

public class ThresholdFilter extends EnhancedDataTransformationFilter<ImageEvent> {

    private final double[][] _parameters;

    public ThresholdFilter(Readable<ImageEvent> input, Writeable<ImageEvent> output, double[]... parameters)
    throws InvalidParameterException {
        super(input, output);
        _parameters = parameters;
    }

    public ThresholdFilter(Readable<ImageEvent> input, double[]... parameters)
    throws InvalidParameterException {
        super(input);
        _parameters = parameters;
    }

    public ThresholdFilter(Writeable<ImageEvent> output, double[]... parameters)
    throws InvalidParameterException {
        super(output);
        _parameters = parameters;
    }

    @Override
    protected ImageEvent process(ImageEvent imageEvent) {
        ParameterBlock pb = prepareParameterBlock(imageEvent.getImage(), _parameters);

        //Creating a new Planar Image according to parameter block, applying JAI Operator (filter).
        PlanarImage newImage = JAI.create("threshold", pb);

        //Returning new event.
        return new ImageEvent(this, newImage, imageEvent.getShiftX(), imageEvent.getShiftY());
    }

    /**
     * Prepares parameter block.
     *
     * @param image source image
     * @param parameters array of double parameters. 1 element - color from, 2 element - color to,
     *                   3 element - color value that will replace all colors in range between 1 and 2 element
     * @return New instance of prepared parameter block
     */
    private ParameterBlock prepareParameterBlock(PlanarImage image, double[]... parameters) {
        ParameterBlock pb = new ParameterBlock();

        for (double[] parameterGroup : parameters) {
            pb.add(parameterGroup);
        }
        return pb.addSource(image);
    }
}
