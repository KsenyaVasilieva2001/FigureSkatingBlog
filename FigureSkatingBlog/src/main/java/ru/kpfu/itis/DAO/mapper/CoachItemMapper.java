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

public class CoachItemMapper extends AbstractMapper<CoachEntity>{
    private RowProcessor convert = new BasicRowProcessor();


    @Override
    public CoachEntity handleItem(ResultSet rs) throws SQLException {
        CoachEntity a = convert.toBean(rs, CoachEntity.class);
        a.setCreatedAt(rs.getTimestamp("created_at"));
        a.setPhotoUrl(rs.getString("photo_url"));
        a.setIdSpeciality(rs.getInt("id_speciality"));
        return a;
    }
}