package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/*
for Entity class, Donot create setter because value may change in any places and cause confusion
we need to use constructor or builder


More confusion:
public Example(String a, String b){
    this.a=a;
    this.b=b;
}


Less confusion:
Example.builder()
    .a(a)
    .b(b)
    .build();



*/


//lombok annotation, make getter
@Getter
//lombok annotation, make constructor
@NoArgsConstructor
//JPA annotation, connect with DB class name matched with snake case
// ex) SalesManager->sales_manager
@Entity
public class Posts extends BaseTimeEntity {
//public class Posts {
    //Primary Key field
    @Id
    //Primary Key cration rules
    // > 2.0 need to add .IDENTITY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // data colum default is 255
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;


    //lombok annotation, make builder class
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }



}