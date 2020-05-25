package sonlmz.service.impl;

import org.springframework.stereotype.Service;
import sonlmz.service.Service04;

@Service
public class Service04Impl implements Service04 {

    @Override
    public void Four() {
        System.out.println("four");
    }

    @Override
    public String getValue() {
        return "04";
    }
}
