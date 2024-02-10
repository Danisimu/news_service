package com.example.News_service_REST_API.repository;

import com.example.News_service_REST_API.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseNewsRepository extends JpaRepository<News, Long> {
}
