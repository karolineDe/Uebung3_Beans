package regionOfInterestBean;

import interfaces.ImageListener;
import util.AbstractBeanInfo;
import util.ImageEvent;

public class RegionOfInterestBeanInfo extends AbstractBeanInfo<RegionOfInterestBean, ImageEvent, ImageListener> {

    public RegionOfInterestBeanInfo() {
        super(RegionOfInterestBean.class, ImageEvent.class, ImageListener.class);
    }
}
