package com.example.News_service_REST_API.service;

import com.example.News_service_REST_API.exception.EntityNotFoundException;
import com.example.News_service_REST_API.model.News;
import com.example.News_service_REST_API.model.NewsCategory;
import com.example.News_service_REST_API.model.NewsCommentary;
import com.example.News_service_REST_API.model.User;
import com.example.News_service_REST_API.repository.DatabaseNewsRepository;

import com.example.News_service_REST_API.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DatabaseNewsService {

    private final DatabaseNewsRepository newsRepository;

    private final DatabaseUserService databaseUserService;


    public List<News> findAll(){

        return newsRepository.findAll();
    }

    public News findById(Long id){

        return newsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Новость по ID {0} не найдена", id)));
    }

    public News save(News news){
        User user = databaseUserService.findById(news.getUser().getId());
        news.setUser(user);

        return newsRepository.save(news);
    }

    public News update(News news){
        User user = databaseUserService.findById(news.getUser().getId());
        News existedNews = findById(news.getId());

        BeanUtils.copyNonNullProperties(news, existedNews);
        existedNews.setUser(user);
        return newsRepository.save(existedNews);
    }

    public void deleteById(Long id){
        newsRepository.deleteById(id);
    }

    public void deleteByIdIn(List<Long> ids){
        newsRepository.deleteAllById(ids);
    }


}
