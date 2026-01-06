package org.example.service;

import org.example.dao.BookDao;
import org.example.model.Book;

public class BookService {

    private BookDao bookDao = new BookDao();
    private Book book = new Book();

    public boolean createBook(String title, int authorId, int categoryId, String isbn, int langId, String publishingHouse, int publishedYear, int quantity)
    {
        if(isbn.isEmpty() | title.isEmpty())
        {
            System.out.println("ISBN or Title should not be empty");
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

}
