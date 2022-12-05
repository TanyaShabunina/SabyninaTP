package repository;

import domain.Accounting;
import test.DBWorker;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountingRepository implements Repository<Accounting>{

    private final DBWorker connector;

    public AccountingRepository() {
        this.connector = new DBWorker();
    }

    @Override
    public Accounting find(Long id) throws SQLException {
        String find = "select ac.*,w.name work from company.accounting ac \n" +
                "left join company.work w on w.id = ac.id_work";
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(find);
        resultSet.next();

        long id_work = resultSet.getLong("id_work");
        String work = resultSet.getString("work");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        int zp = resultSet.getInt("zp");

        return new Accounting(id,id_work,work,name,age,zp);
    }

    @Override
    public void save(Accounting source) throws SQLException {
        String save = "INSERT INTO `company`.`accounting` (`name`, `age`, `zp`, `id_work`) VALUES (?,?,?,?);";
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(save);

        preparedStatement.setString(1,source.getName());
        preparedStatement.setInt(2,source.getDate());
        preparedStatement.setInt(3,source.getZp());
        preparedStatement.setLong(4,source.getId_work());

        preparedStatement.execute();
    }

    @Override
    public void delete(Accounting target) throws SQLException {
        String delete ="DELETE FROM `company`.`accounting` WHERE id ="+target.getId();
        Statement statement = connector.getConnection().createStatement();
        statement.execute(delete);
    }

    @Override
    public List<Accounting> list() throws SQLException {
        List<Accounting> list = new ArrayList<>();
        String show ="select ac.*,w.name work from company.accounting ac \n" +
                "left join company.work w on w.id = ac.id_work";
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()) {

            long id = resultSet.getLong("id");
            long id_work = resultSet.getLong("id_work");
            String work = resultSet.getString("work");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            int zp = resultSet.getInt("zp");

            list.add(new Accounting(id, id_work, work, name, age, zp));
        }
        return list;
    }

    @Override
    public void update(Accounting obj) throws SQLException {
        String update="UPDATE `company`.`accounting` SET `name` = ?, `age` = ?, `zp` = ?, `id_work` = ? WHERE id = "+obj.getId();
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(update);
        
        preparedStatement.setString(1,obj.getName());
        preparedStatement.setInt(2,obj.getDate());
        preparedStatement.setInt(3,obj.getZp());
        preparedStatement.setLong(4,obj.getId_work());
        
        preparedStatement.execute();
    }

    @Override
    public List<Accounting> getListPoId(Long id) {
        return null;
    }

}
