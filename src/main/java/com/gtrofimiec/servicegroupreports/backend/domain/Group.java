package com.gtrofimiec.servicegroupreports.backend.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="SERVICE_GROUP")
public class Group {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="SERVICE_GROUP_ID")
    private Long id;

    @NotNull
    @Column(name="SERVICE_GROUP_NAME")
    private String name;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = Publisher.class,
            mappedBy = "group",
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            })
    private List<Publisher> publishersList;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = MonthlyReport.class,
            mappedBy = "group",
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            })
    private List<MonthlyReport> monthlyReportsList;

    @Column(name = "SERVICE_GROUP_DELETED")
    private boolean deleted = false;
}