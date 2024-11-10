package view.commands;

import view.ConsoleUI;

public class ShowNotesForDay extends Command{
    public ShowNotesForDay(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Показать записи на определенный день";
}
    @Override
    public void execute() {
    consoleUI.showNotesForDay();
}
}

