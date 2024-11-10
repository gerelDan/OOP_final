package view.commands;

import view.ConsoleUI;

public class ShowNotesForWeek extends Command{
    public ShowNotesForWeek(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Показать записи на определенную неделю";
    }
    @Override
    public void execute() {
        consoleUI.showNotesForWeek();
    }
}

