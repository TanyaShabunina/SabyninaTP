package menu;

import domain.Client;
import domain.Work;
import service.Service;

import java.sql.SQLException;
import java.util.Scanner;

public class ClientMenu {
    Scanner scanner = new Scanner(System.in);

    private final Service<Client> clientService;

    private final Menu menu;


    public ClientMenu( Menu menu,Service<Client> clientService) {
        this.clientService = clientService;
        this.menu = menu;
    }

    public void draw() throws SQLException {
        System.out.println("--- Клиент ---");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("0. Назад");

        switch (scanner.nextInt()){
            case 1->{
                newClient();
            }
            case 2->{
                deleteClient();
            }
            case 3->{
                changeClient();
            }
            case 0->{
                menu.draw();
            }
        }
    }
    public void newClient() throws SQLException {
        System.out.println("Заполните данные");
        System.out.println("Название: ");
        String name = scanner.next();
        System.out.println("Номер телефона: ");
        Long telefon = scanner.nextLong();

        clientService.save(new Client(null,name,telefon));
    }
    public void deleteClient() throws SQLException {
        drawListClient();
        System.out.println("Выберите клиента которого хотите удалить: ");
        Long id = scanner.nextLong();
        Client byId = clientService.getById(id);
        clientService.delete(byId);
    }
    public void changeClient() throws SQLException {
        drawListClient();
        System.out.println("Выберите профессию какую хотите изменить: ");
        Long id =scanner.nextLong();
        Client client = clientService.getById(id);

        int q=0;
        while (q==0){
            System.out.println("Что хотите изменить");
            System.out.println("1. Название");
            System.out.println("2. Телефон");
            System.out.println("9. Назад");
            System.out.println("0. Сохранить и выйти");

            switch (scanner.nextInt()){
                case 1->{
                    System.out.println("Введите новое название: "); client.setName( scanner.next() );
                }
                case 2->{
                    System.out.println("Введите новый номер телефона: ");   client.setTelefon( scanner.nextLong() );
                }
                case 9->{
                    draw();
                    q=1;
                }
                case 0->{
                    clientService.update(client);
                    draw();
                    q=1;
                }
            }
        }
    }

    public void drawListClient() throws SQLException {
        System.out.println();
        System.out.println("---- Клиент ---");
        clientService.getAll().forEach(System.out::println);
        System.out.println();
    }

}
