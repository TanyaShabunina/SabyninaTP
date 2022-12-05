package repository;

import domain.Work;
import test.DBWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorkRepository implements Repository<Work>{

    private final DBWorker connector;

    public WorkRepository() {
        this.connector = new DBWorker();
    }

    @Override
    public Work find(Long id) throws SQLException {
        String find ="SELECT * FROM company.work where id="+id;
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(find);
        resultSet.next();

        String name = resultSet.getString("name");

        return new Work(id,name);
    }

    @Override
    public void save(Work source) throws SQLException {
        String save ="INSERT INTO `company`.`work` (`name`) VALUES (?)";
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(save);

        preparedStatement.setString(1,source.getName());

        preparedStatement.execute();
    }

    @Override
    public void delete(Work target) throws SQLException {
        String delete ="DELETE FROM `company`.`work` WHERE id = "+target.getId();
        String update ="UPDATE `company`.`worker` SET `id_work` = '0' WHERE id_work = "+target.getId();
        String update2="UPDATE `company`.`accounting` SET `id_work` = '0' WHERE id_work = "+target.getId();
        Statement statement = connector.getConnection().createStatement();
        statement.execute(delete);
        statement.execute(update);
        statement.execute(update2);
    }

    @Override
    public List<Work> list() throws SQLException {
        List<Work> list = new ArrayList<>();
        String show="SELECT * FROM company.work";
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");

            list.add(new Work(id,name));
        }
        return list;
    }

    @Override
    public void update(Work obj) throws SQLException {
        String update ="UPDATE `company`.`work` SET `name` = ? WHERE id = "+obj.getId();
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(update);

        preparedStatement.setString(1,obj.getName());

        preparedStatement.execute();
    }

    @Override
    public List<Work> getListPoId(Long id) {
        return null;
    }
}
