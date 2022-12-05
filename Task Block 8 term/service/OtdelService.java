package service;

import domain.Otdel;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class OtdelService implements Service<Otdel>{
    private final Repository<Otdel> repository;

    public OtdelService(Repository<Otdel> repository) {
        this.repository = repository;
    }

    @Override
    public Otdel getById(Long id) throws SQLException {
        return repository.find(id);
    }

    @Override
    public List<Otdel> getAll() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(Otdel obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(Otdel obj) throws SQLException {
        repository.update(obj);
    }

    @Override
    public void delete(Otdel target) throws SQLException {
        repository.delete(target);
    }

    @Override
    public List<Otdel> getListPoId(Long id) {
        return null;
    }
}
