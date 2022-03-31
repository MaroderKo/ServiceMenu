package me.Dex.ServiceMenu.Factory;

import me.Dex.ServiceMenu.DTO.RepairDTO;
import me.Dex.ServiceMenu.Domain.AdmissionDoc;
import me.Dex.ServiceMenu.Service.AdmissionDocService;
import me.Dex.ServiceMenu.Service.RepairDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepairDTOFactory {
    @Autowired
    RepairDocService repairDocService;

    @Autowired
    AdmissionDocService admissionDocService;

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

        dto.setId(admissionDoc.getRepairDoc().getId());
        dto.setRepairResult(admissionDoc.getRepairDoc().getRepairResult());
        dto.setCompletedWorks(admissionDoc.getRepairDoc().getCompletedWorks());
        dto.setRepairDate(admissionDoc.getRepairDoc().getRepairDate());
        dto.setMasterFIO(admissionDoc.getRepairDoc().getMasterFIO());
        dto.setRepairPrice(admissionDoc.getRepairDoc().getRepairPrice());

        return dto;
    }
}
