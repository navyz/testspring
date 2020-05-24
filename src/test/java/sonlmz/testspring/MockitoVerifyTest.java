package sonlmz.testspring;

import org.assertj.core.util.Lists;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.AbstractList;
import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.*;

public class MockitoVerifyTest {
    public class MyList extends AbstractList<String> {

        @Override
        public String get(final int index) {
            return null;
        }
        @Override
        public int size() {
            return 0;
        }
    }

    // Verify if a method is called one
    @Test
    public void verifySimpleInvocationOnMock() {
        List<String> mockedList = mock(MyList.class);
        mockedList.size();
        verify(mockedList).size();
        verify(mockedList, times(1)).size();
    }

    // Verify if a method is never called
    @Test
    public void verifyNoInteractionWithTheWholeMockOccurred() {
        List<String> mockedList = mock(MyList.class);
        verify(mockedList, times(0)).size();
        verifyNoMoreInteractions(mockedList);
        verify(mockedList, never()).clear();
    }

    // Verify order of the calls
    @Test
    public void verifyOrderOfInteractions() {
        List<String> mockedList = mock(MyList.class);
        mockedList.size();
        mockedList.add("a parameter");
        mockedList.clear();

        InOrder inOrder = Mockito.inOrder(mockedList);
        inOrder.verify(mockedList).size();
        inOrder.verify(mockedList).add("a parameter");
        inOrder.verify(mockedList).clear();
    }

    // Verify a method is called with exact argument
    @Test
    public void verifyInteractionWithExactArgument() {
        List<String> mockedList = mock(MyList.class);
        mockedList.add("test");
        verify(mockedList).add("test");
    }

    // Verify interaction with any argument
    @Test
    public void verifyInteractionWithFlexibleAnyArgument() {
        List<String> mockedList = mock(MyList.class);
        mockedList.add("test");
        verify(mockedList).add(anyString());
    }

    // Verify interaction using argument capture
    @Test
    public void verifyInteractionUsingArgumentCapture() {
        List<String> mockedList = mock(MyList.class);
        mockedList.addAll(Lists.<String> newArrayList("someElement"));
        ArgumentCaptor<List> argumentCaptor = ArgumentCaptor.forClass(List.class);
        verify(mockedList).addAll(argumentCaptor.capture());
        List<String> capturedArgument = argumentCaptor.<List<String>> getValue();
        MatcherAssert.assertThat(capturedArgument, hasItem("someElement"));
    }
}
