package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<Command> commandList;

    public Menu(ConsoleUI consoleUi) {
        commandList = new ArrayList<>();
        commandList.add(new AddNote(consoleUi));
        commandList.add(new ShowNotes(consoleUi));
        commandList.add(new ShowNotesForDay(consoleUi));
        commandList.add(new ShowNotesForWeek(consoleUi));
        commandList.add(new SaveNotes(consoleUi));
        commandList.add(new LoadNotes(consoleUi));
        commandList.add(new Exit(consoleUi));
    }
    public int getSize(){
        return commandList.size();
    }
    String menu(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(commandList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }
    public void execute(int choice){
        commandList.get(choice-1).execute();
    }
}
