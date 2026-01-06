package org.example.model;

public class Book {
    private int id;
    private String title;
    private String isbn;
    private int authorId;
    private int langId;
    private int publishedYear;
    private String publishingHouse;
    private int categoryId;
    private int quantity;
    private boolean isDeleted;


    public Book() {
    }

    public Book(int id, String title, String isbn, int authorId, String publishingHouse, int categoryId, int quantity, boolean isDeleted, int langId, int publishedYear) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.authorId = authorId;
        this.publishingHouse = publishingHouse;
        this.categoryId = categoryId;
        this.quantity = quantity;
        this.isDeleted = isDeleted;
        this.langId = langId;
        this.publishedYear = publishedYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + ", authorId=" + authorId + ", publisherId=" + publishingHouse + ", categoryId=" + categoryId + ", stock=" + quantity + "]";
    }
}
