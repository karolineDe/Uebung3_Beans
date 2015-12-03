package saveImageBean;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.StreamCorruptedException;

import javax.imageio.ImageIO;

import interfaces.ImageListener;
import util.ImageEvent;
import util.ImageEventHandler;

public class SaveImageBean extends ImageEventHandler implements ImageListener{

	private String _savePath = "";
	private BufferedImage _buffImage;
	
	public SaveImageBean(String savePath){
		this._savePath = savePath;
	}
	
	public SaveImageBean(){
		
	}
	
	public String getSavePath(){
		return _savePath;
	}
	
	public void setSavePath(String savePath){
		this._savePath = savePath;
	}
	
	@Override
	public void onImage(ImageEvent e) {
		
		try{
			_buffImage = e.getImage();
			File outputFile = new File(_savePath + ".png");
			ImageIO.write(_buffImage, "png", outputFile);
		} catch (StreamCorruptedException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
		}
	}
}
