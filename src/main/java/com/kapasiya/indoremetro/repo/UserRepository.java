package com.kapasiya.indoremetro.repo;

import com.kapasiya.indoremetro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    // Additional custom queries can be added here if needed
}
