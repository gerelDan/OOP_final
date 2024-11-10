package model.comparators;

import model.Note;

import java.util.Comparator;

public class ComparatorNotes <E extends Note> implements Comparator<E> {
    @Override
    public int compare(Note o1, Note o2) {
        int comparator = o1.getDate().compareTo(o2.getAddedDate());
        if (comparator == 0) {
            return o1.getTime().compareTo(o2.getTime());
        }else return comparator;
    }
}
