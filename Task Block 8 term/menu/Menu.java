package menu;

import domain.*;
import service.Service;
import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;


public class Menu {

    Scanner scanner = new Scanner(System.in);

    private final  Service<Accounting> accountingService;
    private final Service<Work> workService;
    private final Service<Client> clientService;
    private final Service<Worker> workerService;
    private final Service<Otdel> otdelService;
    private final Service<Tovar> tovarService;




    private final AccountingMenu accountingMenu;
    private final OtdelMenu otdelMenu;
    private final WorkMenu workMenu;
    private final TovarMenu tovarMenu;
    private final WorkerMenu workerMenu;
    private final ClientMenu clientMenu;


    public Menu(Service<Accounting> accountingService, Service<Work> workService, Service<Client> clientService,
                Service<Worker> workerService, Service<Otdel> otdelService, Service<Tovar> tovarService) {
        this.accountingService = accountingService;
        this.workService = workService;
        this.clientService = clientService;
        this.workerService = workerService;
        this.otdelService = otdelService;
        this.tovarService = tovarService;

        this.workMenu=new WorkMenu(this,workService);
        this.otdelMenu = new OtdelMenu(this,otdelService);
        this.clientMenu = new ClientMenu(this,clientService);

        this.tovarMenu = new TovarMenu(this,tovarService, otdelMenu);
        this.workerMenu = new WorkerMenu(this,workerService, workService, otdelService, workMenu, otdelMenu);
        this.accountingMenu=new AccountingMenu(this,accountingService, workService,workMenu);
    }

    public void draw() throws SQLException {
        System.out.println("------ MENU ------");

        System.out.println("1. Бухгалтерия");
        System.out.println("2. Отделы");
        System.out.println("3. Товар");
        System.out.println("4. Клиенты");
        System.out.println("5. Рабочие");
        System.out.println("6. Рабочие профессии");
        System.out.println("7. Списки");
        System.out.println("9. Выход");

        execute();
    }

    private void execute() throws SQLException {
        int command = scanner.nextInt();

        switch (command) {
            case 1 -> accountingMenu.draw() ;
            case 2 -> otdelMenu.draw();
            case 3 -> tovarMenu.draw();
            case 4 -> clientMenu.draw();
            case 5 -> workerMenu.draw();
            case 6 -> workMenu.draw();
            case 7 -> drawLists();
            case 9 -> System.exit(0);
            default -> throw new IllegalArgumentException("No command found");
        }
    }

    private void drawLists() throws SQLException {
        System.out.println("--- Списки ---");
        System.out.println("1. Вывести всех из бухгалтерии");
        System.out.println("2. Вывести все отделы");
        System.out.println("3. Вывести все товары");
        System.out.println("4. Вывести всех клиентов");
        System.out.println("5. Вывести всех рабочих");
        System.out.println("6. Вывести все профессии");
        System.out.println("");
        System.out.println("0. Назад в меню");
        int d= scanner.nextInt();

        switch (d){
            case 1 -> {
                accountingMenu.drawListAccounting();
                drawLists();
            }
            case 2 -> {
                otdelMenu.drawListOtdel();
                drawLists();
            }
            case 3 -> {
                tovarMenu.drawListTovar();
                drawLists();
            }
            case 4 -> {
                clientMenu.drawListClient();
                drawLists();
            }
            case 5 -> {
                workerMenu.drawListWorker();
                drawLists();
            }
            case 6 -> {
                workMenu.drawListWork();
                drawLists();
            }
            case 7 ->{
                drawListWorkerPoOtdel();
            }
            case 0-> draw();
        }
    }
    private void drawListWorkerPoOtdel() throws SQLException {
        List<Otdel> all = otdelService.getAll();
        for (Otdel o : all) {
            List<Worker> listPoId = workerService.getListPoId(o.getId());
            for (Worker w : listPoId) {
                System.out.println(w.getName());
            }
        }
    }

}