package me.Dex.ServiceMenu.Domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Data
public class ResultingDoc extends Resource{
    @Column
    String clientFIO;
    @Column
    String clientContactNumber;
    @Column
    LocalDateTime admissionDate;
    @Column
    LocalDateTime returnDate;
    @Column
    Float finalPrice;

}
