package menu;

import domain.Otdel;
import domain.Work;
import service.Service;

import java.sql.SQLException;
import java.util.Scanner;

public class OtdelMenu {
    Scanner scanner = new Scanner(System.in);
    private final Service<Otdel> otdelService;
    private final Menu menu;

    public OtdelMenu(Menu menu,Service<Otdel> otdelService) {
        this.menu = menu;
        this.otdelService = otdelService;
    }

    public void draw() throws SQLException {
        System.out.println("--- Отдел ---");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("0. Назад");

        switch (scanner.nextInt()){
            case 1->{
                newOtdel();
            }
            case 2->{
                deleteOtdel();
            }
            case 3->{
                changeOtdel();
            }
            case 0->{
                menu.draw();
            }
        }
    }

    public void newOtdel() throws SQLException {
        System.out.println("Заполните данные");
        System.out.println("Название: ");
        String name = scanner.next();

        otdelService.save(new Otdel(null,name));
    }
    public void deleteOtdel() throws SQLException {
        drawListOtdel();
        System.out.println("Выберите отдел какой хотите удалить: ");
        Long id = scanner.nextLong();
        Otdel byId = otdelService.getById(id);
        otdelService.delete(byId);
    }
    public void changeOtdel() throws SQLException {
        drawListOtdel();
        System.out.println("Выберите профессию какую хотите изменить: ");
        Long id =scanner.nextLong();
        Otdel otdel = otdelService.getById(id);

        int q=0;
        while (q==0){
            System.out.println("Что хотите изменить");
            System.out.println("1. Название");
            System.out.println("9. Назад");
            System.out.println("0. Сохранить и выйти");

            switch (scanner.nextInt()){
                case 1->{
                    System.out.println("Введите новое название: "); otdel.setName( scanner.next() );
                }
                case 9->{
                    draw();
                    q=1;
                }
                case 0->{
                    otdelService.update(otdel);
                    draw();
                    q=1;
                }
            }
        }
    }

    public void drawListOtdel() throws SQLException {
        System.out.println();
        System.out.println("--- Отделы ---");
        otdelService.getAll().forEach(System.out::println);
        System.out.println();
    }
}
