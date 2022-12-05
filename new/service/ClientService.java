package service;

import domain.Client;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class ClientService implements Service<Client> {

    private  final Repository<Client> repository;

    public ClientService(Repository<Client> repository) {
        this.repository = repository;
    }

    @Override
    public Client getById(Long id) throws SQLException {
        return repository.find(id);
    }

    @Override
    public List<Client> getAll() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(Client obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(Client obj) throws SQLException {
        repository.update(obj);
    }

    @Override
    public void delete(Client target) throws SQLException {
        repository.delete(target);
    }

    @Override
    public List<Client> getListPoId(Long id) {
        return null;
    }
}
