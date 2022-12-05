package domain;

public class Client {
    private Long id;
    private String name;
    private Long telefon;

    public Client(Long id, String name, Long telefon) {
        this.id = id;
        this.name = name;
        this.telefon = telefon;
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

    public Long getTelefon() {
        return telefon;
    }

    public void setTelefon(Long telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telefon=" + telefon +
                '}';
    }
}
