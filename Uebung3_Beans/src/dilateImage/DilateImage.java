package dilateImage;

import java.io.Serializable;

import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.Filters.Dilatation;
import util.ImageEventHandler;

public class DilateImage extends ImageEventHandler implements Serializable {

	private FastBitmap _image;
	private Dilatation _dilatation;
	private int _radius;
	
	public DilateImage(){
		_radius = 1;
		
		/* generates new Dilatation with radius 1 */
		_dilatation = new Dilatation(); 
	}
	
	public void setRadius(int radius){
		_radius = radius;
	}
	
	public int getRadius (){
		return _radius;
	}
	
}
