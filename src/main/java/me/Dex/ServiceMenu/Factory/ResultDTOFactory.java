package me.Dex.ServiceMenu.Factory;

import me.Dex.ServiceMenu.DTO.RepairDTO;
import me.Dex.ServiceMenu.DTO.ResultDTO;
import me.Dex.ServiceMenu.Domain.AdmissionDoc;
import me.Dex.ServiceMenu.Domain.ResultingDoc;
import me.Dex.ServiceMenu.Service.AdmissionDocService;
import me.Dex.ServiceMenu.Service.RepairDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class ResultDTOFactory {
    @Autowired
    RepairDocService repairDocService;

    @Autowired
    AdmissionDocService admissionDocService;

    public ResultDTO getById(Long id)
    {
        ResultDTO dto = new ResultDTO();
        AdmissionDoc admissionDoc = admissionDocService.read(id);
        dto.setAdmissionDate(admissionDoc.getAdmissionDate());
        dto.setManufacturer(admissionDoc.getManufacturer());
        dto.setModel(admissionDoc.getModel());
        dto.setSerialNumber(admissionDoc.getSerialNumber());
        dto.setClientDescription(admissionDoc.getClientDescription());
        dto.setAdditionalItems(admissionDoc.getAdditionalItems());
        dto.setClientFIO(admissionDoc.getClientFIO());
        dto.setContactNumber(admissionDoc.getContactNumber());
        dto.setArchived(admissionDoc.isArchived());

        dto.setRepairResult(admissionDoc.getRepairDoc().getRepairResult());
        dto.setRepairDate(admissionDoc.getRepairDoc().getRepairDate());
        dto.setMasterFIO(admissionDoc.getRepairDoc().getMasterFIO());

        dto.setId(admissionDoc.getRepairDoc().getResultingDoc().getId());
        dto.setReturnDate(admissionDoc.getRepairDoc().getResultingDoc().getReturnDate());
        dto.setFinalPrice(admissionDoc.getRepairDoc().getResultingDoc().getFinalPrice());

        return dto;
    }

    public ResultingDoc extract(ResultDTO dto)
    {
        ResultingDoc doc = admissionDocService.read(dto.getId()).getRepairDoc().getResultingDoc();
        doc.setReturnDate(dto.getReturnDate());
        doc.setFinalPrice(dto.getFinalPrice());

        return doc;
    }
}
