package me.Dex.ServiceMenu.Domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class RepairDoc extends Resource{
    @Column
    protected String repairResult;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date repairDate;
    @Column
    protected String masterFIO;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "resulting_id")
    ResultingDoc resultingDoc = new ResultingDoc();
}
