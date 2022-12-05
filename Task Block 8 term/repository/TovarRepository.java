package repository;

import domain.Tovar;
import test.DBWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TovarRepository implements Repository<Tovar>{
    private final DBWorker connector;

    public TovarRepository() {
        this.connector = new DBWorker();
    }

    @Override
    public Tovar find(Long id) throws SQLException {
        String find ="select t.*,ot.name otdel from company.tovar t\n" +
                "left join company.otdel ot on t.id_otdel=ot.id\n" +
                "where t.id="+id;
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(find);
        resultSet.next();

        String name = resultSet.getString("name");
        long id_otdel = resultSet.getLong("id_otdel");
        String otdel = resultSet.getString("otdel");

        return new Tovar(id,name,id_otdel,otdel);
    }

    @Override
    public void save(Tovar source) throws SQLException {
        String save ="INSERT INTO `company`.`tovar` (`name`, `id_otdel`) VALUES (?,?)";
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(save);

        preparedStatement.setString(1,source.getName());
        preparedStatement.setLong(2,source.getId_otdel());

        preparedStatement.execute();
    }

    @Override
    public void delete(Tovar target) throws SQLException {
        String delete="DELETE FROM `company`.`tovar` WHERE id = "+target.getId();
        String delete2="DELETE FROM `company`.`tovar_client` WHERE id_tovar ="+target.getId();
        Statement statement = connector.getConnection().createStatement();
        statement.execute(delete);
        statement.execute(delete2);
    }

    @Override
    public List<Tovar> list() throws SQLException {
        List<Tovar> list=new ArrayList<>();
        String show ="select t.*,ot.name otdel from company.tovar t\n" +
                "left join company.otdel ot on t.id_otdel=ot.id";
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            long id_otdel = resultSet.getLong("id_otdel");
            String otdel = resultSet.getString("otdel");

            list.add(new Tovar(id,name,id_otdel,otdel));
        }
        return list;
    }

    @Override
    public void update(Tovar obj) throws SQLException {
        String update ="UPDATE `company`.`tovar` SET `name` = ?,`id_otdel` = ? WHERE id` = "+obj.getId();
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(update);

        preparedStatement.setString(1,obj.getName());
        preparedStatement.setLong(2,obj.getId_otdel());

        preparedStatement.execute();
    }

    @Override
    public List<Tovar> getListPoId(Long id) {
        return null;
    }
}
