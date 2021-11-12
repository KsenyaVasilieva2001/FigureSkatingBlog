package ru.kpfu.itis.DAO.mapper;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.RowProcessor;
import ru.kpfu.itis.entities.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserIdMapper implements ResultSetHandler<Map<Long, UserEntity>> {
    private RowProcessor convert = new BasicRowProcessor();

    @Override
    public Map<Long, UserEntity> handle(ResultSet rs) throws SQLException {
        Map<Long, UserEntity> map = new HashMap<>();
        while (rs.next()) {
            UserEntity user = convert.toBean(rs, UserEntity.class);
            map.put(user.getId(), user);
        }
        return map;
    }

}