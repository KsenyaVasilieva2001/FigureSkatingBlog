package ru.kpfu.itis.DAO.mapper;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.RowProcessor;
import ru.kpfu.itis.entities.CategoryEntity;
import ru.kpfu.itis.entities.SpecialityEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MapSpecialityMapper implements ResultSetHandler<Map<Integer, SpecialityEntity>> {
    private RowProcessor convert = new BasicRowProcessor();

    @Override
    public  Map<Integer, SpecialityEntity> handle(ResultSet rs) throws SQLException {
        Map<Integer, SpecialityEntity> map = new HashMap<>();
        while (rs.next()) {
            SpecialityEntity speciality = convert.toBean(rs, SpecialityEntity.class);
            map.put(speciality.getId(), speciality);
        }
        return map;
    }
}