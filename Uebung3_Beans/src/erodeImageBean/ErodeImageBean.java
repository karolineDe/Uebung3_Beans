package erodeImageBean;

import util.TargetDescriptor;
import filters.ErodeFilter;
import util.ImageEvent;
import util.ImageEventHandler;
import interfaces.ImageListener;
import pipes.SupplierPipe;
import util.Kernel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.io.StreamCorruptedException;

public class ErodeImageBean extends ImageEventHandler implements ImageListener {
    
	@TargetDescriptor
    private Kernel _kernel = new Kernel();

    private ImageEvent _lastImageEvent;

    public ErodeImageBean() {
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
    @TargetDescriptor
    public void onImage(ImageEvent imageEvent) {
        try {
            _lastImageEvent = imageEvent;

            ErodeFilter erodeFilter = new ErodeFilter(
                new SupplierPipe<>(imageEvent),
                _kernel
            );

            ImageEvent result = erodeFilter.read();

            notifyAllListeners(result);
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
            notifyAllListeners(null);
        }
    }

    @Override
    protected void reload() {
        if (_lastImageEvent != null) onImage(_lastImageEvent);
    }

    @Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
        //TODO
    }
}
