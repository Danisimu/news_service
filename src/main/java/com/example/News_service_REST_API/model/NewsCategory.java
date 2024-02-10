package com.example.News_service_REST_API.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "categories")
public class NewsCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    private Long newsId;

    @OneToMany(mappedBy = "category")
    @ToString.Exclude
    @Builder.Default
    private List<News> newsList = new ArrayList<>();


    public void addNews(News news){
        newsList.add(news);
    }

    public void removeNews(News news){
        newsList = newsList.stream()
                .filter(n -> !n.equals(news))
                .collect(Collectors.toList());
    }

    public void removeAllNews(){
        newsList = new ArrayList<>();
    }
}
