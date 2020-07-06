package com.sergiolopezmi.apitiempo.pojos;

import com.sergiolopezmi.apitiempo.entities.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
public class RolePojo extends Role {
    private UUID id;
    private String roleName;
}
