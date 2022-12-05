package service;

import domain.Otdel;
import domain.Worker;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class WorkerService implements Service<Worker>{

    private final Repository<Worker> repository;

    public WorkerService(Repository<Worker> repository) {
        this.repository = repository;
    }

    @Override
    public Worker getById(Long id) throws SQLException {
        return repository.find(id);
    }

    @Override
    public List<Worker> getAll() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(Worker obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(Worker obj) throws SQLException {
        repository.update(obj);
    }

    @Override
    public void delete(Worker target) throws SQLException {
        repository.delete(target);
    }

    @Override
    public List<Worker> getListPoId(Long id) throws SQLException {
        return repository.getListPoId(id);
    }
}
