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

	private ImageEvent _lastImageEvent;

	public DilateImage() {
		super();
	}

	public Kernel getKernel() {
		return _kernel;
	}

	public void setKernel(Kernel kernel) {
		_kernel = kernel;
		reload();
	}

	@Override
	public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
		// TODO Auto-generated method stub

	}

	@Override
	@TargetDescriptor
	public void onImage(ImageEvent e) {
		try {
			_lastImageEvent = e;

			DilateFilter dilateFilter = new DilateFilter(new SupplierPipe<>(e), _kernel);

			ImageEvent result = dilateFilter.read();

			notifyAllListeners(result);
		} catch (StreamCorruptedException se) {
			se.printStackTrace();
			notifyAllListeners(null);
		}
	}

	@Override
	protected void reload() {
		if (_lastImageEvent != null) onImage(_lastImageEvent);
	}

}
