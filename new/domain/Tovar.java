package domain;

public class Tovar {
    private Long id;
    private String name;
    private Long id_otdel;
    private String name_otdel;

    public Tovar(Long id, String name, Long id_otdel, String name_otdel) {
        this.id = id;
        this.name = name;
        this.id_otdel = id_otdel;
        this.name_otdel = name_otdel;
    }

    public String getName_otdel() {
        return name_otdel;
    }

    public void setName_otdel(String name_otdel) {
        this.name_otdel = name_otdel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId_otdel() {
        return id_otdel;
    }

    public void setId_otdel(Long id_otdel) {
        this.id_otdel = id_otdel;
    }

    @Override
    public String toString() {
        return "Tovar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", otdel=" + name_otdel +
                '}';
    }
}
