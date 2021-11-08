package ru.kpfu.itis.services;

import ru.kpfu.itis.entities.*;
import ru.kpfu.itis.exceptions.RedirectToValidUrlException;
import ru.kpfu.itis.models.Items;

import java.util.List;
import java.util.Map;

public interface BusinessService {
    Map<Integer, CategoryEntity> mapCategories();
    Items<ArticleEntity> listArticles(int offset, int limit);
    Items<CoachEntity> listCoaches(int offset, int limit);
    Map<Integer, SpecialityEntity> mapSpeciality();
    Map<Integer, CoachEntity> mapCoaches();
    Items<ArticleEntity> listArticlesByCategory(String categoryUrl, int offset, int limit);
    CategoryEntity findCategoryByUrl(String categoryUrl);
    //limit - сколько будем отображать на странице, будем по 3
    Items<ArticleEntity> listArticlesBySearchQuery(String searchQuery, int offset, int limit);
    Items<CoachEntity> listCoachesBySearchQuery(String searchQuery, int offset, int limit);
    CoachEntity findCoachByUrl(String coachUrl);
    Items<CoachEntity> listCoachesByCategory(String coachesUrl);
    ArticleEntity viewArticle(String articleUrl, String requestUrl);

    List<CommentForArticle> listCommentsArticle(Long idArticle, int offset, int limit);
}
