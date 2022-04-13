package me.Dex.ServiceMenu.DTO;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class ResultDTO extends RepairDTO{
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;
    private Float finalPrice;

}
