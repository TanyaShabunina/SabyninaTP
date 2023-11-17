package Obstruction;

public abstract class Template {
    public void print(){
        System.out.println("""
                ----------------------
                Начали
                """);
        show();
        System.out.println("Закончали");

    }
    public abstract void show();
}
