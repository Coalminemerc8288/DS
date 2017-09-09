package com.pbhatna.memorymanagement.bookcatalog;

/**
 * Created by priyank on 9/9/17.
 */
public interface BookReadOnly {
    int getId();

    String getTitle();

    String getAuthor();

    String toString();

    Price getPrice();
}
