package service;

import domain.Tovar;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class TovarService implements Service<Tovar>{
    private final Repository<Tovar> repository;

    public TovarService(Repository<Tovar> repository) {
        this.repository = repository;
    }

    @Override
    public Tovar getById(Long id) throws SQLException {
        return repository.find(id);
    }

    @Override
    public List<Tovar> getAll() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(Tovar obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(Tovar obj) throws SQLException {
        repository.update(obj);
    }

    @Override
    public void delete(Tovar target) throws SQLException {
        repository.delete(target);
    }

    @Override
    public List<Tovar> getListPoId(Long id) {
        return null;
    }
}
