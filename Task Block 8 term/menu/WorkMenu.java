package menu;

import domain.Work;
import service.Service;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class WorkMenu {
    Scanner scanner = new Scanner(System.in);

    private final Service<Work> workService;

    private final Menu menu;

    public WorkMenu(Menu menu,Service<Work> workService ) {
        this.workService = workService;
        this.menu = menu;
    }


    public void draw() throws SQLException {
        System.out.println("--- Профессии ---");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("0. Назад");

        switch (scanner.nextInt()){
            case 1->{
                newWork();
            }
            case 2->{
                deleteWork();
            }
            case 3->{
                changeWork();
            }
            case 0->{
                menu.draw();
            }
        }
    }
    public void newWork() throws SQLException {
        System.out.println("Заполните данные");
        System.out.println("Название: ");
        String name = scanner.next();

        workService.save(new Work(null,name));
    }
    public void deleteWork() throws SQLException {
        drawListWork();
        System.out.println("Выберите профессию какую хотите удалить: ");
        Long id = scanner.nextLong();
        Work byId = workService.getById(id);
        workService.delete(byId);
    }
    public void changeWork() throws SQLException {
        drawListWork();
        System.out.println("Выберите профессию какую хотите изменить: ");
        Long id =scanner.nextLong();
        Work work = workService.getById(id);

        int q=0;
        while (q==0){
            System.out.println("Что хотите изменить");
            System.out.println("1. Название");
            System.out.println("9. Назад");
            System.out.println("0. Сохранить и выйти");

            switch (scanner.nextInt()){
                case 1->{
                    System.out.println("Введите новое название: "); work.setName( scanner.next() );
                }
                case 9->{
                    draw();
                    q=1;
                }
                case 0->{
                    workService.update(work);
                    draw();
                    q=1;
                }
            }
        }
    }

    public void drawListWork() throws SQLException {
        System.out.println();
        System.out.println("---- Профессии ---");
        workService.getAll().forEach(System.out::println);
        System.out.println();
    }
}
