package me.Dex.ServiceMenu.Domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
@Data
public class ResultingDoc extends Resource{
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date returnDate;
    @Column
    protected Float finalPrice;

}
