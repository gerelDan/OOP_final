package view.commands;

import model.Note;
import view.ConsoleUI;

public class ShowNotes extends Command{
    public ShowNotes(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Показать записи";
    }
    @Override
    public void execute() {
        consoleUI.showNotes(consoleUI.getPresenter().getAll());
    }
}
