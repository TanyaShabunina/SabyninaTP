package domain;

public class Worker extends Person{

    private String work_name;
    private Long id_otdel;
    private String name_otdel;

    public Worker(Long id, Long id_work, String work_name, Long id_otdel, String name_otdel, String name, int date, int zp) {
        super(id, id_work, name, date, zp);
        this.id_otdel=id_otdel;
        this.name_otdel=name_otdel;
        this.work_name=work_name;
    }

    public Long getId_otdel() {
        return id_otdel;
    }

    public void setId_otdel(Long id_otdel) {
        this.id_otdel = id_otdel;
    }

    public String getName_otdel() {
        return name_otdel;
    }

    public void setName_otdel(String name_otdel) {
        this.name_otdel = name_otdel;
    }

    public String getWork_name() {
        return work_name;
    }

    public void setWork_name(String work_name) {
        this.work_name = work_name;
    }

    public String toString() {
        return "Worker{" +
                "id=" + getId() +
                ", work=" + work_name +
                ", otdel=" + name_otdel +
                ", name='" + getName() + '\'' +
                ", date=" + getDate() +
                ", zp=" + getZp() +
                '}';
    }
}
