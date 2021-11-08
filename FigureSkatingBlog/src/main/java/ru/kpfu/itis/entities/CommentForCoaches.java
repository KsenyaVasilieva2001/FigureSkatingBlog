package ru.kpfu.itis.entities;

import java.sql.Timestamp;
import java.util.Objects;


public class CommentForCoaches extends AbstractEntity<Long> {
    private static final long serialVersionUID = 4680060138840681511L;
    private Long idArticle;
    private UserEntity user;
    private String content;
    private Timestamp created;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CommentForCoaches that = (CommentForCoaches) o;
        return id_coach == that.id_coach && Objects.equals(idArticle, that.idArticle) && Objects.equals(user, that.user) && Objects.equals(content, that.content) && Objects.equals(created, that.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idArticle, user, content, created, id_coach);
    }

    public int getId_coach() {
        return id_coach;
    }

    public void setId_coach(int id_coach) {
        this.id_coach = id_coach;
    }

    private int id_coach;
    private int startsNumber;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }




    public int getStartsNumber() {
        return startsNumber;
    }

    public void setStartsNumber(int startsNumber) {
        this.startsNumber = startsNumber;
    }

    public CommentForCoaches() {
        super();
    }
    public CommentForCoaches(Long idArticle, UserEntity user, String content, Timestamp created) {
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

}