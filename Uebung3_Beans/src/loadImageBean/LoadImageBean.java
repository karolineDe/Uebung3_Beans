package loadImageBean;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import util.ImageEvent;
import util.ImageEventHandler;


public class LoadImageBean extends ImageEventHandler implements Runnable, Serializable{
	
	private transient String _path;
	
	public LoadImageBean(){
	}
	
	
	/**
	 * Sets the fileName property
	 * @param fileName - the image-filename
	 */
	public void setFileName(String fileName){
		
		_path = fileName;
		new Thread(this).start();
	}
	
	/**
	 * Gets the fileName property
	 * @return the image-file name
	 */
	public String getFileName(){
		
		if(_path == null){
			return "";
		}else{
			return _path;
		}
	}

	@Override
	public void run() {
		
		try{
			BufferedImage bi = loadImage(getFileName());
			ImageEvent imageEvent = new ImageEvent(this, bi);
			notifyAllListeners(imageEvent);
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	private BufferedImage loadImage(String path){
		
		if(path != null && !path.isEmpty()){
			try {
				return ImageIO.read(new File(path));
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
		return null;
	}
}
