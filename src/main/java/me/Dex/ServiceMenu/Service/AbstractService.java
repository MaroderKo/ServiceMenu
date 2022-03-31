package me.Dex.ServiceMenu.Service;

import me.Dex.ServiceMenu.Domain.AdmissionDoc;
import me.Dex.ServiceMenu.Domain.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public class AbstractService<E extends Resource,R extends JpaRepository<E, Long>> {
    protected R repository;

    public AbstractService(R repository) {
        this.repository = repository;
    }

    public E create(E entity)
    {
        if (entity instanceof AdmissionDoc)
        {
            ((AdmissionDoc) entity).setAdmissionDate(LocalDateTime.now());
        }
        repository.save(entity);
        return repository.findById(entity.getId()).orElse(null);
    }
    public E read(Long id)
    {
        return repository.findById(id).orElse(null);
    }
    public List<E> readAll()
    {
        return repository.findAll();
    }
    public E update(E e)
    {
        return repository.save(e);
    }
}
