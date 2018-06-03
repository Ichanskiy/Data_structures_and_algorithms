package annotation.service;

import annotation.Init;
import annotation.Service;

@Service(name = "LazyServiceNAME", mood = Service.Mood.GOOD)
public class LazyService {

    @Init
    void initLazy() throws Exception {
        System.out.println(LazyService.class + " initLazy()");
    }
}
