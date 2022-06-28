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
@Table(name="SERVICE_PRIVILEGES")
public class Privilege {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="SERVICE_PRIVILEGES_ID")
    private Long id;

    @NotNull
    @Column(name="SERVICE_PRIVILEGES_NAME")
    private String name;

    @Column(name = "SERVICE_PRIVILEGE_DELETED")
    private boolean deleted = false;
}