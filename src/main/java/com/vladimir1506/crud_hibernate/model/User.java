package com.vladimir1506.crud_hibernate.model;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "firstname")
    String firstName;
    @Column(name = "lastname")
    String lastName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Post> posts;
    @ManyToOne
    Region region;
    @Enumerated(EnumType.STRING)
    Role role;

    public User() {
    }

    public User(String firstName, String lastName, Region region, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.region = region;
        this.role = role;
    }


    public Role getRole() {
        return role;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String toString() {
        String writePosts = null;
        String regionName = null;
        List<Long> posts;
        if (this.posts != null) {
            posts = this.posts.stream().map(Post::getId).collect(Collectors.toList());
            writePosts = posts.toString().replaceAll(" ", "");
        }
        if (this.region != null) {
            regionName = region.getName();
        }
        return "\n" + id + ". " + firstName + ", " + lastName + ", " + writePosts + ", " + regionName + ", " + role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
