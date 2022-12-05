package repository;

import domain.Client;
import test.DBWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements Repository<Client>{
    private final DBWorker connector;

    public ClientRepository() {
        this.connector = new DBWorker();
    }

    @Override
    public Client find(Long id) throws SQLException {
        String find="SELECT * FROM company.client where id="+id;
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(find);
        resultSet.next();

        String name = resultSet.getString("name");
        long telefon = resultSet.getLong("telefon");

        return new Client(id,name,telefon);
    }

    @Override
    public void save(Client source) throws SQLException {
        String save ="INSERT INTO `company`.`client` (`name`, `telefon`) VALUES (?,?)";
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(save);

        preparedStatement.setString(1,source.getName());
        preparedStatement.setLong(2,source.getTelefon());

        preparedStatement.execute();
    }

    @Override
    public void delete(Client target) throws SQLException {
        String delete = "DELETE FROM `company`.`client` WHERE id = "+target.getId();
        String delete2 = "DELETE FROM `company`.`tovar_client` WHERE id_client = "+target.getId();
        Statement statement = connector.getConnection().createStatement();
        statement.execute(delete);
        statement.execute(delete2);
    }

    @Override
    public List<Client> list() throws SQLException {
        List<Client> list = new ArrayList<>();
        String show="SELECT * FROM company.client";
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            long telefon = resultSet.getLong("telefon");

            list.add(new Client(id,name,telefon));
        }
        return list;
    }

    @Override
    public void update(Client obj) throws SQLException {
        String update="UPDATE `company`.`client` SET `name` = ?, `telefon` = ? WHERE id = "+obj.getId();
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(update);

        preparedStatement.setString(1,obj.getName());
        preparedStatement.setLong(2,obj.getTelefon());

        preparedStatement.execute();
    }

    @Override
    public List<Client> getListPoId(Long id) {
        return null;
    }
}
