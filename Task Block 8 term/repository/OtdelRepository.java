package repository;

import domain.Otdel;
import test.DBWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OtdelRepository implements Repository<Otdel>{
    private final DBWorker connector;

    public OtdelRepository() {
        this.connector = new DBWorker();
    }

    @Override
    public Otdel find(Long id) throws SQLException {
        String find="SELECT * FROM company.otdel where id="+id;
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(find);
        resultSet.next();

        String name = resultSet.getString("name");

        return new Otdel(id,name);
    }

    @Override
    public void save(Otdel source) throws SQLException {
        String save ="INSERT INTO `company`.`otdel` (`name`) VALUES (?)";
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(save);

        preparedStatement.setString(1,source.getName());

        preparedStatement.execute();
    }

    @Override
    public void delete(Otdel target) throws SQLException {
        String delete ="DELETE FROM `company`.`otdel` WHERE id = "+target.getId();
        String update ="UPDATE `company`.`worker` SET `id_otdel` = '0' WHERE id_otdel = "+target.getId();
        String update2 ="UPDATE `company`.`tovar` SET `id_otdel` = '0' WHERE id_otdel = "+target.getId();
        Statement statement = connector.getConnection().createStatement();

        statement.execute(delete);
        statement.execute(update);
        statement.execute(update2);
    }

    @Override
    public List<Otdel> list() throws SQLException {
        List<Otdel> list = new ArrayList<>();
        String show = "SELECT * FROM company.otdel";
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");

            list.add(new Otdel(id,name));
        }
        return list;
    }

    @Override
    public void update(Otdel obj) throws SQLException {
        String update="UPDATE `company`.`tovar` SET `name` = ? WHERE id = "+obj.getId();
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(update);

        preparedStatement.setString(1,obj.getName());

        preparedStatement.execute();
    }

    @Override
    public List<Otdel> getListPoId(Long id) {
        return null;
    }
}
