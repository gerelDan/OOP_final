package model;

import model.comparators.ComparatorByDate;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NoteBookService {
    private Long idCreator = 1L;
    private NoteBook noteBook;

    public NoteBookService() {
        this.noteBook = new NoteBook();
    }
    public void addNote(String theme, String strTime, String strDate){
        this.noteBook.getNotebook().add(
                new Note(
                            theme,
                            LocalTime.parse(strTime),
                            LocalDate.parse(strDate)));
        this.noteBook.getNotebook().getLast().setId(idCreator++);
    }

    public void addNote(Note note){
        note.setId(idCreator++);
        this.noteBook.getNotebook().add(note);
    }
    public List<Note> getAll(){
        return this.noteBook.getNotebook();
    }

    public void saveToFile(String path) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new
                FileOutputStream(path))) {

            objectOutputStream.writeObject(this.noteBook);
        }
    }

    public void loadFromFile(String path) throws IOException, ClassNotFoundException{
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            this.noteBook =  (NoteBook) objectInputStream.readObject();
        }
    }
    public List<Note> getFromDay(LocalDate date){
        List<Note> listNote = new ArrayList<>();
        for (Note note : this.getAll()){
            if (note.getDate().equals(date)){
                listNote.add(note);
            }
        }
        return listNote;
    }
    public void sortByDate(){
            noteBook.getNotebook().sort(new ComparatorByDate<>());
//        return noteBook;
    }
//    public List<Note>
public List<Note> getNotesForWeek(LocalDate startOfWeek) {
    LocalDate endOfWeek = startOfWeek.plusWeeks(1);
    return noteBook.getNotebook().stream()
            .filter(note ->
                    !note.getDate().isBefore(startOfWeek) &&
                            !note.getDate().isAfter(endOfWeek))
            .sorted(Comparator.comparing(Note::getDate))
            .collect(Collectors.toList());
}

}
