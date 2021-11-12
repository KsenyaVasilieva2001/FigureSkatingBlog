package ru.kpfu.itis.services;

import ru.kpfu.itis.entities.UserEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

public interface UserService {

    UUID registration(String login, String email, String password, HttpSession session);

    void removeUUID(UUID uuid);
    void deleteAllUUIDS(UserEntity user);

    UserEntity getUserByUUID(UUID uuid);

    UUID authorize(String login, String password, HttpSession session);

    boolean isAuthenticated(HttpServletRequest request, HttpSession session);

    void validateProfile(String login, String email);

    void logout(UUID uuid);

    void logout(HttpServletRequest req, HttpSession session);

    void fullLogout(UserEntity p);
    UserEntity getByEmail(String email);
    UserEntity getByLogin(String login);

    String getHashPassword(String password);
    UserEntity createNewUser(String login, String email, String hashpassword);
    Map<Long, UserEntity> getAllUsersDesc();
    void addUUID(UserEntity user, UUID uuid);
    void subscribe(String userName, String phoneNumber) throws SQLException;
    void validateSubscribeForm(String phoneNumber);
    void updateProfile(UserEntity user, String first_name, String last_name);
}
