package ru.kpfu.itis.entities;

import java.sql.Timestamp;
import java.util.Objects;


public class CommentForArticle extends AbstractEntity<Long> {
    private static final long serialVersionUID = 4680060138840681511L;
    private Long idArticle;
    private UserEntity user;
    private String content;
    private Timestamp created;
    public CommentForArticle() {
        super();
    }
    public CommentForArticle(Long idArticle, UserEntity user, String content, Timestamp created) {
        super();
        this.idArticle = idArticle;
        this.user = user;
        this.content = content;
        this.created = created;
    }
    public Long getIdArticle() {
        return idArticle;
    }
    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }
    public UserEntity getAccount() {
        return user;
    }
    public void setAccount(UserEntity user) {
        this.user = user;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Timestamp getCreated() {
        return created;
    }
    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CommentForArticle that = (CommentForArticle) o;
        return Objects.equals(idArticle, that.idArticle) && Objects.equals(user, that.user) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idArticle, user, content);
    }
}