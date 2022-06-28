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
@Table(name="PUBLISHER_STATUS")
public class Status {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="PUBLISHER_STATUS_ID")
    private Long id;

    @NotNull
    @Column(name="PUBLISHER_STATUS_NAME")
    private String name;

    @Column(name = "PUBLISHER_STATUS_DELETED")
    private boolean deleted = false;
}