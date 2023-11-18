public class Connector {
    private static Connector connector = null;

    private static Queu queu = new Queu();
    public static Connector getConnector(){
        if (connector == null){

            connector = new Connector();
        }
            return connector;
    }
    public Connector(){

    }
    public void showQueu (){

        System.out.println(queu.getList());
    }
}
