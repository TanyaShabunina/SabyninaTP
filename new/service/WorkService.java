package service;

import domain.Work;
import repository.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class WorkService implements Service<Work>{

    private final Repository<Work> repository;

    public WorkService(Repository<Work> repository) {
        this.repository = repository;
    }

    @Override
    public Work getById(Long id) throws SQLException {
        return repository.find(id);
    }

    @Override
    public List<Work> getAll() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(Work obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(Work obj) throws SQLException {
        repository.update(obj);
    }

    @Override
    public void delete(Work target) throws SQLException {
        repository.delete(target);
    }

    @Override
    public List<Work> getListPoId(Long id) {
        return null;
    }
}
