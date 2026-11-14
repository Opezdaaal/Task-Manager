package Project1;

import javax.naming.Name;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Mark {
    Difficulty difficulty;
    running running;

    ArrayList<MarkBase> Marks = new ArrayList<>();

    void add(MarkBase mark){
        Marks.add(mark);
        saveToFile();
    }

    void viewMark(int id){
        if (id == 1){
            for (int i = 0; i< Marks.size(); i++){
                System.out.println(Marks.get(i));
            }
        } else if (id == 2) {
            for (int i = 0; i< Marks.size(); i++){
                if (Marks.get(i).done == true){
                    System.out.println(Marks.get(i));
                }
            }
        } else if (id == 3){
            for (int i = 0; i< Marks.size(); i++){
                if (Marks.get(i).done == false){
                    System.out.println(Marks.get(i));
                }
            }
        } else {
            System.out.println("Ошибка");
        }
    }

    void delete(int id){
        if(id < 0 || id > Marks.size()){
            System.out.println("Ошибка");
        }else {
            for(int i = 0; i < Marks.size(); i++){
                if(Marks.get(i).id == id){
                    Marks.remove(i);
                    for(int j = i; j < Marks.size(); j++){
                        Marks.get(j).id -= 1;
                        MarkBase.nextid -= 1;
                    }
                    saveToFile();
                    return;
                }
            }
        }
    }

    void searchMarks(String name){
        for(int i = 0; i < Marks.size(); i++){
            if (Marks.get(i).name.toLowerCase().contains(name.toLowerCase())){
                System.out.println(Marks.get(i));
            }
        }
    }
    void donetask(int id){
        Marks.get(id - 1).done = true;
        System.out.println(Marks.get(id - 1).done);
        saveToFile();
    }

    void edittask(int id, String name, String description){
        Marks.get(id - 1).name = name;
        Marks.get(id - 1).description = description;
        Marks.get(id - 1).setTime();
        saveToFile();
    }

    void progresstask(int id, String todo){
        switch (todo){
            case "TODO":
                Marks.get(id - 1).running = Project1.running.TODO;
                saveToFile();
                break;
            case "IN_PROGRESS":
                Marks.get(id - 1).running = Project1.running.IN_PROGRESS;
                saveToFile();
                break;
            case "DONE":
                Marks.get(id - 1).running = Project1.running.DONE;
                saveToFile();
                break;
            default:
                System.out.println("Ошибка с прогрессом");
        }
        //Marks.get(id).running = Project1.running.DONE;
    }
    void saveToFile(){
        String jsonText = "[\n";
        for (int i = 0; i < Marks.size(); i++){
            jsonText += Marks.get(i).toString() + "\n";
        }
        jsonText += "]";

        try {
            Files.writeString(Path.of("tasks.json"), jsonText);
        } catch (Exception e){
            System.out.println("Ошибка сохранения файла");
        }

    }
}
