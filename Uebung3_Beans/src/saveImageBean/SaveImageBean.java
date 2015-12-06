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

	@TargetDescriptor
    private String _savePath = "out.png";
	
	private ImageEvent _imageEvent;
	private String _imagePath = " ";
	private String _fileEnding = "png";

	public SaveImageBean(){
		super();
	}
	

	public String getSavePath() {
		return _savePath;
	}

	public void setSavePath(String path) throws PropertyVetoException{
		String oldSavePath = _savePath;
		 fireVetoableChange(this, _imagePath, oldSavePath, path);

		 _savePath = path;
        firePropertyChange(this, _imagePath, oldSavePath, path);
	}

	@Override
    @TargetDescriptor
    public void onImage(ImageEvent event) {
		_imageEvent = event;

        if (event != null) {
            try {
                BufferedImage image = event.getImage().getAsBufferedImage();
                ImageIO.write(image, _fileEnding, new File(_savePath));
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

                case "png": {
                    FilePathVetoable.validate(evt);
                    break;
                }
            }
        }
    }

	
}
