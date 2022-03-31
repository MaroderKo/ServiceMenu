package me.Dex.ServiceMenu.Service;

import me.Dex.ServiceMenu.Domain.ResultingDoc;
import me.Dex.ServiceMenu.Repository.ResultingDocRepository;
import org.springframework.stereotype.Service;

@Service
public class ResultingDocService extends AbstractService<ResultingDoc, ResultingDocRepository>{
    public ResultingDocService(ResultingDocRepository repository) {
        super(repository);
    }
}
