package me.Dex.ServiceMenu.Service;

import me.Dex.ServiceMenu.Domain.AdmissionDoc;
import me.Dex.ServiceMenu.Repository.AdmissionDocRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class AdmissionDocService extends AbstractService<AdmissionDoc, AdmissionDocRepository> {
    public AdmissionDoc create(AdmissionDoc entity) {
        entity.setAdmissionDate(new Date());
        return super.create(entity);
    }

    public AdmissionDocService(AdmissionDocRepository repository) {
        super(repository);
    }

    public List<AdmissionDoc> getAllActive() {
        return repository.getAllActive();
    }

    public List<AdmissionDoc> getAllArchived() {
        return repository.getAllArchived();
    }

    public void setArchive(Long id, boolean state) {
        repository.setArchive(id, state);
    }

}
