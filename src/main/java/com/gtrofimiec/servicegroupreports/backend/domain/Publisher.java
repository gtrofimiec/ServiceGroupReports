package com.gtrofimiec.servicegroupreports.backend.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="PUBLISHER")
public class Publisher {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="PUBLISHER_ID")
    private Long id;

    @NotNull
    @Column(name="PUBLISHER_NAME")
    private String name;

    @NotNull
    @Column(name="PUBLISHER_SURNAME")
    private String surname;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "SERVICE_GROUP_ID")
    private Group group;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "SERVICE_PRIVILEGE_ID")
    private Privilege privilege;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PUBLISHER_STATUS_ID")
    private Status status;

    @Column(name = "PUBLISHER_DELETED")
    private boolean deleted = false;
}