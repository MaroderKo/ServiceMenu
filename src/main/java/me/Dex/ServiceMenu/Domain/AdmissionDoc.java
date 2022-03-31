package me.Dex.ServiceMenu.Domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@Data
public class AdmissionDoc extends Resource{
    @Column
    LocalDateTime admissionDate;
    @Column
    String manufacturer;
    @Column
    String model;
    @Column
    String serialNumber;
    @Column
    String clientDescription;
    @Column
    String additionalItems;
    @Column
    String clientFIO;
    @Column
    String contactNumber;
    @Column(name = "archived")
    boolean isArchived = false;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "repair_id")
    RepairDoc repairDoc = new RepairDoc();


    //RepairDoc repairDoc;
}
