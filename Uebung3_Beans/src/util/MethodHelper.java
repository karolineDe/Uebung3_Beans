package util;

import java.beans.MethodDescriptor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodHelper {

    private MethodHelper() {
    }

    public static <T> MethodDescriptor[] getMethodDescriptors(Class<T> beanClass) {

        List<Method> allMethods = Arrays.asList(beanClass.getDeclaredMethods());
        List<Method> targetMethods = allMethods.stream()
            .filter(method -> method.isAnnotationPresent(TargetDescriptor.class))
            .collect(Collectors.toList());

        return targetMethods.stream()
            .map(MethodDescriptor::new)
            .toArray(MethodDescriptor[]::new);
    }
}