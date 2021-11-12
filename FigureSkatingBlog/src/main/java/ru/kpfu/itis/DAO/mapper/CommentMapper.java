package ru.kpfu.itis.DAO.mapper;

import ru.kpfu.itis.entities.CommentForArticle;
import ru.kpfu.itis.entities.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper extends AbstractMapper<CommentForArticle> {
    private final boolean hasAccountData;

    public CommentMapper(boolean hasAccountData) {
        super();
        this.hasAccountData = hasAccountData;
    }

    @Override
    public CommentForArticle handleItem(ResultSet rs) throws SQLException {
        CommentForArticle comment = convert.toBean(rs, CommentForArticle.class);
        comment.setIdArticle(rs.getLong("id_article"));
        if (hasAccountData) {
            UserEntity account = convert.toBean(rs, UserEntity.class);
            account.setId(rs.getLong("id_user"));
            comment.setAccount(account);
        }
        return comment;
    }
}
