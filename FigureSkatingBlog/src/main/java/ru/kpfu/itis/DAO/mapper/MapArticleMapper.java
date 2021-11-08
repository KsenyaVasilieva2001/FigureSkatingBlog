package ru.kpfu.itis.DAO.mapper;

import ru.kpfu.itis.entities.ArticleEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapArticleMapper extends AbstractMapper<ArticleEntity> {
    @Override
    public ArticleEntity handleItem(ResultSet rs) throws SQLException {
        ArticleEntity a = convert.toBean(rs, ArticleEntity.class);
        a.setIdCategory(rs.getInt("id_category"));
        a.setVideoUrl(rs.getString("video_url"));
        a.setIdCoach(rs.getInt("id_coach"));
        return a;
    }
}
