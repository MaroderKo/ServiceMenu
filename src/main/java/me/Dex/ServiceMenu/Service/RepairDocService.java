package me.Dex.ServiceMenu.Service;

import me.Dex.ServiceMenu.Domain.RepairDoc;
import me.Dex.ServiceMenu.Repository.RepairDocRepository;
import org.springframework.stereotype.Service;

@Service
public class RepairDocService extends AbstractService<RepairDoc, RepairDocRepository>{
    public RepairDocService(RepairDocRepository repository) {
        super(repository);
    }
}
