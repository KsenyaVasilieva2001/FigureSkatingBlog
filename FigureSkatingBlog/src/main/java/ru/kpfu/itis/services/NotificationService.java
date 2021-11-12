package ru.kpfu.itis.services;

public interface NotificationService {
    void sendNotification(String title,String content);
    void shutdown();
}
