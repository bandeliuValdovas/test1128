package org.example;

import lt.techin.library.Book;
import lt.techin.library.BookCatalog;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class MyBookCatalog implements BookCatalog {
    private List<Book> books;

    public MyBookCatalog() {
        books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        if (book==null){
            throw new IllegalArgumentException();
        }
        if (!isBookInCatalog(book.getIsbn())){
            books.add(book);
        }
    }

    @Override
    public Book getBookByIsbn(String isbnNumber) {
        for (int i =0;i<books.size();i++){
            if (books.get(i).getIsbn().equals(isbnNumber)){
                return books.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Book> searchBooksByAuthor(String author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (int i =0;i<books.size();i++){
            if (books.get(i).getAuthors().contains(author));
        }
        return null;
    }

    @Override
    public int getTotalNumberOfBooks() {
        return books.size();
    }

    @Override
    public boolean isBookInCatalog(String isbn) {
        return !(getBookByIsbn(isbn)==null);
    }

    @Override
    public boolean isBookAvailable(String s) {
        return false;
    }

    @Override
    public Book findNewestBookByPublisher(String s) {
        return null;
    }

    @Override
    public List<Book> getSortedBooks() {
        return null;
    }

    @Override
    public Map<String, List<Book>> groupBooksByPublisher() {
        return null;
    }

    @Override
    public List<Book> filterBooks(Predicate<Book> predicate) {
        return null;
    }

    @Override
    public BigDecimal calculateTotalPrice() {
        BigDecimal sum = new BigDecimal(BigInteger.ZERO);
        for (int i =0;i<books.size();i++){
            sum = sum.add(books.get(i).getPrice());
        }
        return sum;
    }
}
