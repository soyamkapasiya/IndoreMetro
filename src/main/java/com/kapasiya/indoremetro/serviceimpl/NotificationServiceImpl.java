package com.kapasiya.indoremetro.serviceimpl;

import com.kapasiya.indoremetro.entity.Notifications;
import com.kapasiya.indoremetro.repository.NotificationRepo;
import com.kapasiya.indoremetro.servicedef.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService
{
    @Autowired
    NotificationRepo notificationRepo;

    @Override
    public List<Notifications> getAllNotifications()
    {
        return notificationRepo.findAll();
    }

    @Override
    public void addNotifications(Notifications products) {

    }

    @Override
    public void deleteNotificationsByID(int id) {

    }

    @Override
    public Optional<Notifications> findNotificationsById(int id) {
        return Optional.empty();
    }
}
