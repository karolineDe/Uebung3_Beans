package visualizeImageBean;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.util.LinkedList;
import java.util.List;

import javax.media.jai.PlanarImage;

import interfaces.EventHandler;
import interfaces.ImageListener;
import util.ImageEvent;
import util.IntegerVetoable;
import util.TargetDescriptor;


public class VisualizeImageBean extends Canvas implements ImageListener, VetoableChangeListener, PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	
	@TargetDescriptor private int _width = 100;
	@TargetDescriptor private int _height = 100;
	private transient ImageEvent _imageEvent;
	private final PropertyChangeSupport _pcs = new PropertyChangeSupport(this);
    private final VetoableChangeSupport _vcs = new VetoableChangeSupport(this);
	
	public VisualizeImageBean() {
		setSize(getWidth(), getHeight());
	}
	
	/**
	 * Getter and Setter
	 */
	@Override
    public int getWidth() {
        return _width;
    }
	
	 public void setWidth(int width) throws PropertyVetoException {
		 
        int temp = _width;
        fireVetoableChange(this, "widht", temp, width);

        _width = width;
        firePropertyChange(this, "width", temp, width);
    }
	
	
	@Override
	@TargetDescriptor
	public void onImage(ImageEvent event) {
		
		_imageEvent = event;
		
		if (event != null && event.getImage() != null) {
            repaint();
        }
	}
	
	@Override
	public void paint(Graphics g){
		setSize(getWidth(), getHeight());

        if (_imageEvent != null && _imageEvent.getImage() != null) {
            g.drawImage(_imageEvent.getImage().getAsBufferedImage(), 0, 0, this);
        }
	}
	
	 protected void reload() {
        if (_imageEvent != null) onImage(_imageEvent);
    }

	@Override
    public int getHeight() {
        return _height;
    }
	
	public void setHeight(int height)
    throws PropertyVetoException {
        int temp = _height;
        fireVetoableChange(this, "height", temp, height);

        _height = height;
        firePropertyChange(this, "height", temp, height);
    }
	
	 protected void firePropertyChange(Object source, String propertyName,Object oldValue, Object newValue ) {

        _pcs.firePropertyChange(
            new PropertyChangeEvent(source, propertyName, oldValue, newValue)
        );
    }

	 protected void fireVetoableChange(Object source,String propertyName, Object oldValue, Object newValue) throws PropertyVetoException {

        _vcs.fireVetoableChange(
            new PropertyChangeEvent(source, propertyName, oldValue, newValue)
        );
    }
	 
	@Override
    public void propertyChange(PropertyChangeEvent evt) {
        Object source = evt.getSource();

        if (source instanceof VisualizeImageBean) {
            ((VisualizeImageBean) source).reload();
        }
    }
	
	@Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
        String propertyName = evt.getPropertyName();

        if (propertyName != null) {

            switch (propertyName) {

                case "width": {
                    IntegerVetoable.validate(evt, 0);
                    break;
                }

                case "height": {
                    IntegerVetoable.validate(evt, 0);
                    break;
                }
            }
        }
    }
}
