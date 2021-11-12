package ru.kpfu.itis.DAO.mapper;


import ru.kpfu.itis.entities.SubscriptionEntity;
import ru.kpfu.itis.entities.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubscriptionMapper extends AbstractMapper<SubscriptionEntity>{


    @Override
    public SubscriptionEntity handleItem(ResultSet rs) throws SQLException {
        SubscriptionEntity a = convert.toBean(rs, SubscriptionEntity.class);;
        a.setStudentName(rs.getString("student_name"));
        a.setPhoneNumber(rs.getString("phone_number"));
        return a;
    }

}