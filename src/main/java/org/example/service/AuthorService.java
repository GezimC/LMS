package org.example.service;

import org.example.dao.AuthorDao;
import org.example.model.Author;

public class AuthorService {

    private AuthorDao authorDao = new AuthorDao();

    public boolean createAuthor(String name, String lastname)
    {

        if(name.isEmpty())
        {
            System.out.println("Name should not be empty");
            return false;
        }

        Author author = new Author(name, lastname);

        authorDao.createAuthor(author);


        return true;
    }
}
