package saveImageBean;

import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import interfaces.ImageListener;
import util.FilePathVetoable;
import util.ImageEvent;
import util.ImageEventHandler;
import util.TargetDescriptor;

public class SaveImageBean extends ImageEventHandler implements ImageListener{
	
	private static final String IMAGE_PATH = "imagePath";
	private ImageEvent _imageEvent;
	private String _fileEnding = "png";
	
	@TargetDescriptor
    private String _imagePath = "out." + _fileEnding;

	public SaveImageBean(){
		super();
	}
	
	public String getImagePath() {
		return _imagePath;
	}

	public void setImagePath(String path) throws PropertyVetoException{
		String oldSavePath = _imagePath;
		fireVetoableChange(this, IMAGE_PATH, oldSavePath, path);

		 _imagePath = path;
        firePropertyChange(this, IMAGE_PATH, oldSavePath, path);
	}

	@Override
    @TargetDescriptor
    public void onImage(ImageEvent event) {
		_imageEvent = event;

        if (event != null) {
            try {
                BufferedImage image = event.getImage().getAsBufferedImage();
                ImageIO.write(image, _fileEnding, new File(_imagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void reload() {
        onImage(_imageEvent);
    }
	
    @Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
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
