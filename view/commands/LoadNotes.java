package view.commands;

import view.ConsoleUI;

public class LoadNotes extends Command{
    public LoadNotes(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Загрузить записную книжку";
    }

    @Override
    public void execute() {
        consoleUI.loadNotes();
    }
}

