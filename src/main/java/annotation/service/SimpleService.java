package annotation.service;

import annotation.Init;
import annotation.Service;

@Service(name = "SimpleServiceNAME", mood = Service.Mood.BAD)
public class SimpleService {

    @Init
    void init(){
        System.out.println(SimpleService.class + " init ()");
    }

    void test(){
        System.out.println(" test()");
    }
}
