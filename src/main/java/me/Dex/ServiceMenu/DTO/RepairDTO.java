package me.Dex.ServiceMenu.DTO;

import lombok.Data;
import me.Dex.ServiceMenu.Domain.RepairDoc;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
public class RepairDTO extends RepairDoc {
    /*@Autowired
    RepairDocService repairDocService;

    @Autowired
    AdmissionDocService admissionDocService;*/

    LocalDateTime admissionDate;
    String manufacturer;
    String model;
    String serialNumber;
    String clientDescription;
    String additionalItems;
    String clientFIO;
    String contactNumber;



    /*public RepairDTO(Long id) {
        this.setId(id);
        AdmissionDoc admissionDoc = admissionDocService.read(id);
        this.admissionDate = admissionDoc.getAdmissionDate();
        this.manufacturer = admissionDoc.getManufacturer();
        this.model = admissionDoc.getModel();
        this.serialNumber = admissionDoc.getSerialNumber();
        this.clientDescription = admissionDoc.getClientDescription();
        this.additionalItems = admissionDoc.getAdditionalItems();
        this.clientFIO = admissionDoc.getClientFIO();
        this.contactNumber = admissionDoc.getContactNumber();

        this.RepairResult = admissionDoc.getRepairDoc().getRepairResult();
        this.completedWorks = admissionDoc.getRepairDoc().getCompletedWorks();
        this.repairDate = admissionDoc.getRepairDoc().getRepairDate();
        this.masterFIO = admissionDoc.getRepairDoc().getMasterFIO();
        this.repairPrice = admissionDoc.getRepairDoc().getRepairPrice();
    }*/

    public RepairDoc simplify() {
        RepairDoc doc = new RepairDoc();
        doc.setId(this.getId());
        doc.setRepairResult(this.repairResult);
        doc.setCompletedWorks(this.completedWorks);
        doc.setRepairDate(this.repairDate);
        doc.setMasterFIO(this.masterFIO);
        doc.setRepairPrice(this.repairPrice);
        return doc;
    }
}
