package sonlmz.service.impl;

import org.springframework.stereotype.Service;
import sonlmz.service.Service02;

@Service
public class Service02Impl implements Service02 {

    @Override
    public void Two() {
        System.out.println("two");
    }

    @Override
    public String getValue() {
        return "02";
    }
}
