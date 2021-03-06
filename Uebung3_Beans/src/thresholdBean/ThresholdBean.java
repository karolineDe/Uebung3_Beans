package thresholdBean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.io.StreamCorruptedException;

import filters.ThresholdFilter;
import interfaces.ImageListener;
import pipes.SupplierPipe;
import util.ImageEvent;
import util.ImageEventHandler;
import util.IntegerVetoable;
import util.TargetDescriptor;

public class ThresholdBean extends ImageEventHandler implements ImageListener {
    private static final String COLOR_FROM = "colorFrom";
    public static final String COLOR_TO = "colorTo";
    public static final String TARGET_COLOR = "targetColor";
    private static final int MIN_COLOR = 0;
    private static final int MAX_COLOR = 255;

    @TargetDescriptor
    private int _colorFrom = MIN_COLOR;
    @TargetDescriptor
    private int _colorTo = MAX_COLOR;
    @TargetDescriptor
    private int _targetColor = MIN_COLOR;

    private ImageEvent _lastImageEvent;

    public ThresholdBean() {
        super();
    }

    public int getColorFrom() {
        return _colorFrom;
    }

    public void setColorFrom(int colorFrom)
    throws PropertyVetoException {
        int temp = _colorFrom;
        fireVetoableChange(this, COLOR_FROM, temp, colorFrom);

        _colorFrom = colorFrom;
        firePropertyChange(this, COLOR_FROM, temp, colorFrom);
    }

    public int getColorTo() {
        return _colorTo;
    }

    public void setColorTo(int colorTo)
    throws PropertyVetoException {
        int temp = _colorTo;
        fireVetoableChange(this, COLOR_TO, temp, colorTo);

        _colorTo = colorTo;
        firePropertyChange(this, COLOR_TO, temp, colorTo);
    }

    public int getTargetColor() {
        return _targetColor;
    }

    public void setTargetColor(int targetColor)
    throws PropertyVetoException {
        int temp = _targetColor;
        fireVetoableChange(this, TARGET_COLOR, temp, targetColor);

        _targetColor = targetColor;
        firePropertyChange(this, TARGET_COLOR, temp, targetColor);
    }

    @Override
    @TargetDescriptor
    public void onImage(ImageEvent imageEvent) {
        try {
            _lastImageEvent = imageEvent;

            ThresholdFilter thresholdFilter = new ThresholdFilter(
                new SupplierPipe<>(imageEvent),
                new double[]{_colorFrom},
                new double[]{_colorTo},
                new double[]{_targetColor}
            );

            ImageEvent result = thresholdFilter.read();

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
        String propertyName = evt.getPropertyName();

        if (propertyName != null) {

            switch (propertyName) {

                case COLOR_FROM: {
                    IntegerVetoable.validate(evt, MIN_COLOR, MAX_COLOR);
                    break;
                }

                case COLOR_TO: {
                    IntegerVetoable.validate(evt, MIN_COLOR, MAX_COLOR);
                    break;
                }

                case TARGET_COLOR: {
                    IntegerVetoable.validate(evt, MIN_COLOR, MAX_COLOR);
                    break;
                }
            }
        }
    }
}