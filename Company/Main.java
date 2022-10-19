package Company;

import java.util.Scanner;

public class Main {

    private static DateBass db = new DateBass();

    public static void main(String[] args) {
        menu();
    }

    private static void menu()  {

        Scanner scan = new Scanner(System.in);
        mark:
        while (true) {
            System.out.println();
            System.out.println("1. Цеха");
            System.out.println("2. Сотрудники");
            System.out.println("3. Списки");
            System.out.println("4. Сохранение");
            System.out.println("0. Выход");
            int result = scan.nextInt();
            switch (result) {
                case 1:
                    System.out.println("1 Добавить 2 Удалить 3 Редактировать");
                    int a = scan.nextInt();
                    if (a == 1) {
                        db.addShop(db.newShop());
                    }
                    if (a == 2) {
                        db.showIdShop();db.deleteShop();
                    }
                    if (a == 3) {
                        db.showIdShop();db.changeShop();
                    }
                    break;
                case 2:
                    System.out.println("1 Добавить 2 Удалить 3 Редактировать");
                    int x = scan.nextInt();
                    if (x==1){
                        db.addPerson(db.newPerson());
                    }
                    if (x==2){
                        db.showIdPerson();db.deletePerson();
                    }
                    if (x==3){
                        db.showIdPerson();db.changePerson();
                    }
                    break;
                case 3:
                    System.out.println("1 Цеха 2 Сотрудники 3 Все вместе 4 По отдельности ");
                    int b = scan.nextInt();
                    if (b==1){
                        System.out.println("Название\t"+ "Количество сотрудников");
                        db.showShop();
                    }
                    if (b==2){
                        db.showPerson();
                    }
                    if (b==3){
                        db.showShop(); db.showPerson();
                    }
                    if (b==4){
                        System.out.println("1 По цехам 2 Весь список по цехам");
                        int s = scan.nextInt();
                        if (s==1){
                        //    db.showPoShop();
                        }
                        if (s==2){
                           // db.showVsePoShop();
                        }
                    }
                    break ;
                case 4:
                    System.out.println("Сохранение....");




                    break;
                default:
                    break mark;
            }
        }

    }

        }