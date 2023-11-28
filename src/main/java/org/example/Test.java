package org.example;

import lt.techin.library.BookCatalog;
import lt.techin.library.test.AbstractLibraryTest;

public class Test extends AbstractLibraryTest {
    @Override
    protected BookCatalog createBookCatalog() {
        return new MyBookCatalog();
    }
}
