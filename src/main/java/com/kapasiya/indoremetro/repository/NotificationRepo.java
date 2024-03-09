package com.kapasiya.indoremetro.repository;

import com.kapasiya.indoremetro.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<Notifications,Integer> {
}
