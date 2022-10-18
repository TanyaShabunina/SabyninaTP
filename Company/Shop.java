package Company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shop {
    private String name;
    private List<Person> spisSotr = new ArrayList<>();


    Shop(String name, Person...spisSotr) {
        this.name = name;
        this.spisSotr.addAll((Arrays.asList(spisSotr)));
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setVr(Person spisSotr) {
        this.spisSotr.add(spisSotr);
    }

    public List<Person> getVr() {
        for (int i =0;i<spisSotr.size();i++){
            System.out.println(spisSotr.get(i));
        }
        return null;
    }

    public String toString() {
        return name ;
    }

}
