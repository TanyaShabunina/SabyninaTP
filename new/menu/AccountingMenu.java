package menu;

import domain.Accounting;
import domain.Work;
import service.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class AccountingMenu {


    Scanner scanner = new Scanner(System.in);
    LocalDate data = LocalDate.now();

    private final Service<Accounting> accountingService;
    private final Service<Work> workService;

    private final Menu menu;
    private final WorkMenu workMenu;


    public AccountingMenu(Menu menu, Service<Accounting> accountingService, Service<Work> workService, WorkMenu workMenu) {
        this.menu=menu;
        this.workService = workService;
        this.accountingService=accountingService;
        this.workMenu=workMenu;
    }


    public void draw() throws SQLException {
        System.out.println("--- Бухгалтерия ---");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println();
        System.out.println("0. Назад");

        switch (scanner.nextInt()){
            case 1->{
                newAccounting();
            }
            case 2->{
                deleteAccounting();
            }
            case 3->{
                changeAccounting();
            }
            case 0->{
                menu.draw();
            }
        }
    }
    public void newAccounting() throws SQLException {
        System.out.println("Заполните данные: ");
        System.out.println("Имя: ");    String name = scanner.next();
        System.out.println("Год рождения: ");   int age = data.getYear() - scanner.nextInt();
        System.out.println("Зарплата: ");   int zp = scanner.nextInt();

        workMenu.drawListWork();

        System.out.println("Выберите профессию: ");
        Long id_work = scanner.nextLong();
        Work work = workService.getById(id_work);

        accountingService.save(new Accounting(null,id_work, work.getName(),name,age,zp ));
    }
    public void deleteAccounting() throws SQLException {
        drawListAccounting();
        System.out.println("Выберите кого хотите удалить");
        Long id=scanner.nextLong();
        Accounting byId = accountingService.getById(id);
        accountingService.delete(byId);
    }
    public void changeAccounting() throws SQLException {
        drawListAccounting();
        System.out.println("Выберите кого хотите редактировать: ");
        Long id = scanner.nextLong();
        Accounting acc = accountingService.getById(id);

        int q = 0;
        while (q == 0) {

            System.out.println("Что хотите изменить?");
            System.out.println("1. Имя");
            System.out.println("2. Возраст");
            System.out.println("3. Зарплату");
            System.out.println("4. Профессию");
            System.out.println("9. Назад");
            System.out.println("0. Сохранить и выйти");

            switch (scanner.nextInt()){
                case 1->{
                    System.out.println("Введите новое имя:");   acc.setName( scanner.next() );
                }
                case 2->{
                    System.out.println("Введите новый год рождения: "); acc.setDate( data.getYear() - scanner.nextInt() );
                }
                case 3->{
                    System.out.println("Введите новую зарплату: "); acc.setZp( scanner.nextInt() );
                }
                case 4->{
                    workMenu.drawListWork();
                    System.out.println("Выберите новую профессию для бухгалтерии: ");
                    acc.setId_work( scanner.nextLong() );
                }
                case 9->{
                    draw();
                    q=1;
                }
                case 0->{
                    accountingService.update(acc);
                    draw();
                    q=1;
                }

            }
        }
    }

    public void drawListAccounting() throws SQLException {
        System.out.println();
        System.out.println("--- Бухгалтерия ---");
        accountingService.getAll().forEach(System.out::println);
        System.out.println();
    }
}
