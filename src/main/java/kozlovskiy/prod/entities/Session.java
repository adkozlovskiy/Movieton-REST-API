package kozlovskiy.prod.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue
    private int id;
    private Date sessionDate;
    private int hallNumber;
    private int vacantSeats;
    private int price;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    public Session(int id, Date sessionDate, int hallNumber, int vacantSeats, int price, Movie movie) {
        this.id = id;
        this.sessionDate = sessionDate;
        this.hallNumber = hallNumber;
        this.vacantSeats = vacantSeats;
        this.price = price;
        this.movie = movie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public int getVacantSeats() {
        return vacantSeats;
    }

    public void setVacantSeats(int vacantSeats) {
        this.vacantSeats = vacantSeats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
