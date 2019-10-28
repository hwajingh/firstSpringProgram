package Bookstore.Repository.impl;

import Bookstore.Model.Book;
import Bookstore.jpa.BookCrudRepository;
import Bookstore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;


@Repository
public class BookRepositoryimpl implements BookRepository {

    // Instance data
   // private List<Book> books = new ArrayList<>();

    @Autowired
    private BookCrudRepository bookCrudRepository;



    @Override
    public List<Book> findAllBooks()
    {
      //  return books;
        return (List<Book>) bookCrudRepository.findAll();
    }

    @Override
    public Book findBookById(Long bookId) {

      //  return  books.stream()
       //         .filter(book -> book.getBookId().equals(bookId))
         //       .collect(MoreCollectors.onlyElement());
        return bookCrudRepository.findOne(bookId);

//        for (Game game : games) {
//            if (game.getGameId() != null && game.getGameId().equals(gameId)) {
//                return game;
//            }
//        }
//        return null;
    }

    @Override
    public  Book addBook(String bookName, String author, Double price, Long iSBN, Book.Genre genre, Date publishDate) {
        Book toAdd = new Book(bookName, author, price, iSBN,genre, publishDate);
      //  books.add(toAdd);
       // return toAdd;
        return bookCrudRepository.save(toAdd);
    }

    @Override
    public List<Book> findAllBooksFiltered(String filterName) {
      //  return books.stream()
       //         .filter(game ->
        //Book.getBookName().toLowerCase().contains(filterName.toLowerCase()))
         //       .collect(Collectors.toList());
        return bookCrudRepository.findByBookName(filterName);
    }

    @Override
    public void deleteBook(Long bookId) {

     //   Book candidate = null;
      //  for (Book book : books) {
       //     if (book.getBookId().equals(bookId)) {
                // remove it from list
       //         candidate = book;
      //      }
      //  }

      //  if (candidate != null) {
      //      books.remove(candidate);
       // }
        bookCrudRepository.delete(bookId);
    }

    @Override
    public  Book editbook (Long bookId, String bookName, String author, double price, Long iSBN, Book.Genre genre, Date publishDate){
     //   Book candidate = null;
     //   for (Book book : books) {
     //       if (book.getBookId().equals(bookId)) {
     //           candidate = book;
     //       }
     //   }

        // edit
     //   if (candidate != null) {
     //       candidate.setBookName(bookName);
      //      candidate.setBookPrice(Double.valueOf(price));
     //       candidate.setAuthor(publisher);
     //       candidate.setISBN(iSBN);
     //       candidate.setGenre(genre);
     //       candidate.setPublishDate(publishDate);

//        }

//        return candidate;

        // find book by id
        Book candidate = bookCrudRepository.findOne(bookId);
        if (candidate == null)
        {
            return null;
        }
        else {
            candidate.setBookName(bookName);
            candidate.setBookPrice(Double.valueOf(price));
            candidate.setAuthor(author);
            candidate.setISBN(iSBN);
            candidate.setGenre(genre);
            candidate.setPublishDate (publishDate);
            return bookCrudRepository.save(candidate);
        }
    }
}



