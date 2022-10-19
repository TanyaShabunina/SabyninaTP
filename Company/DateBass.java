package Company;//создаем листы

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DateBass {
    Scanner scan = new Scanner(System.in);
    private List<Shop> shopList = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();
    void addPerson(Person Person) {
        personList.add(Person);
    }

    void showPerson() {
        for (int i = 0; i < personList.size(); i++) {
            Person number = personList.get(i);
            System.out.println(number);
        }
    }

    void showIdPerson() {
        for (int i = 0; i < personList.size(); i++) {
            Person number = personList.get(i);
            System.out.println(i + " " + number);
        }
    }

Person newPerson(){
    LocalDate data = LocalDate.now();
    String shop = null;
    int a = 0;
    System.out.println("Введите имя сотрудника: ");
    String name = scan.next();
    System.out.println("Введите зарплату сотрудника: ");
    int zp = scan.nextInt();
    System.out.println("Выберите 1. Создать новый цех 2. Перевести в другой цех");
    int x = scan.nextInt();

    if (x == 1) {
        addShop(newShop());

    }
    if (x == 2) {
        if (shopList.size() != 0) {
            System.out.println("Выберите цех: ");
            showIdShop();

            a = scan.nextInt();
            shop = ((Shop) shopList.get(a)).getName();

        }
        else{
            System.out.println("Список цехов пуст");
            shop=null;
        }
    }



    System.out.println("Введите год рождения сотрудника: ");
    int n = scan.nextInt();
    int date = data.getYear() - n;

    System.out.println("Введите пол сотрудника: ");
    String pol = scan.next();
Person person = new Person(name, pol, date, shop, zp);
    if (shop!=null){

        shopList.get(a).setVr(person);

    }


    System.out.println(person);
    return person;

}
    void deletePerson() {
        System.out.println();
        System.out.println("Введите номер сотрудника: ");
        int n = scan.nextInt();
        personList.remove(n);
    }


    void changePerson() {
        LocalDate data = LocalDate.now();
        System.out.println();
        System.out.println("Введите номер сотрудника, которого хотите изменить: ");
        int numberPerson = scan.nextInt();
        Object p = personList.get(numberPerson);
        System.out.println(p);
        System.out.println("Выберите что хотите изменить: 0 Полностью сотрудника 1 Пол 2 Имя 3 Дата рождения 5 Отдел ");
        int x = scan.nextInt();
        switch (x) {
            case 0:
                System.out.println("Введите какого сотрудника хотите полностью изменить: ");
                int c = scan.nextInt();
                personList.set(c, newPerson());
                break;
            case 1:
                System.out.println("Введите новый пол: ");
                String g = scan.next();
                ((Person) personList.get(numberPerson)).setPol(g);
                break;
            case 2:
                System.out.println("Введите новое имя: ");
                g = scan.next();
                ((Person) personList.get(numberPerson)).setName(g);
                break;
            case 3:
                System.out.println("Введите новую дату рождения: ");
                int d = scan.nextInt();
                d = data.getYear() - d;
                ((Person) personList.get(numberPerson)).setDate(d);
                break;

            case 5:
                System.out.println("Выберети новый отдел: ");
                showIdShop();
                int id = 0;
                int newOt = scan.nextInt();
                String nOt = ((Shop) shopList.get(newOt)).getName();
                ((Person) personList.get(numberPerson)).setShop(nOt);

            default:
                break;
        }

    }
////////
void addShop(Shop Otdel) {
    shopList.add(Otdel);
}
    void showShop() {
        for (int i = 0; i < shopList.size(); i++) {
            Shop number = shopList.get(i);
            System.out.println(number);
        }
    }

    void showIdShop() {
        for (int i = 0; i < shopList.size(); i++) {
            Shop number = shopList.get(i);
            System.out.println(i + " " + number);
        }
    }
    Shop newShop() {

        System.out.println("Введите название нового цеха: ");
        String name = scan.next();
        Shop h = new Shop(name);
        System.out.println(h);
        return h;
    }
    void deleteShop() {
        System.out.println();
        System.out.println("Введите номер цеха: ");
        int n = scan.nextInt();
        shopList.remove(n);
    }

    void changeShop() {
        System.out.println();
        System.out.println("Введите номер цеха, которое хотите изменить: ");
        int n = scan.nextInt();
        Object p = shopList.get(n);
        System.out.println(p);
        System.out.println("Выберите что хотите изменить: 1 Полностью цех 2 Название ");
        int x = scan.nextInt();
        switch (x) {
            case 1:
                System.out.println("Введите какой отдел хотите полностью изменить: ");
                int c = scan.nextInt();
                shopList.set(c, newShop());
                break;
            case 2:
                System.out.println("Введите новое название: ");
                String g = scan.next();
                 shopList.get(n).setName(g);
                break;
            default:
                break;
        }
    }



















}
