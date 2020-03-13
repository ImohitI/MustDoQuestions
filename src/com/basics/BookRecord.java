package com.basics;

public class BookRecord {

    private String author;
    private String bookTitle;

    public BookRecord(String author, String bookTitle) {
        this.author = author;
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookTitle() {
        return bookTitle;
    }

}
