package thresholdBean;

import interfaces.ImageListener;
import util.AbstractBeanInfo;
import util.ImageEvent;

public class ThresholdBeanInfo extends AbstractBeanInfo<ThresholdBean, ImageEvent, ImageListener> {

    public ThresholdBeanInfo() {
        super(ThresholdBean.class, ImageEvent.class, ImageListener.class);
    }
}