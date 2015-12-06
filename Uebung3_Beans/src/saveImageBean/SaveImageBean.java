package saveImageBean;

import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

import javax.imageio.ImageIO;

import interfaces.ImageListener;
import util.ImageEvent;
import util.ImageEventHandler;

public class SaveImageBean extends ImageEventHandler implements ImageListener, PropertyChangeListener, Serializable {

	private String _savePath = "";
	private BufferedImage _buffImage;
	private PropertyChangeSupport _pcs;

	public SaveImageBean(String path) {
		_savePath = path;
		_pcs = new PropertyChangeSupport(this);
		_pcs.addPropertyChangeListener(this);
	}

	public SaveImageBean(String path, BufferedImage image) {
		_savePath = path;
		_buffImage = image;
		_pcs = new PropertyChangeSupport(this);
		_pcs.addPropertyChangeListener(this);
	}

	public SaveImageBean(BufferedImage image) {
		_buffImage = image;
		_pcs = new PropertyChangeSupport(this);
		_pcs.addPropertyChangeListener(this);
	}

	public SaveImageBean() {
		_savePath = "rsrc/image";
		_pcs = new PropertyChangeSupport(this);
		_pcs.addPropertyChangeListener(this);
	}

	public String getSavePath() {
		return _savePath;
	}

	public void setSavePath(String path) {
		String oldSavePath = _savePath;
		String newSavePath = path;

		_savePath = path;

		_pcs.firePropertyChange("savePath", oldSavePath, newSavePath);
	}

	public BufferedImage getImage() {
		return _buffImage;
	}

	public void setImage(BufferedImage image) {
		_buffImage = image;
	}

	@Override
	public void onImage(ImageEvent e) {

		try {
			_buffImage = e.getImage();
			File outputFile = new File(_savePath + ".jpg");
			ImageIO.write(_buffImage, "jpg", outputFile);

		} catch (StreamCorruptedException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent ev) {

		String newPath = ev.getNewValue().toString();
		_savePath = newPath;
		File outputFile = new File(_savePath + ".jpg");

		if (_buffImage != null) {
			try {
				ImageIO.write(_buffImage, "jpg", outputFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
