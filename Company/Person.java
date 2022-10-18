package Company;//конструктор для рабочего

public class Person {
   // package test;

  //  public class Person {

        private String pol;
        private String name;
        private String shop;
        private int zp;
        private int date;
       // private int inn;

        Person(String name, String pol, int date, String shop, int zp) {

            this.pol = pol;
            this.name = name;
            this.date = date;
            this.shop = shop;
            this.zp = zp;
        }

        public void setName(String newName) {
            this.name = newName;
        }

        public void setPol(String pol) {
            this.pol = pol;
        }

        public void setDate(int date) {
            this.date = date;
        }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public void setZp(int zp) {
        this.zp = zp;
    }

        public String getName() {
            return name;
        }

        public String getPol() {
            return pol;
        }

        public int getDate() {
            return date;
        }

    public int getZp() {
        return zp;
    }

    public String getShop() {
        return shop;
    }

    public String toString() {
        return shop+" "+getName()+" "+getPol()+" "+zp;
    }

    }

