package org.example;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Post")
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String title;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    // 假如只是写了OneToMany,但是在子实例里面没有写ManyToOne,此时就会形成一个中间表
    // 此时被称为单向 Unidirectional
    // 为了解决这问题，需要写上这个JoinColumn注解，但是需要注意的是
    // 此时在子实例的表里多出来一列（名为post_id）来对应这个外键关系
    // 在父实例里面定义子实例的表的某一列，属实让我难以接受
    // 引用文章中的一段话：
    // The @JoinColumn annotation helps Hibernate (the most famous JPA provider) to figure out that there is a post_id Foreign Key column in the post_comment table that defines this association.
    // 问题是，这是怎么知道在哪个表里添加这么一列的呢？
    // 注解这么强大的嘛？
    @JoinColumn(name = "post_id")
    private List<PostComment> comments = new ArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PostComment> getComments() {
        return comments;
    }

    public void setComments(List<PostComment> comments) {
        this.comments = comments;
    }
}
