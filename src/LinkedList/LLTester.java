package LinkedList;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class LLTester {
    @Rule // a test will fail if it takes longer than 1/10 of a second to run
 	public Timeout timeout = Timeout.millis(100); 

    @Test
    public void testBaseCase(){
        LinkedList<String> LL = new LinkedList<>();
        assertEquals("An empty BST", "()", LL.toString());
    }

    @Test
    public void testAddHead(){
        LinkedList<String> LL = new LinkedList<>();
        LL.insertAtHead("Head");
        assertEquals("An empty BST", "(Head)", LL.toString());
    }

    @Test
    public void testAddHead_2(){
        LinkedList<String> LL = new LinkedList<>();
        LL.insertAtHead("first");
        LL.insertAtHead("second");
        assertEquals("An empty BST", "(second, first)", LL.toString());
    }

    @Test
    public void testAddTail(){
        LinkedList<String> LL = new LinkedList<>();
        LL.insertAtHead("tail");
        assertEquals("An empty BST", "(tail)", LL.toString());
    }
    @Test
    public void testAddTail_2(){
        LinkedList<String> LL = new LinkedList<>();
        LL.insertAtTail("first");
        LL.insertAtTail("second");
        assertEquals("An empty BST", "(first, second)", LL.toString());
    }

    @Test
    public void testAddAt(){
        LinkedList<String> LL = new LinkedList<>();
        LL.insertAtIndex(0, "index");
        assertEquals("An empty BST", "(index)", LL.toString());
    }
    @Test
    public void testAddAt_2(){
        LinkedList<String> LL = new LinkedList<>();
        LL.insertAtTail("first");
        LL.insertAtTail("second");
        assertEquals("An empty BST", "(first, second)", LL.toString());
    }
}
