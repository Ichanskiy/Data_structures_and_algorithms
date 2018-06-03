package annotation;

import annotation.service.LazyService;
import annotation.service.SimpleService;

import java.lang.annotation.Annotation;

public class AnnotationProcessor {
    public static void main(String[] args) {
        inspectService(SimpleService.class);
        inspectService(LazyService.class);
    }

    private static void inspectService(Class<?> service){
        if (service.isAnnotationPresent(Service.class)) {
            Service ann = service.getAnnotation(Service.class);
            System.out.println("ann.mood() = " + ann.mood());
        }
    }
}
