package com.kapasiya.indoremetro.repo;

import com.kapasiya.indoremetro.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData, String>
{

}
