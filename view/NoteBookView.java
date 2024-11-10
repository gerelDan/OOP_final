package view;

import model.Note;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface NoteBookView {
    void showNotes(List<Note> notes);
    void showMessage(String message);
    LocalDate getDateInput();
    LocalTime getTimeInput();
    String getThemeInput();
    String getFileNameInput();
}
