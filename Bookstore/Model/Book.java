package Bookstore.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Book {

    /*
        Instance Data
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_seq")
    @SequenceGenerator(name = "book_id_seq", sequenceName = "book_id_seq", allocationSize = 100)
    private Long bookId;

    private String bookName;
    private String author;
    private Double bookPrice;
    private Long iSBN;
    private Genre genre;
    private Date publishDate;

    public enum Genre {
        business,fantasy,biography,mystery,
        scifi,romance,history,Fiction
    }



    public Book() {

    }

    public Book(String bookName, String author, Double bookPrice, Long iSBN, Genre genre, Date publishDate) {
        this.bookName = bookName;
        this.author = author;
        this.bookPrice = bookPrice;
        this.iSBN = iSBN;
        this.genre = genre;
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                ", bookName='" + bookName + '\'' +
                ", Author='" + author + '\'' +
                ", bookPrice=" + bookPrice +
                ", iSBN=" + iSBN +
                ", genre=" + genre +
                ", publishdate= " + publishDate +
                '}';
    }
    public Long getBookId() {
        return bookId;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookId) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }
    public Long getISBN() {
        return iSBN;
    }

    public void setISBN(Long iSBN) {
        this.iSBN = iSBN;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setPrice(Genre price) {
        this.genre = genre;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
