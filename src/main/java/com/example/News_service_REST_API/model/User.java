package com.example.News_service_REST_API.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private List<News> newsList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private List<NewsCommentary> commentaryList = new ArrayList<>();



    public void addNews(News news){
        newsList.add(news);
    }

    public void removeNews(Long newsId){
        newsList = newsList.stream().filter(n -> !n.getId().equals(newsId)).collect(Collectors.toList());
    }

    public void removeAllNews(){
        newsList = new ArrayList<>();
    }

    public void addCommentary(NewsCommentary commentary){
        commentaryList.add(commentary);

    }

    public void removeCommentary(Long commentaryId){
        commentaryList = commentaryList.stream()
                .filter(c->!c.getId().equals(commentaryId))
                .collect(Collectors.toList());
    }

    public void removeAllCommentary(){
        commentaryList = new ArrayList<>();
    }

//    public void addCategory(NewsCategory category){
//        categoryList.add(category);
//    }
//
//    public void removeCategory(Long categoryId){
//        categoryList = categoryList.stream()
//                .filter(c -> !c.getId().equals(categoryId))
//                .collect(Collectors.toList());
//    }
}
