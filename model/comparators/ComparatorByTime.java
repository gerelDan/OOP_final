package model.comparators;

import model.Note;

import java.util.Comparator;

public class ComparatorByTime<E extends Note> implements Comparator<E> {
    @Override
    public int compare(Note o1, Note o2) {
        return o1.getTime().compareTo(o2.getTime());
    }
}
