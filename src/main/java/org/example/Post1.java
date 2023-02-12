package org.example;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Post1")
@Table(name = "post1")

public class Post1 {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    // 对比之前的写法，这里不再使用joinColumn,而是使用mappedBy
    // 并且在子类中定义了一个字段来表示外键关系
    @OneToMany(mappedBy = "post1", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostComment1> comments = new ArrayList<>();

    public void addComment(PostComment1 postComment1) {
        comments.add(postComment1);
        postComment1.setPost1(this);
    }

    public void removeComment(PostComment1 postComment1) {
        comments.remove(postComment1);
        postComment1.setPost1(null);
        // 两点觉得很神奇，
        // 1> 删除一条子条目的时候，需要先把子条目外键置为null?
        // 2> 好像在执行完removeComment以后，表就变了？这里就不用再session.persist(comments)来保存改变后的comments了
    }

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

    public List<PostComment1> getComments() {
        return comments;
    }

    public void setComments(List<PostComment1> comments) {
        this.comments = comments;
    }
}
