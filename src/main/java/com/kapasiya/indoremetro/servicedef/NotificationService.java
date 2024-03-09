package com.kapasiya.indoremetro.servicedef;

import com.kapasiya.indoremetro.entity.Notifications;

import java.util.List;
import java.util.Optional;

public interface NotificationService
{
    public List<Notifications> getAllNotifications();

    public void addNotifications(Notifications products);

    public void deleteNotificationsByID(int id);

    public Optional<Notifications> findNotificationsById(int id);
}
