package saveImageBean;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

import javax.imageio.ImageIO;

import interfaces.ImageListener;
import util.ImageEvent;
import util.ImageEventHandler;

public class SaveImageBean extends ImageEventHandler implements ImageListener, Serializable {

	private String _savePath = "";
	private BufferedImage _buffImage;

	public SaveImageBean(String path) {
		_savePath = path;
	}

	public SaveImageBean(String path, BufferedImage image) {
		_savePath = path;
		_buffImage = image;
	}

	public SaveImageBean(BufferedImage image) {
		_buffImage = image;
	}

	public SaveImageBean() {
		_savePath = "rsrc/";
	}

	public String getSavePath() {

		return _savePath;
	}

	public void setSavePath(String path) {
		_savePath = path;
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
}
