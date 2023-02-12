package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;


public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Post post = new Post();
        post.setTitle("First post");
        post.getComments().add(new PostComment("My first review"));
        post.getComments().add(new PostComment("My second review"));
        post.getComments().add(new PostComment("My third review"));

        Serializable postId = session.save(post);

        Post queriedPostFromDB = session.get(Post.class, postId);
        queriedPostFromDB.getComments().remove(0);

//        post.getComments().remove(0);

//        System.out.println("---------" + post.getId());


//        Post1 post1 = new Post1();
//        post1.setTitle("first post1");
//
//
//        post1.addComment(new PostComment1("My first review1"));
//        post1.addComment(new PostComment1("My first review2"));
//        post1.addComment(new PostComment1("My first review3"));
//
//
//        Serializable post1Id = session.save(post1);
//
//
//        Post1 post11 = session.get(Post1.class, post1Id);
//        PostComment1 postComment1 = post11.getComments().get(0);
//
//        post11.removeComment(postComment1);


        tx.commit();
    }
}