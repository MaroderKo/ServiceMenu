package me.Dex.ServiceMenu.DTO;

import lombok.Data;
import me.Dex.ServiceMenu.Domain.RepairDoc;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class RepairDTO extends RepairDoc {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date admissionDate;
    private String manufacturer;
    private String model;
    private String serialNumber;
    private String clientDescription;
    private String additionalItems;
    private String clientFIO;
    private String contactNumber;
    private boolean archived;

}
