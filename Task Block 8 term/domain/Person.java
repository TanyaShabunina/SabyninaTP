package domain;

public class Person {
    private Long id;
    private Long id_work;
    private String name;
    private int date;
    private int zp;

    public Person(Long id, Long id_work, String name, int date, int zp) {
        this.id = id;
        this.id_work = id_work;
        this.name = name;
        this.date = date;
        this.zp = zp;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_work() {
        return id_work;
    }

    public void setId_work(Long id_work) {
        this.id_work = id_work;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getZp() {
        return zp;
    }

    public void setZp(int zp) {
        this.zp = zp;
    }
}
