package ru.kpfu.itis.DAO.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.RowProcessor;
import ru.kpfu.itis.entities.CategoryEntity;


public class MapCategoryMapper implements ResultSetHandler<Map<Integer, CategoryEntity>> {
    private RowProcessor convert = new BasicRowProcessor();

    @Override
    public  Map<Integer, CategoryEntity> handle(ResultSet rs) throws SQLException {
        Map<Integer, CategoryEntity> map = new HashMap<>();
        while (rs.next()) {
            CategoryEntity category = convert.toBean(rs, CategoryEntity.class);
            map.put(category.getId(), category);
        }
        return map;
    }
}