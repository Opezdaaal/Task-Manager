package Project1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MarkBase {
    public String name;

    public int id;
    String description;
    public static int nextid = 1;
    public Difficulty difficulty;
    public running running;
    public boolean done = false;
    public String createdAt;
    public String updatedAt;

    public MarkBase(String name, String description,Difficulty difficulty, running running){
        this.id = nextid++;
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.done = false;
        this.running = Project1.running.TODO;
        this.createdAt = String.valueOf(LocalDateTime.now().withNano(0).withSecond(0));
        this.updatedAt = "Не обновлялось";
    }

    public String toString(){
        return "Айди: " + id + " Имя: " + name + " Описание: " + description + " Сложность: " + difficulty + " Выполнено: " + done + " Стадия выполнения: " + running +
                " Создано: " + createdAt.replace("T", " ") + " Обновлено: " + updatedAt.replace("T", " ");
    }
    public String updatedTime(){
        return updatedAt;
    }
    public void setTime(){
        this.updatedAt = String.valueOf(LocalDateTime.now().withNano(0).withSecond(0));
    }
}
