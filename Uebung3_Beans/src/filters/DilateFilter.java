package filters;

import java.awt.image.renderable.ParameterBlock;
import java.security.InvalidParameterException;

import javax.media.jai.JAI;
import javax.media.jai.KernelJAI;
import javax.media.jai.PlanarImage;

import interfaces.Readable;
import interfaces.Writeable;
import util.ImageEvent;
import util.Kernel;

public class DilateFilter extends EnhancedDataTransformationFilter<ImageEvent>{

    private final KernelJAI _kernel;

    public DilateFilter(Readable<ImageEvent> input, Kernel kernel)
    throws InvalidParameterException {
        super(input);
        _kernel = kernel.getJAIKernel();
    }

    public DilateFilter(Readable<ImageEvent> input, Writeable<ImageEvent> output, Kernel kernel)
    throws InvalidParameterException {
        super(input, output);
        _kernel = kernel.getJAIKernel();
    }

    public DilateFilter(Writeable<ImageEvent> output, Kernel kernel)
    throws InvalidParameterException {
        super(output);
        _kernel = kernel.getJAIKernel();
    }

    @Override
    protected ImageEvent process(ImageEvent imageEvent) {
        //Dilating source image.
        PlanarImage dilatedImage = performTransformationStep("dilate", imageEvent.getImage());

        //Returning new event.
        return new ImageEvent(this, dilatedImage, imageEvent.getShiftX(), imageEvent.getShiftY());
    }

    /**
     * Applies given JAIOperator to given image.
     *
     * @param operator JAIOperator to be applied to image.
     * @param image Image that will be transformed by given JAIOperator.
     * @return Transformed Planar image
     */
    private PlanarImage performTransformationStep(String operator, PlanarImage image) {
        //Transforming image according to the given JAI operator.
        return JAI.create(operator, new ParameterBlock().add(_kernel).addSource(image));
    }
}
