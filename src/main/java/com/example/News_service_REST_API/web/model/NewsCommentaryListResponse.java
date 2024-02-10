package com.example.News_service_REST_API.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class NewsCommentaryListResponse {

    private List<NewsCommentaryResponse> commentaries = new ArrayList<>();
}
