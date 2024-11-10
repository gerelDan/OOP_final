package view.commands;

import view.ConsoleUI;

public class AddNote extends Command{
    public AddNote(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Добавить запись";
    }
    @Override
    public void execute() {
        consoleUI.addNote();
    }
}
