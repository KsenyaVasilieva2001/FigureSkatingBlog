package ru.kpfu.itis.DAO.mapper;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.RowProcessor;
import ru.kpfu.itis.entities.CoachEntity;
import ru.kpfu.itis.entities.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper extends AbstractMapper<UserEntity>{


    @Override
    public UserEntity handleItem(ResultSet rs) throws SQLException {
        UserEntity a = convert.toBean(rs, UserEntity.class);
        a.setPassword(rs.getString("hash_password"));
        //a.setPhoneNumber(rs.getString("phone_number"));
        return a;
    }

}
