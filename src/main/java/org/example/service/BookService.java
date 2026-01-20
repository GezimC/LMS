package org.example.service;

import org.example.dao.BookDao;
import org.example.model.Book;

public class BookService {

    // check book to be inside methods
    private BookDao bookDao = new BookDao();
    private Book book = new Book();

    public boolean createBook(String title, int authorId, int categoryId, String isbn, int langId, String publishingHouse, int publishedYear, int quantity)
    {
        if(isbn.isEmpty() | title.isEmpty())
        {
            System.out.println("ISBN or Title should not be empty");
            return false;
        }

        if (bookDao.doesBookExists(isbn))
        {
            System.out.printf("Book with isbn {%s} already exists", isbn);
            return false;
        }

        book.setTitle(title);
        book.setAuthorId(authorId);
        book.setCategoryId(categoryId);
        book.setIsbn(isbn);
        book.setLangId(langId);
        book.setPublishingHouse(publishingHouse);
        book.setPublishedYear(publishedYear);
        book.setQuantity(quantity);

        return bookDao.createBook(book);
    }


    public boolean updateBook(
            int bookId,
            String title,
            Integer authorId,
            Integer categoryId,
            String isbn,
            Integer langId,
            String publishingHouse,
            Integer publishedYear,
            Integer quantity
    ) {
        if (bookId <= 0) {
            System.out.println("Invalid Book ID");
            return false;
        }

        Book book = new Book();
        book.setId(bookId);

        if (title != null) book.setTitle(title);
        if (authorId != null) book.setAuthorId(authorId);
        if (categoryId != null) book.setCategoryId(categoryId);
        if (isbn != null) book.setIsbn(isbn);
        if (langId != null) book.setLangId(langId);
        if (publishingHouse != null) book.setPublishingHouse(publishingHouse);
        if (publishedYear != null) book.setPublishedYear(publishedYear);
        if (quantity != null) book.setQuantity(quantity);

        return bookDao.updateBook(book);
    }

}
