package presenter;

import model.*;
import model.comparators.ComparatorByTime;
import model.comparators.ComparatorNotes;
import view.NoteBookView;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Presenter {
    private NoteBookService service;
    private NoteBookView view;

    public Presenter(NoteBookService service, NoteBookView view) {
        this.service = service;
        this.view = view;
    }

    public void addNote(){
        LocalDate date = view.getDateInput();
        LocalTime time = view.getTimeInput();
        String theme = view.getThemeInput();
        service.addNote(new Note(theme, time, date));
        view.showMessage("Note added");
    }
    public void showNotesForDay(){
        LocalDate date = view.getDateInput();
        List<Note> notes = service.getFromDay(date).
                stream().
                sorted(new ComparatorByTime<>()).
                toList();
        view.showNotes(notes);
    }

    public void showNotesForWeek() {
        LocalDate startOfWeek = view.getDateInput();
        List<Note> notes = service.getNotesForWeek(startOfWeek).
                stream().
                sorted(new ComparatorNotes<>()).
                toList();
        view.showNotes(notes);
    }
    public void saveNotes() {
        String fileName = view.getFileNameInput();
        try {
            service.saveToFile(fileName);
            view.showMessage("Notes saved to " + fileName);
        } catch (IOException e) {
            view.showMessage("Failed to save notes: " +
                    e.getMessage());
        }
    }
    public void loadNotes() {
        String fileName = view.getFileNameInput();
        try {
            service.loadFromFile(fileName);
            view.showMessage("Notes loaded from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            view.showMessage("Failed to load notes: " +
                    e.getMessage());
        }
    }
    public List<Note> getAll(){
        return this.service.getAll();
    }
}


