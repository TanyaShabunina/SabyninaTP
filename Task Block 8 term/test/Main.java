package test;

import domain.*;
import menu.Menu;
import repository.*;
import service.*;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

        Repository<Accounting> accountingRepository = new AccountingRepository();
        Service<Accounting> accountingService = new AccountingService(accountingRepository);

        Repository<Work> workRepository = new WorkRepository();
        Service<Work> workService = new WorkService(workRepository);

        Repository<Client> clientRepository = new ClientRepository();
        Service<Client> clientService = new ClientService(clientRepository);

        Repository<Worker> workerRepository = new WorkerRepository();
        Service<Worker> workerService = new WorkerService(workerRepository);

        Repository<Otdel> otdelRepository = new OtdelRepository();
        Service<Otdel> otdelService = new OtdelService(otdelRepository);

        Repository<Tovar> tovarRepository = new TovarRepository();
        Service<Tovar> tovarService =new TovarService(tovarRepository);


        Menu menu = new Menu(accountingService, workService, clientService, workerService, otdelService, tovarService);

        while (true) {
            menu.draw();
        }

}
}