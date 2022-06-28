package com.gtrofimiec.servicegroupreports.backend.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="MONTHLY_REPORT")
public class MonthlyReport {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="MONTHLY_REPORT_ID")
    private Long id;

    @NotNull
    @Column(name="MONTHLY_REPORT_DATE")
    private LocalDate date;

    @NotNull
    @Column(name="MONTHLY_REPORT_PUBLICATIONS")
    private Long publications;

    @NotNull
    @Column(name="MONTHLY_REPORT_FILMS")
    private Long films;

    @NotNull
    @Column(name="MONTHLY_REPORT_HOURS")
    private Long hours;

    @NotNull
    @Column(name="MONTHLY_REPORT_RETURN_VISITS")
    private Long returnVisits;

    @NotNull
    @Column(name="MONTHLY_REPORT_STUDIES")
    private Long studies;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "SERVICE_PRIVILEGES_ID")
    private Group group;

    @Column(name = "MONTHLY_REPORT_DELETED")
    private boolean deleted = false;
}