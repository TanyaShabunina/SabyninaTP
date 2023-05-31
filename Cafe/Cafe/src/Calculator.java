import java.util.*;

public class Calculator {
    PrintCheck printCheck = new PrintCheck();
    public void calc(List<Product> listOrder){
        List<Product> check = new ArrayList<>();

        double d = 0;
        double sum;
        double sumN = 0;
        double sumNap =0;
        double sumP=0;
        int amountityPizza = 0;
        int amountityNap=0;

        for (int i = 0;i<listOrder.size();i++) {
            d+= listOrder.get(i).getPrice();
            if (listOrder.get(i).getView().equals("Pizza")){
                amountityPizza +=1;
                if (amountityPizza == 5){
                    listOrder.get(i).setPrice(0);
                    amountityPizza = 0;
                }
                sumP+=listOrder.get(i).getPrice();
            }
            if (listOrder.get(i).getView().equals("Drinkables")){

                if(listOrder.get(i).getPrice()>2){
                    amountityNap+=1;
                    sumN+=listOrder.get(i).getPrice();
                }else {
                    sumNap += listOrder.get(i).getPrice();
                }

            }

        }
        listOrder.forEach(System.out::println);
        check.add(listOrder.get(0));

        for (int i = 1;i<listOrder.size();i++) {
            int a =0;
            for (int j = 0;j<check.size();j++) {
                if (listOrder.get(i).getId() == check.get(j).getId()){
                    check.get(j).setАmountity( check.get(j).getАmountity() + 1 );
                    check.get(j).setPrice( check.get(j).getPrice() + listOrder.get(i).getPrice());
                    a = 0;
                    break;
                }else {
                    a = 1;
                }
            }
            if ( a == 1){
                check.add(new Product(listOrder.get(i).getId(), listOrder.get(i).getName(),
                        listOrder.get(i).getPrice(), listOrder.get(i).getView(),1));
            }
        }


        if(amountityNap>3){
            sumN -= sumN*0.15;
        }

        sum = sumP+ sumN+sumNap;
        if(sum > 50){
            sum-= sum*0.2;
        }

        printCheck.check(check,d-sum,sum);

    }

}
