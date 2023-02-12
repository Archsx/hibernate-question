package org.example;


import javax.persistence.*;
import java.util.Objects;

@Entity(name = "PostComment1")
@Table(name = "post_comment1")
public class PostComment1 {
    @Id
    @GeneratedValue
    private Long id;

    private String review;

    @ManyToOne(fetch = FetchType.LAZY)
    // 挺离谱的，此时表里有一列叫做post1_id来表示外键，我很疑惑这个名字到底是从哪里来的
    private Post1 post1;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostComment1 that = (PostComment1) o;
        return Objects.equals(id, that.id) && Objects.equals(review, that.review) && Objects.equals(post1, that.post1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, review, post1);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Post1 getPost1() {
        return post1;
    }

    public void setPost1(Post1 post1) {
        this.post1 = post1;
    }

    public PostComment1() {
    }

    public PostComment1(String review) {
        this.review = review;
    }

}
