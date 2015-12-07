package dilateImage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

import filters.DilateFilter;
import interfaces.ImageListener;
import pipes.SupplierPipe;
import util.ImageEvent;
import util.ImageEventHandler;
import util.Kernel;
import util.TargetDescriptor;

public class DilateImage extends ImageEventHandler implements ImageListener, Serializable {

	 @TargetDescriptor
	    private Kernel _kernel = new Kernel();

	    private ImageEvent _imageEvent;

	    public DilateImage() {
	    }

	    public Kernel getKernel() {
	        return _kernel;
	    }

	    public void setKernel(Kernel kernel) {
	        _kernel = kernel;
	        reload();
	    }

	    @Override
	    @TargetDescriptor
	    public void onImage(ImageEvent imageEvent) {
	        try {
	            _imageEvent = imageEvent;

	            DilateFilter dilateFilter = new DilateFilter(
	                new SupplierPipe<>(imageEvent),
	                _kernel
	            );

	            ImageEvent result = dilateFilter.read();

	            notifyAllListeners(result);
	        } catch (StreamCorruptedException e) {
	            e.printStackTrace();
	            notifyAllListeners(null);
	        }
	    }

	    @Override
	    protected void reload() {
	        if (_imageEvent != null) onImage(_imageEvent);
	    }

	    @Override
	    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
	        //TODO
	    }
	}
