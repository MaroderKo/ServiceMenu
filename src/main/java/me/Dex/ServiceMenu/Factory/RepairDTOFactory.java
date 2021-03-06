package me.Dex.ServiceMenu.Factory;

import me.Dex.ServiceMenu.DTO.RepairDTO;
import me.Dex.ServiceMenu.Domain.AdmissionDoc;
import me.Dex.ServiceMenu.Domain.RepairDoc;
import me.Dex.ServiceMenu.Service.AdmissionDocService;
import me.Dex.ServiceMenu.Service.RepairDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepairDTOFactory {

    @Autowired
    private AdmissionDocService admissionDocService;

    public RepairDTO getById(Long id)
    {
        RepairDTO dto = new RepairDTO();
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

        dto.setId(admissionDoc.getRepairDoc().getId());
        dto.setRepairResult(admissionDoc.getRepairDoc().getRepairResult());
        dto.setRepairDate(admissionDoc.getRepairDoc().getRepairDate());
        dto.setMasterFIO(admissionDoc.getRepairDoc().getMasterFIO());

        return dto;
    }
    
    public RepairDoc extract(RepairDTO dto)
    {
        RepairDoc doc = admissionDocService.read(dto.getId()).getRepairDoc();
        doc.setRepairResult(dto.getRepairResult());
        doc.setRepairDate(dto.getRepairDate());
        doc.setMasterFIO(dto.getMasterFIO());
        return doc;
    }
}
