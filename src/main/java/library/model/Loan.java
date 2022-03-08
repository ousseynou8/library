package library.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Loan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "dateBegin",nullable = false)
    private Date dat;

    @Column(nullable = false)
    private Date duration;

    //JOINTURE
    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;
    public Loan() {
    }
    public Loan(Date dat, Date duration, User user, Book book) {
        this.dat = dat;
        this.duration = duration;
        this.user = user;
        this.book = book;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDat() {
        return dat;
    }

    public void setDat(Date dat) {
        this.dat = dat;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
