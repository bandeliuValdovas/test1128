package org.example;

import lt.techin.library.Book;
import lt.techin.library.BookCatalog;
import lt.techin.library.BookNotFoundException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        if (book.getIsbn()==null||book.getIsbn().isEmpty()||book.getTitle()==null||book.getTitle().isEmpty()){
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
    public boolean isBookAvailable(String isbn) {
        return getBookByIsbn(isbn).isAvailable();
    }

    @Override
    public Book findNewestBookByPublisher(String publisher) {
        if (groupBooksByPublisher().get(publisher)==null){
            throw new BookNotFoundException("no book for this publisher");
        }
    return groupBooksByPublisher().get(publisher).stream().max(Comparator.comparing(Book::getPublicationYear)).get();
    }

    @Override
    public List<Book> getSortedBooks() {
        return books.stream()
                .sorted(Comparator.comparing(Book::getPublicationYear)
                        .thenComparing(Book::getTitle)
                        .thenComparing(Book::getPageCount))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Book>> groupBooksByPublisher() {
        Map <String,List<Book>> groupByPublisher = new HashMap<>();
        for (Book book : books) {
            String publisher = book.getPublisher();
            groupByPublisher.putIfAbsent(publisher, new ArrayList<>());
            groupByPublisher.get(publisher).add(book);
        }
        return groupByPublisher;
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
