package com.example.News_service_REST_API.web.model;

import lombok.Data;

@Data
public class NewsCommentaryResponse {

    private Long id;

    private String commentary;

    private String userName;

    private Long newsId;
}
