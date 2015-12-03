package visualizeImageBean;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import interfaces.EventHandler;
import interfaces.ImageListener;
import util.ImageEvent;


public class VisualizeImageBean extends Canvas implements ImageListener, EventHandler<ImageListener, ImageEvent>{

	private static final long serialVersionUID = 1L;
	
	private int _width = 200;
	private int _height = 200;
	private BufferedImage _buffImage;
	private static final List<ImageListener> IMAGE_LISTENER_LIST = new LinkedList<>();

	public VisualizeImageBean() {
		setSize(_width, _height);
	}
		
	public VisualizeImageBean(BufferedImage image){
		_buffImage = image;
	}
	
	@Override
	public void onImage(ImageEvent event) {
		
		_buffImage = event.getImage();
		repaint();
	}

	@Override
	public void addImageListener(ImageListener listener) {
		
		IMAGE_LISTENER_LIST.add(listener);
	}

	@Override
	public void removeImageListener(ImageListener listener) {
		
		IMAGE_LISTENER_LIST.remove(listener);
	}

	@Override
	public void notifyAllListeners(ImageEvent event) {
		
		for(ImageListener imageListener : IMAGE_LISTENER_LIST){
			imageListener.onImage(event);
		}
	}
	
	@Override
	public void paint(Graphics g){
		setSize(_width,_height);
		g.drawImage(_buffImage, 0, 0, this);
	}
	
	/**
	 * Getter and Setter
	 */
	public int getImageWidth(){
		return _width;
	}
	public void setImageWidth(int width){
		_width = width;
	}
	
	public int getImageHeight(){
		return _height;
	}
	public void setImageHeight(int height){
		_height = height;
	}
}
