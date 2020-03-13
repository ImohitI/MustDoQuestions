package com.basics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Basics102 {
    @Test
    public void arrayCopy(){
        int[] integers = {0,1,2,3,4};

        int[] newIntegersArray = new int[integers.length+1];
        System.arraycopy(integers, 0,newIntegersArray, 0, integers.length);
        integers = newIntegersArray;
        integers[5] = 5;

        assertEquals(5,integers[5]);

    }

    /*
    Builder pattern
    consider a class with multiple fields and some of them are optional, using constructor for creating objects
    becomes confusing
    builder pattern helps by creating a companion class builder which will construct legal objects

     */
    @Test
    public void fictionLibraryBook() {
        final LibraryBook.Builder builder = new LibraryBook.Builder();
        final LibraryBook book = builder
                .withBookName("War and Peace")
                .build();
        assertEquals(BookType.FICTION, book.getBookType());
    }

    /*
    Strategy Pattern enables to easily swap specific implementation details of an algorithm without requiring a
    complete a rewrite. we can also swap implementation at runtime. The strategy pattern is often used in conjunction
    with dependency injection to allow implementations to be swapped out for test-specific code , or to allow
    mocked implementation to be used instead.

     */
}
