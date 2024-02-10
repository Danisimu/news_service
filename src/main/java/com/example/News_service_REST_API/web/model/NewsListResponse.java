package com.example.News_service_REST_API.web.model;

import com.example.News_service_REST_API.model.News;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsListResponse {

    private List<NewsResponse> newsList = new ArrayList<>();
}
