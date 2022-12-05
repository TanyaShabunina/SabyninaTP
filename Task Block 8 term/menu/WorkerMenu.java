package menu;

import domain.Accounting;
import domain.Otdel;
import domain.Work;
import domain.Worker;
import service.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class WorkerMenu {
    Scanner scanner = new Scanner(System.in);
    LocalDate data = LocalDate.now();


    private final Service<Worker> workerService;
    private final Service<Work> workService;
    private final Service<Otdel> otdelService;

    private final Menu menu;
    private final WorkMenu workMenu;
    private final OtdelMenu otdelMenu;

    public WorkerMenu(Menu menu, Service<Worker> workerService, Service<Work> workService, Service<Otdel> otdelService, WorkMenu workMenu, OtdelMenu otdelMenu) {
        this.workerService = workerService;
        this.menu = menu;
        this.workService = workService;
        this.otdelService = otdelService;
        this.workMenu = workMenu;
        this.otdelMenu = otdelMenu;
    }


    public void draw() throws SQLException {
        System.out.println("--- Рабочие ---");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println();
        System.out.println("0. Назад");

        switch (scanner.nextInt()){
            case 1->{
                newWorker();
            }
            case 2->{
                deleteWorker();
            }
            case 3->{
                changeWorker();
            }
            case 0->{
                menu.draw();
            }
        }
    }
    public void newWorker() throws SQLException {
        System.out.println("Заполните данные: ");
        System.out.println("Имя: ");    String name = scanner.next();
        System.out.println("Год рождения: ");   int age = data.getYear() - scanner.nextInt();
        System.out.println("Зарплата: ");   int zp = scanner.nextInt();

        workMenu.drawListWork();

        System.out.println("Выберите профессию: ");
        Long id_work = scanner.nextLong();
        Work work = workService.getById(id_work);

        otdelMenu.drawListOtdel();
        System.out.println("Выберите отдел: ");
        Long id_otdel = scanner.nextLong();
        Otdel otdel = otdelService.getById(id_otdel);

        workerService.save(new Worker(null,id_work, work.getName(),id_otdel, otdel.getName(),name,age,zp ));
    }
    public void deleteWorker() throws SQLException {
        drawListWorker();
        System.out.println("Выберите кого хотите удалить");
        Long id=scanner.nextLong();
        Worker byId = workerService.getById(id);
        workerService.delete(byId);
    }
    public void changeWorker() throws SQLException {
        drawListWorker();
        System.out.println("Выберите кого хотите редактировать: ");
        Long id = scanner.nextLong();
        Worker worker = workerService.getById(id);

        int q = 0;
        while (q == 0) {

            System.out.println("Что хотите изменить?");
            System.out.println("1. Имя");
            System.out.println("2. Возраст");
            System.out.println("3. Зарплату");
            System.out.println("4. Профессию");
            System.out.println("5. Отдел");
            System.out.println("9. Назад");
            System.out.println("0. Сохранить и выйти");

            switch (scanner.nextInt()){
                case 1->{
                    System.out.println("Введите новое имя:");   worker.setName( scanner.next() );
                }
                case 2->{
                    System.out.println("Введите новый год рождения: "); worker.setDate( data.getYear() - scanner.nextInt() );
                }
                case 3->{
                    System.out.println("Введите новую зарплату: "); worker.setZp( scanner.nextInt() );
                }
                case 4->{
                    workMenu.drawListWork();
                    System.out.println("Выберите новую профессию: ");
                    worker.setId_work( scanner.nextLong() );
                }
                case 5->{
                    otdelMenu.drawListOtdel();
                    System.out.println("Выберите новый отдел: ");
                    worker.setId_otdel(scanner.nextLong() );
                }
                case 9->{
                    draw();
                    q=1;
                }
                case 0->{
                    workerService.update(worker);
                    draw();
                    q=1;
                }

            }
        }
    }

    public void drawListWorker() throws SQLException {
        System.out.println();
        System.out.println("--- Рабочие ---");
        workerService.getAll().forEach(System.out::println);
        System.out.println();
    }


}
