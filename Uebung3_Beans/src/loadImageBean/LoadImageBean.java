package loadImageBean;

import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.media.jai.PlanarImage;

import util.FilePathVetoable;
import util.ImageEvent;
import util.ImageEventHandler;
import util.TargetDescriptor;


public class LoadImageBean extends ImageEventHandler{
	
	private static final String IMAGE_PATH = "imagePath";

    @TargetDescriptor
    private String _imagePath = "";

    public LoadImageBean() {
        super();
    }

    public String getImagePath() {
        return _imagePath;
    }

    public void setImagePath(String imagePath)
    throws PropertyVetoException {
        String temp = _imagePath;
        fireVetoableChange(this, IMAGE_PATH, temp, imagePath);

        _imagePath = imagePath;
        firePropertyChange(this, IMAGE_PATH, temp, imagePath);
    }

    @Override
    protected void reload() {
        try {

            PlanarImage image = PlanarImage.wrapRenderedImage(
                ImageIO.read(new File(getImagePath()))
            );

            ImageEvent imageEvent = new ImageEvent(this, image, 0, 0);
            notifyAllListeners(imageEvent);

        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void vetoableChange(PropertyChangeEvent evt)
    throws PropertyVetoException {
        String propertyName = evt.getPropertyName();

        if (propertyName != null) {

            switch (propertyName) {

                case IMAGE_PATH: {
                    FilePathVetoable.validate(evt);
                    break;
                }
            }
        }
    }
}