package sonlmz.service.impl;

import org.springframework.stereotype.Service;
import sonlmz.service.Service02;
import sonlmz.service.Service03;

@Service
public class Service03Impl implements Service03 {
    @Override
    public void Three() {
        System.out.println("three");
    }

    @Override
    public String getValue() {
        return "03";
    }
}
