package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NoteBook implements Serializable {
    private List<Note> notebook;

    public NoteBook(){
        this.notebook = new ArrayList<>();
    }

    public List<Note> getNotebook() {
        return notebook;
    }
}
