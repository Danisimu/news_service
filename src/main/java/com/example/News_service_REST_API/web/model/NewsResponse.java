package com.example.News_service_REST_API.web.model;

import com.example.News_service_REST_API.model.NewsCategory;
import com.example.News_service_REST_API.model.User;
import lombok.Data;

@Data
public class NewsResponse {

    private Long id;

    private String description;

    private Long userId;

    private int numberOfComments;

    private String category = "";

    private String userName;




}
