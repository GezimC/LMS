package org.example.service;

import org.example.dao.AuthorDao;
import org.example.model.Author;

public class AuthorService {

    private AuthorDao authorDao = new AuthorDao();
    private Author author = new Author();

    public boolean createAuthor(String name, String lastname)
    {

        if(name.isEmpty() | name == null | lastname.isEmpty() | lastname ==null)
        {
            System.out.println("Name or Lastname should not be empty");
            return false;
        }

        author.setName(name);
        author.setLastname(lastname);

        return authorDao.createAuthor(author);

    }


    public boolean updateAuthor(int id, String name, String lastname)
    {
        if (id<=0)
        {
            System.out.println("Id should be greater than 0");
            return false;
        }

        author.setId(id);
        author.setName(name);
        author.setLastname(lastname);

        return  authorDao.updateAuthor(author);
    }


    public boolean deleteAuthor (int id)
    {
        if (id<=0)
        {
            System.out.println("Id should be greater than 0");
            return false;
        }

        return authorDao.deleteAuthor(id);
    }





}
