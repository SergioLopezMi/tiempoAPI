package com.sergiolopezmi.apitiempo.pojos;

import com.sergiolopezmi.apitiempo.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
public class UserPojo extends User {
    private UUID id;
    private String name;
    private String password;
    private UUID role;
}
