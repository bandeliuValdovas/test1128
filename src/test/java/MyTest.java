import org.example.MyBookCatalog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTest {
    MyBookCatalog catalog = new MyBookCatalog();


    @Test
    public void testingGetTotalNumberOfBooks (){
        assertEquals(0,catalog.getTotalNumberOfBooks());
    }
}
