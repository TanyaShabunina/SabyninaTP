package menu;

import domain.Tovar;
import service.Service;

import java.sql.SQLException;
import java.util.Scanner;

public class TovarMenu {
    Scanner scanner = new Scanner(System.in);

    private final Service<Tovar> tovarService;


    private final Menu menu;
    private final OtdelMenu otdelMenu;


    public TovarMenu(Menu menu, Service<Tovar> tovarService, OtdelMenu otdelMenu) {
        this.tovarService = tovarService;
        this.menu = menu;
        this.otdelMenu = otdelMenu;
    }
    public void draw() throws SQLException {
        System.out.println("--- Товар ---");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("0. Назад");

        switch (scanner.nextInt()){
            case 1->{
                newTovar();
            }
            case 2->{
                deleteTovar();
            }
            case 3->{
                changeTovar();
            }
            case 0->{
                menu.draw();
            }
        }
    }

    public void newTovar() throws SQLException {
        System.out.println("Заполните данные");
        System.out.println("Название: ");
        String name = scanner.next();
        otdelMenu.drawListOtdel();
        System.out.println("Выберите отдел:");
        Long id = scanner.nextLong();

        tovarService.save(new Tovar(null,name,id,null));
    }
    public void deleteTovar() throws SQLException {
        drawListTovar();
        System.out.println("Выберите товар который хотите удалить: ");
        Long id = scanner.nextLong();
        Tovar byId = tovarService.getById(id);
        tovarService.delete(byId);
    }
    public void changeTovar() throws SQLException {
        drawListTovar();
        System.out.println("Выберите товар который хотите изменить: ");
        Long id =scanner.nextLong();
        Tovar tovar = tovarService.getById(id);

        int q=0;
        while (q==0){
            System.out.println("Что хотите изменить");
            System.out.println("1. Название");
            System.out.println("2. Отдел");
            System.out.println("9. Назад");
            System.out.println("0. Сохранить и выйти");

            switch (scanner.nextInt()){
                case 1->{
                    System.out.println("Введите новое название: "); tovar.setName( scanner.next() );
                }
                case 2->{
                    otdelMenu.drawListOtdel();
                    System.out.println("Выберите новый отдел: "); tovar.setId_otdel( scanner.nextLong() );
                }
                case 9->{
                    draw();
                    q=1;
                }
                case 0->{
                    tovarService.update(tovar);
                    draw();
                    q=1;
                }
            }
        }
    }

    public void drawListTovar() throws SQLException {
        System.out.println();
        System.out.println("--- Товары ---");
        tovarService.getAll().forEach(System.out::println);
        System.out.println();
    }




}
