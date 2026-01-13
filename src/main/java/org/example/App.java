package org.example;
import org.example.service.BookService;
import org.example.ui.AuthorUI;

public class App 
{
    public static void main( String[] args )
    {
//        AuthorUI authorUI = new AuthorUI();
//        authorUI.start();

        BookService bookService = new BookService();

//        if(bookService.createBook("Test_A", 1, 1,
//                "123123123123", 1, "PublishingH_A",
//                2008,10))
//        {
//            System.out.println("Book created!");
//        }


        if(bookService.updateBook(2,null, 1, 1,
                null, 1, null,
                2025,20))
        {
            System.out.println("Book update!");
        }



    }
}
