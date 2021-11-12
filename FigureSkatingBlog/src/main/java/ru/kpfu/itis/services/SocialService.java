package ru.kpfu.itis.services;

import ru.kpfu.itis.entities.UserEntity;
import ru.kpfu.itis.models.SocialAccount;

public interface SocialService {
    SocialAccount getSocialAccount(String authToken);
}


