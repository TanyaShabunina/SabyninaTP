package repository;

import domain.Worker;
import test.DBWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorkerRepository implements Repository<Worker>{
    private final DBWorker connector;

    public WorkerRepository() {
        this.connector = new DBWorker();
    }

    @Override
    public Worker find(Long id) throws SQLException {
        String find = "select wor.*,w.name work,ot.name otdel from `company`.worker wor \n" +
                "                left join `company`.work w on wor.id_work=w.id\n" +
                "                left join `company`.otdel ot on ot.id=wor.id_otdel\n" +
                "                where wor.id="+id;
        Statement statement =connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(find);
        resultSet.next();

        long id_work = resultSet.getLong("id_work");
        String work = resultSet.getString("work");
        long id_otdel = resultSet.getLong("id_otdel");
        String otdel = resultSet.getString("otdel");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        int zp = resultSet.getInt("zp");

        return new Worker(id,id_work,work,id_otdel,otdel,name,age,zp);
    }

    @Override
    public void save(Worker source) throws SQLException {
        String save = "INSERT INTO `company`.`worker` (`id_work`, `id_otdel`, `name`, `age`, `zp`) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(save);

        preparedStatement.setLong(1,source.getId_work());
        preparedStatement.setLong(2,source.getId_otdel());
        preparedStatement.setString(3,source.getName());
        preparedStatement.setInt(4,source.getDate());
        preparedStatement.setInt(5,source.getZp());

        preparedStatement.execute();
    }

    @Override
    public void delete(Worker target) throws SQLException {
        String delete ="DELETE FROM `company`.`worker` WHERE id = "+target.getId();
        Statement statement = connector.getConnection().createStatement();
        statement.execute(delete);
    }

    @Override
    public List<Worker> list() throws SQLException {
        List<Worker> list = new ArrayList<>();
        String show = """
                select wor.*,w.name work,ot.name otdel from company.worker wor\s
                left join company.work w on wor.id_work=w.id
                left join company.otdel ot on ot.id=wor.id_otdel""";
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id = resultSet.getLong("id");
            long id_work = resultSet.getLong("id_work");
            String work = resultSet.getString("work");
            long id_otdel = resultSet.getLong("id_otdel");
            String otdel = resultSet.getString("otdel");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            int zp = resultSet.getInt("zp");

         list.add(new Worker(id,id_work,work,id_otdel,otdel,name,age,zp));
        }
        return list;
    }

    @Override
    public void update(Worker obj) throws SQLException {
        String update = "UPDATE `company`.`worker` SET `id_work` = ?, `id_otdel` = ?, `name` = ?, `age` = ?, `zp` = ? WHERE id = "+obj.getId();
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(update);

        preparedStatement.setLong(1,obj.getId_work());
        preparedStatement.setLong(2,obj.getId_otdel());
        preparedStatement.setString(3,obj.getName());
        preparedStatement.setInt(4,obj.getDate());
        preparedStatement.setInt(5,obj.getZp());

        preparedStatement.execute();
    }

    @Override
    public List<Worker> getListPoId(Long id) throws SQLException {
        List<Worker> list = new ArrayList<>();
        String show = "select w.*,work.name work,ot.name otdel from company.worker w\n" +
                "left join company.work on work.id=w.id_work\n" +
                "left join company.otdel ot on ot.id=w.id_otdel\n" +
                "where id_otdel =  " +id;
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id1 = resultSet.getLong("id");
            long id_work = resultSet.getLong("id_work");
            long id_otdel = resultSet.getLong("id_otdel");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            int zp = resultSet.getInt("zp");
            String name_work = resultSet.getString("work");
            String name_otdel = resultSet.getString("otdel");

            list.add(new Worker(id1,id_work,name_work,id_otdel,name_otdel,name,age,zp));
        }
        return list;
    }
}
