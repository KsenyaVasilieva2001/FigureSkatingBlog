package ru.kpfu.itis.DAO;



import java.sql.*;
import java.util.List;
import java.util.Map;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import ru.kpfu.itis.DAO.mapper.*;
import ru.kpfu.itis.entities.*;


//методы для работы с базой данных
public final class SQLDAO {
    private final QueryRunner sql = new QueryRunner();

    public Map<Integer, CategoryEntity> mapCategories(Connection c) throws SQLException {
       /* MapCategoryMapper mp = new MapCategoryMapper();
        String sql = "select * from ?";
        PreparedStatement preparedStatement = c.prepareStatement(sql);
        preparedStatement.setString(1, "category");
        ResultSet result = preparedStatement.executeQuery();
        return mp.handle(result);

        */
        return sql.query(c, "select * from category", new MapCategoryMapper());
    }
    //по убыванию, так как хотим сортировать по дате создания статьи
    public List<ArticleEntity> listArticles(Connection c, int offset, int limit) throws SQLException {
        return sql.query(c, "select * from article a order by a.id desc limit ? offset ?", new ListMapper<>(new MapArticleMapper()), limit, offset);
    }
    public int countArticles(Connection c) throws SQLException {
        return sql.query(c, "select count(*) from article a", new ScalarHandler<Number>()).intValue();
    }

    public List<CoachEntity> listCoaches(Connection c, int offset, int limit) throws SQLException {
        return sql.query(c, "select * from coach a order by a.id limit ? offset ?", new ListMapper<>(new CoachItemMapper()), limit, offset);
    }
    public int countCoaches(Connection c) throws SQLException {
        return sql.query(c, "select count(*) from coach a", new ScalarHandler<Number>()).intValue();
    }

    public Map<Integer, SpecialityEntity> mapSpeciality(Connection c) throws SQLException {
        return sql.query(c, "select * from speciality", new MapSpecialityMapper());
    }
    public Map<Integer, CoachEntity> mapCoaches(Connection c) throws SQLException {
        return sql.query(c, "select * from coach", new MapCoachMapper());
    }

    public List<ArticleEntity> listArticlesByCategory(Connection c, String categoryUrl, int offset, int limit) throws SQLException {
        return sql.query(c, "select a.* from article a, category c where c.id=a.id_category and c.url=? order by a.id desc limit ? offset ?",
                new ListMapper<>(new MapArticleMapper()), categoryUrl, limit, offset);
    }

    public int countArticlesByCategory(Connection c, String categoryUrl) throws SQLException {
        return sql.query(c, "select count(a.id) from article a, category c where a.id_category=c.id and c.url=?", new ScalarHandler<Number>(), categoryUrl).intValue();
    }
    public CategoryEntity findCategoryByUrl(Connection c, String categoryUrl) throws SQLException {
        return sql.query(c, "select * from category c where c.url = ?", new BeanHandler<>(CategoryEntity.class), categoryUrl);
    }
    public CoachEntity findCoachByUrl(Connection c, String coachUrl) throws SQLException {
        return sql.query(c, "select * from coach c where c.url = ?", new CoachItemMapper(), coachUrl);
    }
    public List<CoachEntity> listCoachesByCategory(Connection c, String coachUrl) throws SQLException {
        return sql.query(c, "select a.* from coach a where a.url=?",
                new ListMapper<>(new CoachItemMapper()), coachUrl);
    }

    public List<ArticleEntity> listArticlesBySearchQuery(Connection c, String searchQuery, int offset, int limit) throws SQLException {
        String q = "%" + searchQuery + "%";
        return sql.query(c, "select * from article a where (a.title ilike ? or a.content ilike ?) order by a.id desc limit ? offset ?",
                new ListMapper<>(new MapArticleMapper()), q, q, limit, offset);
    }

    public int countArticlesBySearchQuery(Connection c, String searchQuery) throws SQLException {
        String q = "%" + searchQuery + "%"; //% чтобы расширить результаты поиска
        return new QueryRunner().query(c, "select count(a.id) from article a where (a.title ilike ? or a.content ilike ?)",
                new ScalarHandler<Number>(), q, q).intValue();
    }

    public List<CoachEntity> listCoachesBySearchQuery(Connection c, String searchQuery, int offset, int limit) throws SQLException {
        String q = "%" + searchQuery + "%";
        return sql.query(c, "select * from coach a where (a.name ilike ? or a.content ilike ?) order by a.id desc limit ? offset ?",
                new ListMapper<>(new CoachItemMapper()), q, q, limit, offset);
    }

    public int countCoachesBySearchQuery(Connection c, String searchQuery) throws SQLException {
        String q = "%" + searchQuery + "%"; //% чтобы расширить результаты поиска
        return new QueryRunner().query(c, "select count(a.id) from coach a where (a.name ilike ? or a.content ilike ?)",
                new ScalarHandler<Number>(), q, q).intValue();
    }

    public ArticleEntity findArticleById(Connection c, long idArticle) throws SQLException {
        return sql.query(c, "select * from article a where a.id = ?", new MapArticleMapper(), idArticle);
    }
    public ArticleEntity findArticleByUrl(Connection c, String articleUrl) throws SQLException {
        return sql.query(c, "select * from article a where a.url = ?", new MapArticleMapper(), articleUrl);
    }
    public void updateArticleViews(Connection c, ArticleEntity article) throws SQLException {
        sql.update(c, "update article set views=? where id=?", article.getViews(), article.getId());
    }

    public List<CommentForArticle> listComments(Connection c, long idArticle, int offset, int limit) throws SQLException {
        return sql.query(c, "select c.*, a.name, a.email, a.created as accountCreated, a.avatar from "
                        + "comment c_article, account a where a.id=c.id_account and c.id_article=? order by c.id desc limit ? offset ?",
                new ListMapper<>(new CommentMapper(true)), idArticle, limit, offset);
    }
}