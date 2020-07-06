package com.sergiolopezmi.apitiempo.repositories;

import com.sergiolopezmi.apitiempo.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
}
