package ru.kpfu.itis.DAO;



import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.postgresql.core.ResultHandler;
import ru.kpfu.itis.DAO.mapper.*;
import ru.kpfu.itis.entities.*;
import ru.kpfu.itis.forms.CommentForm;


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
        return sql.query(c, "select c.*, a.login, a.email, a.created_at as accountCreated, a.avatar from "
                        + "comment_article c, user_ a where a.id=c.id_user and c.id_article=? order by c.id desc  limit ? offset ?",
                new ListMapper<>(new CommentMapper(true)), idArticle, limit, offset);
    }
    public UserEntity createNewUser(Connection c, String login, String email, String hashpassword) throws SQLException {
        return sql.insert(c,"insert into user_ (id,login,email,hash_password) values(nextval('user__id_seq'),?,?,?)", new UserMapper(),
                login,email,hashpassword);
    }
    public Map<Long,UserEntity> getAllUsersDesc(Connection c) throws SQLException {
        return sql.query(c,"SELECT * FROM user_ ORDER BY created_at DESC LIMIT 1", new UserIdMapper());
    }
    public UserEntity getByEmail(Connection c, String email) throws SQLException {
        return sql.query(c,"select * from user_ u where u.email=?", new UserMapper(),email);
    }
    public UserEntity getByLogin(Connection c, String login) throws SQLException {
        return sql.query(c,"select * from user_ u where u.login=?", new UserMapper(),login);
    }
    public void addUUID(Connection c, UserEntity user, UUID uuid) throws SQLException {
        sql.insert(c,"insert into user_uuid (user_id, uuid) values (?, ?)", new ScalarHandler<Integer>(),user.getId() , uuid);
    }
    public void subscribe(Connection c, String username, String phone_number) throws SQLException {
        sql.insert(c,"insert into  subscription(student_name, phone_number) values (?, ?)", new SubscriptionMapper(), username, phone_number);
    }
    public UserEntity getUserByUUID(Connection c, UUID uuid) throws SQLException {
        return sql.query(c,"select u.id AS id, login, email, hash_password  from (user_ u join user_uuid uu on (u.id = uu.user_id and uu.uuid = ?))", new UserMapper(), uuid);
    }
    public void removeUUID(Connection c, UUID uuid) throws SQLException {
        sql.update(c,"delete from user_uuid uu where uu.uuid=?",uuid);
    }
    public void removeAllUUID(Connection c, UserEntity user) throws SQLException {
        sql.update(c,"delete from user_uuid uu where uu.user_id = ?", user.getId());
    }
    public CommentForArticle createComment(Connection c, CommentForm form, long idUser) throws SQLException {
        return sql.insert(c, "insert into comment_article (id_article,id_user,content) values(?,?,?)",
                new CommentMapper(false), form.getIdArticle(), idUser, form.getContent());
    }

    public ArticleEntity findArticleForNewCommentNotification(Connection c, long id) throws SQLException {
        return sql.query(c, "select a.id, a.id_category, a.url, a.title from article a where a.id = ?", new MapArticleMapper(), id);
    }

    public int countComments(Connection c, long id) throws SQLException {
        return sql.query(c, "select count(*) from comment_article where id_article=?", new ScalarHandler<Number>(), id).intValue();
    }

    public void updateArticleComments(Connection c, ArticleEntity article) throws SQLException {
        sql.update(c, "update article set comments=? where id=?", article.getComments(), article.getId());
    }
    public void updateProfile(Connection c, Long user_id, String first_name, String last_name) throws SQLException {
        sql.update(c, "update user_ set first_name = ?, last_name = ?  where id = ?", first_name, last_name, user_id);
    }

}