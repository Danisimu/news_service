package com.example.News_service_REST_API.web.model;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class NewsResponseForFindById {

    private Long id;

    private String description;

    private Long userId;

    private int numberOfComments;

    private String category = "";

    private String userName;

    private List<NewsCommentaryResponse> commentaries = new ArrayList<>();
}