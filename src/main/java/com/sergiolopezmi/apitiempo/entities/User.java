package com.sergiolopezmi.apitiempo.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * <h1>Clase User</h1>
 *
 * <p>Contiene el regístro de los usuarios de la aplicación.</p>
 *</br>
 *<p>
 *  @author Sergio Lopez
 *  @version 1.0
 * </p>
 */

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode

@Entity
@Table(name = "Users")
public class User implements Serializable {

    private static final long serialVersionUID = 2709805526034450196L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NonNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private UUID role;
}
