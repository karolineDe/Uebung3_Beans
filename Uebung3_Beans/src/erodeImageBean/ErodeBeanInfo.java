package erodeImageBean;

import interfaces.ImageListener;
import util.AbstractBeanInfo;
import util.ImageEvent;

public class ErodeBeanInfo extends AbstractBeanInfo<ErodeImageBean, ImageEvent, ImageListener> {

    public ErodeBeanInfo() {
        super(ErodeImageBean.class, ImageEvent.class, ImageListener.class);
    }
}
