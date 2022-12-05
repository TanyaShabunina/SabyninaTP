package service;

import domain.Accounting;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class AccountingService implements Service<Accounting>{
    private final Repository<Accounting> repository;

    public AccountingService(Repository<Accounting> repository) {
        this.repository = repository;
    }

    @Override
    public Accounting getById(Long id) throws SQLException {
        return repository.find(id);
    }

    @Override
    public List<Accounting> getAll() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(Accounting obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(Accounting obj) throws SQLException {
        repository.update(obj);
    }

    @Override
    public void delete(Accounting target) throws SQLException {
        repository.delete(target);
    }

    @Override
    public List<Accounting> getListPoId(Long id) {
        return null;
    }

}
