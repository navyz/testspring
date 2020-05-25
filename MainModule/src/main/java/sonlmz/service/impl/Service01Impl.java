package sonlmz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sonlmz.service.Service01;

import javax.annotation.Resource;

@Service
public class Service01Impl implements Service01 {

    @Autowired Service02Impl service02;

    @Resource
    Service03Impl service03;

    private final Service04Impl service04;

    public Service01Impl(Service04Impl service04) {
        this.service04 = service04;
    }

    @Override
    public void One() {
        System.out.println("one");
        System.out.println(this.getValue());
        System.out.println(service02.getValue());
        System.out.println(service03.getValue());
        System.out.println(service04.getValue());
    }

    @Override
    public String getValue() {
        return "01";
    }
}
