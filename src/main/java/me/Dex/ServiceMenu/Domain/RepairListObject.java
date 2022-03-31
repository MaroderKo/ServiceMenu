package me.Dex.ServiceMenu.Domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class RepairListObject extends Resource{

    @Column
    String objectName;

    @Column
    Long price;

    @ManyToOne
    @JoinColumn(name = "doc_id", nullable = false)
    private RepairDoc repairDoc;

}
