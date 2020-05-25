package sonlmz.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import sonlmz.service.impl.MyDictionaryServiceImpl;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MockitoInjectTest {


    @Mock
    Map<String, String> wordMap;

    @InjectMocks
    MyDictionaryServiceImpl dic = new MyDictionaryServiceImpl();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void injectMocksAnnotationTest() {
        Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");
        assertEquals("aMeaning", dic.getMeaning("aWord"));
    }


}
