package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Note implements Serializable {
    private Long id;
    private String theme;
    private LocalTime time;
    private LocalDate date;
    private final LocalDate addedDate;

    public Note(String theme, LocalTime time, LocalDate date) {
//        this.id = id;
        this.theme = theme;
        this.time = time;
        this.date = date;
        this.addedDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public String getTheme() {
        return theme;
    }

    public LocalTime getTime() {
        return time;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDate getAddedDate() {
        return addedDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{id=" + id +
                ", theme='" + theme + '\'' +
                ", time=" + time +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(id, note.id) &&
                Objects.equals(theme, note.theme) &&
                Objects.equals(time, note.time) &&
                Objects.equals(date, note.date) &&
                Objects.equals(addedDate, note.addedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, theme, time, date, addedDate);
    }
}
