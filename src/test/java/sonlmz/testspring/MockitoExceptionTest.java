package sonlmz.testspring;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class MockitoExceptionTest {
    @Mock
    List<String> mockedList;


    @Before
    public void init() {
        // Uncomment this and the NullPointerException won't be thrown
        //MockitoAnnotations.initMocks(this);
    }

    @Test(expected = NullPointerException.class)
    public void whenMockitoAnnotationsUninitialized_thenNPEThrown() {
        Mockito.when(mockedList.size()).thenReturn(1);
    }
}
