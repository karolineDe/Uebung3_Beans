package beans;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class LoadImageBean extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	
    private static final int DEFAULT_IMAGE_SIZE = 300;
	
	private transient String _path;
	private transient BufferedImage _buffImage;
	
	public LoadImageBean(){

        setSize(DEFAULT_IMAGE_SIZE, DEFAULT_IMAGE_SIZE);
		new Thread(this).start();
	}
	
	private void loadImage(String filePath) {
		
		if(filePath != null && !filePath.isEmpty()){
			
			try{
				_buffImage = ImageIO.read(new File(filePath));
				
			}catch (IOException e){
				e.printStackTrace();
			}
		}
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
	
	public void paint(Graphics g){
		
		g.drawImage(_buffImage, 0, 0, this);
	}

	@Override
	public void run() {
		
		try{
			loadImage(getFileName());
			repaint();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
}
