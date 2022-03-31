package me.Dex.ServiceMenu.Service;

import me.Dex.ServiceMenu.Domain.AdmissionDoc;
import me.Dex.ServiceMenu.Repository.AdmissionDocRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdmissionDocService extends AbstractService<AdmissionDoc, AdmissionDocRepository>{
    public AdmissionDocService(AdmissionDocRepository repository) {
        super(repository);
    }

    public List<AdmissionDoc> getAllActive()
    {
        return repository.getAllActive();
    }

    public List<AdmissionDoc> getAllArchived()
    {
        return repository.getAllArchived();
    }

    public void setArchive(Long id, boolean state)
    {
        repository.setArchive(id,state);
    }

}
