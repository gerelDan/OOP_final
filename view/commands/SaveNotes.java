package view.commands;

import view.ConsoleUI;

public class SaveNotes extends Command{
    public SaveNotes(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Сохранить записную книжку";
    }

    @Override
    public void execute() {
        consoleUI.saveNotes();
    }
}
