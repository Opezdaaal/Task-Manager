package Project1;

import java.util.Scanner;

public class MarkdownMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Mark base = new Mark();
        int choose;

        do {
            System.out.println("1 - Создать заметку");
            System.out.println("2 - Удалить заметку");
            System.out.println("3 - Посмотреть заметки");
            System.out.println("4 - Найти заметку");
            System.out.println("5 - Выполнить задачу");
            System.out.println("6 - Изменить заметку");
            System.out.println("7 - Посмотреть все выполненные заметки");
            System.out.println("8 - Посмотреть все невыполненые заметки");
            choose = scan.nextInt();
            scan.nextLine();
            switch (choose){
                case 1:
                    System.out.println("Введите название");
                    String name = scan.nextLine();

                    System.out.println("Введите описание");
                    String description = scan.nextLine();

                    System.out.println("Выберите сложность");
                    System.out.println("EASY ; NORMAL ; HARD");
                    String difficulty = scan.nextLine().toUpperCase();

                    Difficulty difficultyNew;

                    difficultyNew = Difficulty.valueOf(difficulty);

                    running runningNew = running.TODO;

                    base.add(new MarkBase(name, description, difficultyNew, runningNew));
                    break;
                case 2:
                    base.viewMark(1);

                    System.out.println("Введите айди заметки");
                    int id = scan.nextInt();

                    base.delete(id);
                    break;
                case 3:
                    base.viewMark(1);
                    break;
                case 4:
                    System.out.println("Введите имя заметки");
                    String Name = scan.nextLine();
                    base.searchMarks(Name);
                    break;
                case 5:
                    base.viewMark(1);
                    System.out.println("Введите айди заметки");
                    int id_done = scan.nextInt();
                    base.donetask(id_done);
                    break;
                case 6:
                    base.viewMark(1);

                    System.out.println("Введите айди заметки");
                    int id_edit = scan.nextInt();
                    scan.nextLine();

                    System.out.println("Введите новое имя заметки");
                    String name_edit = scan.nextLine();


                    System.out.println("Введите новое описание заметки");
                    String description_edit = scan.nextLine();

                    base.edittask(id_edit, name_edit, description_edit);
                    break;
                case 7:
                    base.viewMark(2);
                    break;
                case 8:
                    base.viewMark(3);
                    break;
                case 9:
                    System.out.println("Выберите заметку");
                    base.viewMark(1);
                    int id_todo = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Выберите прогресс задачи");
                    System.out.println("TODO ; IN_PROGRESS ; DONE");
                    String name_todo = scan.nextLine().toUpperCase();
                    base.progresstask(id_todo, name_todo);
                    break;
                default:
            }
        }while (true);
    }
}
