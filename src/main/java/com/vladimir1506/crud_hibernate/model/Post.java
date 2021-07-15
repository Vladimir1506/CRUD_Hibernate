package com.vladimir1506.crud_hibernate.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "content")
    private String content;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public Post() {
    }

    public Post(String content) {
        this.content = content;
        this.created = new Date();
        this.updated = created;
    }

    public String toString() {
        return "\n" + this.id + ". "
                + this.content
                + "\nДата создания: " + this.created
                + "\nДата изменения: " + this.updated +
                "\nBy "
                + user.getFirstName() + " "
                + user.getLastName();
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

