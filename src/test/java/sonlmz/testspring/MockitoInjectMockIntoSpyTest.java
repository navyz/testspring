package sonlmz.testspring;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import sonlmz.service.impl.MyDictionaryServiceImpl;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MockitoInjectMockIntoSpyTest {

    @Mock
    Map<String, String> wordMap;

    MyDictionaryServiceImpl spyDic;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        spyDic = Mockito.spy(new MyDictionaryServiceImpl(wordMap));
    }

    @Test
    public void injectMocksIntoSpyTest() {
        Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");
        assertEquals("aMeaning", spyDic.getMeaning("aWord"));
    }
}
