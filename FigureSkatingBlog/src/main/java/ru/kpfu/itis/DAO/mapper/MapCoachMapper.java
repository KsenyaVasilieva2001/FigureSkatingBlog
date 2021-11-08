package ru.kpfu.itis.DAO.mapper;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.RowProcessor;
import ru.kpfu.itis.entities.ArticleEntity;
import ru.kpfu.itis.entities.CoachEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MapCoachMapper implements ResultSetHandler<Map<Integer, CoachEntity>>  {
    private RowProcessor convert = new BasicRowProcessor();

    @Override
    public Map<Integer, CoachEntity> handle(ResultSet rs) throws SQLException {
        Map<Integer, CoachEntity> map = new HashMap<>();
        while (rs.next()) {
            CoachEntity coach = convert.toBean(rs, CoachEntity.class);
            map.put(coach.getId(),coach);
        }
        return map;
    }

}