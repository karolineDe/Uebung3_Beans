package beans;

import Catalano.Imaging.FastBitmap;
import interfaces.IOable;

import java.awt.event.ActionEvent;
import java.io.StreamCorruptedException;
import java.awt.Canvas;
import java.awt.Dimension;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;


public class LoadImageBean {

	private static final long serialVersionUID = 1L;
	
	private Path path = null;
	private static int XPREFSIZE = 400;
	private static int YPREFSIZE = 400;
	
	public LoadImageBean(){
		
		
	}
	
	/**
	 * Sets the fileName property
	 * @param fileName - the image-filename
	 */
	public void setFileName(String fileName){
		
		path = Paths.get(fileName);
		
		try
		{	
			InputStream in = Files.newInputStream(path);
			setIcon(new ImageIcon(ImageIO.read(in)));
			
		} catch (IOException e) {
			path = null;
			setIcon(null);
		}
	}
	
	/**
	 * Gets the fileName property
	 * @return the image-file name
	 */
	public String getFileName(){
		
		if(path == null){
			return "";
		}else{
			return path.toString();
		}
	}
	
	public Dimension getPreferedSize(){
		
		return new Dimension(XPREFSIZE, YPREFSIZE);
	}
}
