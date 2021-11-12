package ru.kpfu.itis.services.impls;

import ru.kpfu.itis.DAO.SQLDAO;
import ru.kpfu.itis.constants.Constants;
import ru.kpfu.itis.entities.*;
import ru.kpfu.itis.exceptions.*;
import ru.kpfu.itis.forms.CommentForm;
import ru.kpfu.itis.forms.ContactForm;
import ru.kpfu.itis.models.Items;
import ru.kpfu.itis.services.BusinessService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BusinessServiceImpl implements BusinessService {
    private final DataSource dataSource;
    private final SQLDAO sql;
    private String auth = null ;

    protected BusinessServiceImpl(ServiceManager serviceManager) {
        super();
        this.dataSource = serviceManager.dataSource;
        this.sql = new SQLDAO();
    }

    @Override
    public Map<Integer, CategoryEntity> mapCategories() {
        try (Connection c = dataSource.getConnection()) {
            return sql.mapCategories(c);
        } catch (SQLException e) {
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }

    @Override
    public Items<ArticleEntity> listArticles(int offset, int limit) {
        try (Connection c = dataSource.getConnection()) {
            Items<ArticleEntity> items = new Items<>();
            items.setItems(sql.listArticles(c, offset, limit));
            items.setCount(sql.countArticles(c));
            return items;
        } catch (SQLException e) {
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }

    @Override
    public Items<CoachEntity> listCoaches(int offset, int limit) {
        try (Connection c = dataSource.getConnection()) {
            Items<CoachEntity> itemsCoach = new Items<>();
            itemsCoach.setItems(sql.listCoaches(c, offset, limit));
            itemsCoach.setCount(sql.countCoaches(c));
            return itemsCoach;
        } catch (SQLException e) {
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }

    @Override
    public Map<Integer, SpecialityEntity> mapSpeciality() {
        try (Connection c = dataSource.getConnection()) {
            return sql.mapSpeciality(c);
        } catch (SQLException e) {
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }

    @Override
    public Map<Integer, CoachEntity> mapCoaches() {
        try (Connection c = dataSource.getConnection()) {
            return sql.mapCoaches(c);
        } catch (SQLException e) {
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }

    @Override
    public Items<ArticleEntity> listArticlesByCategory(String categoryUrl, int offset, int limit) {
        try (Connection c = dataSource.getConnection()) {
            Items<ArticleEntity> items = new Items<>();
            items.setItems(sql.listArticlesByCategory(c, categoryUrl, offset, limit));
            items.setCount(sql.countArticlesByCategory(c, categoryUrl));
            return items;
        } catch (SQLException e) {
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }

    @Override
    public CategoryEntity findCategoryByUrl(String categoryUrl) {
        try (Connection c = dataSource.getConnection()) {
            return sql.findCategoryByUrl(c, categoryUrl);
        } catch (SQLException e) {
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }

    @Override
    public Items<ArticleEntity> listArticlesBySearchQuery(String searchQuery, int offset, int limit) {
        try (Connection c = dataSource.getConnection()) {
            Items<ArticleEntity> items = new Items<>();
            items.setItems(sql.listArticlesBySearchQuery(c, searchQuery, offset, limit));
            items.setCount(sql.countArticlesBySearchQuery(c, searchQuery));
            return items;
        } catch (SQLException e) {
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }

    @Override
    public Items<CoachEntity> listCoachesBySearchQuery(String searchQuery, int offset, int limit) {
        try (Connection c = dataSource.getConnection()) {
            Items<CoachEntity> items = new Items<>();
            items.setItems(sql.listCoachesBySearchQuery(c, searchQuery, offset, limit));
            items.setCount(sql.countCoachesBySearchQuery(c, searchQuery));
            return items;
        } catch (SQLException e) {
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }

    @Override
    public CoachEntity findCoachByUrl(String coachUrl) {
        try (Connection c = dataSource.getConnection()) {
            CoachEntity coach =  sql.findCoachByUrl(c, coachUrl);
            return coach;
        } catch (SQLException e) {
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }

    @Override
    public Items<CoachEntity> listCoachesByCategory(String coachesUrl) {
        try (Connection c = dataSource.getConnection()) {
            Items<CoachEntity> items = new Items<>();
            items.setItems(sql.listCoachesByCategory(c, coachesUrl));
            return items;
        } catch (SQLException e) {
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }

    @Override
    public ArticleEntity viewArticle(String articleUrl, String requestUrl){
        try (Connection c = dataSource.getConnection()) {
            ArticleEntity article = sql.findArticleByUrl(c, articleUrl);
            if (article == null) {
                return null;
            } else {
                article.setViews(article.getViews() + 1);
                sql.updateArticleViews(c, article);
                c.commit();
                return article;
            }
        } catch (SQLException e) {
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }

    @Override
    public List<CommentForArticle> listCommentsArticle(Long idArticle, int offset, int limit) {
        try (Connection c = dataSource.getConnection()) {
            return sql.listComments(c, idArticle, offset, limit);
        } catch (SQLException e) {
            throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
        }
    }

    @Override
    public void createContactRequest(ContactForm form) throws ValidateException {

    }

    @Override
    public CommentForArticle createComment(CommentForm form, UserEntity user){
        try (Connection c = dataSource.getConnection()) {
            CommentForArticle comment = sql.createComment(c, form, user.getId());
            comment.setAccount(user);
            ArticleEntity article = sql.findArticleForNewCommentNotification(c, form.getIdArticle());
            article.setComments(sql.countComments(c, article.getId()));
            sql.updateArticleComments(c, article);
            c.commit();
            return comment;
        } catch (SQLException | RuntimeException e) {
            throw new ApplicationException("Can't create new comment: " + e.getMessage(), e);
        }
    }
}
