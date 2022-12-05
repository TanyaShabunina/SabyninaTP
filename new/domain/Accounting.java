package domain;

public class Accounting extends Person{
    private String work_name;

    public Accounting(Long id, Long id_work, String work_name, String name, int date, int zp) {
        super(id, id_work, name, date, zp);
        this.work_name=work_name;
    }

    public String getWork_name() {
        return work_name;
    }

    public void setWork_name(String work_name) {
        this.work_name = work_name;
    }

    public String toString() {
        return "Accounting{" +
                "id=" + getId() +
                ", work=" + work_name +
                ", name='" + getName() + '\'' +
                ", date=" + getDate() +
                ", zp=" + getZp() +
                '}';
    }
}
