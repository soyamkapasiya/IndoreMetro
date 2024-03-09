package com.kapasiya.indoremetro.repository;

import com.kapasiya.indoremetro.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer>
{
    Role findByRole(String name);
}
