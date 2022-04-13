package me.Dex.ServiceMenu.Domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@Data
public class AdmissionDoc extends Resource{
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date admissionDate;
    @Column
    protected String manufacturer;
    @Column
    protected String model;
    @Column
    protected String serialNumber;
    @Column
    protected String clientDescription;
    @Column
    protected String additionalItems;
    @Column
    protected String clientFIO;
    @Column
    protected String contactNumber;
    @Column(name = "archived")
    protected boolean isArchived = false;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "repair_id")
    RepairDoc repairDoc = new RepairDoc();
}
