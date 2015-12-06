package saveImageBean;

import interfaces.ImageListener;
import util.AbstractBeanInfo;
import util.ImageEvent;

public class SaveImageBeanBeanInfo extends AbstractBeanInfo<SaveImageBean, ImageEvent, ImageListener> {

    public SaveImageBeanBeanInfo() {
        super(SaveImageBean.class, ImageEvent.class, ImageListener.class);
    }
}

