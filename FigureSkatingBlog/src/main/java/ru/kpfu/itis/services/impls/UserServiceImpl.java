package ru.kpfu.itis.services.impls;


import org.slf4j.Logger;
import ru.kpfu.itis.DAO.SQLDAO;
import ru.kpfu.itis.constants.Constants;
import ru.kpfu.itis.entities.UserEntity;
import ru.kpfu.itis.exceptions.*;
import ru.kpfu.itis.services.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserServiceImpl implements UserService {
    private final DataSource dataSource;
    private final SQLDAO sql;

    protected UserServiceImpl(ServiceManager serviceManager) {
        super();
        this.dataSource = serviceManager.dataSource;
        this.sql = new SQLDAO();
    }

    private Logger logger;
    @Override
    public UUID registration(String login, String email, String password, HttpSession session) {
        validateProfile(login, email);
        if(password.length() < 8) throw new WeakPasswordException("Password too short");
        String hash = getHashPassword(password);
        UUID uuid = UUID.randomUUID();

        UserEntity user = createNewUser(login,email,hash);
        //long id = Long.valueOf(-1);
        user.setId((Long) getAllUsersDesc().keySet().toArray()[0]);

        System.out.println(user);
        addUUID(user, uuid);
        session.setAttribute("user", user);
        return uuid;
    }

    @Override
    public Map<Long, UserEntity> getAllUsersDesc(){
        try (Connection c = dataSource.getConnection()){
            return sql.getAllUsersDesc(c);
        }
        catch (SQLException e){
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }

    @Override
    public UserEntity getUserByUUID(UUID uuid) {
        try (Connection c = dataSource.getConnection()){
            return sql.getUserByUUID(c,uuid);
        }
        catch (SQLException e) {
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }


    @Override
    public UUID authorize(String login, String password, HttpSession session) {
        UserEntity user = getByLogin(login);
        if(user == null) throw new NoSuchLoginException("No login " + login);
        if(getHashPassword(password).equals(user.getPassword())){
            UUID uuid = UUID.randomUUID();
            addUUID(user,uuid);
            session.setAttribute("user", user);
            session.setAttribute("auth","true");
            return uuid;
        }
        else throw new WrongPasswordException();
    }

    @Override
    public void addUUID(UserEntity user, UUID uuid){
        try (Connection c = dataSource.getConnection()){
            sql.addUUID(c,user,uuid);
            c.commit();
        }
        catch (SQLException e) {
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean isAuthenticated(HttpServletRequest request, HttpSession session) {
        if(session.getAttribute("user") != null){
            return true;
        }
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie c : cookies){
                if(c.getName().equals(Constants.AUTH_COOKIE_NAME)){
                    UserEntity user = getUserByUUID(UUID.fromString(c.getValue()));
                    if(user != null){
                        session.setAttribute("user", user);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void validateProfile(String login, String email) {
        Matcher m = Pattern.compile(Constants.EMAIL_REGEX).matcher(email);
        if(!m.matches()){
            throw new InvalidEmailException(email + " is not email");
        }
        if(getByEmail(email) != null){
            throw new OcupiedLoginException(email + " is occupied");
        }
        if(getByLogin(login) != null){
            throw new OcupiedLoginException(login + " is occupied");
        }
    }

    @Override
    public void logout(UUID uuid) {
        removeUUID(uuid);

    }

    @Override
    public void logout(HttpServletRequest req, HttpSession session) {
        Cookie[] cookies = req.getCookies();
        for(Cookie c : cookies){
            if(c.getName().equals(Constants.AUTH_COOKIE_NAME)){
                logout(UUID.fromString(c.getValue()));
            }
        }
        session.removeAttribute("user");
        session.setAttribute("auth",null);

    }

    @Override
    public void fullLogout(UserEntity user) {
        deleteAllUUIDS(user);
    }

    @Override
    public UserEntity getByEmail(String email){
        try (Connection c = dataSource.getConnection()){
            UserEntity user = sql.getByEmail(c,email);
            return user;
        }
        catch (SQLException e) {
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }
    @Override
    public UserEntity getByLogin(String login){
        try (Connection c = dataSource.getConnection()){
            UserEntity user = sql.getByLogin(c,login);
            return user;
        }
        catch (SQLException e) {
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }

    @Override
    public String getHashPassword(String password) {
        StringBuilder sb = new StringBuilder();
        for (char symbol : password.toCharArray()) {
            if (symbol != ' ') {
                symbol = (char) (symbol - 3);
            }
            sb.append(symbol);
        }
        return sb.toString();
    }

    @Override
    public UserEntity createNewUser(String login, String email, String hashpassword){
        try (Connection c = dataSource.getConnection()){
            UserEntity user = sql.createNewUser(c, login, email, hashpassword);
            c.commit();
            return user;
        }
        catch (SQLException e) {
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }


    @Override
    public void removeUUID(UUID uuid) {
        try (Connection c = dataSource.getConnection()){
            sql.removeUUID(c,uuid);
        }
        catch (SQLException e) {
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteAllUUIDS(UserEntity user) {

    }

    @Override
    public void validateSubscribeForm(String phoneNumber) {
        Matcher m = Pattern.compile(Constants.PHONE_NUMBER_REGEX).matcher(phoneNumber);
        if(!m.matches()){
            throw new InvalidPhoneNumberException(phoneNumber + " is not phone number");
        }
    }

    @Override
    public void subscribe(String userName, String phoneNumber) {
        try(Connection c = dataSource.getConnection()){
            validateSubscribeForm(phoneNumber);
            sql.subscribe(c,userName,phoneNumber);
            c.commit();

        }
        catch (SQLException e){
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }
    @Override
    public void updateProfile(UserEntity user,String first_name, String last_name) {
        try (Connection c = dataSource.getConnection()){

            sql.updateProfile(c, user.getId(), first_name, last_name);
            user.setFirst_name(first_name);
            user.setLast_name(last_name);
            c.commit();
        } catch (SQLException e) {
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }
}


