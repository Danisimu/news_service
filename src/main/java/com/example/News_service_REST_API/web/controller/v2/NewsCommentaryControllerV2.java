//package com.example.News_service_REST_API.web.controller.v2;
//
//
//import com.example.News_service_REST_API.mapper.v2.NewsCommentaryMapperV2;
//import com.example.News_service_REST_API.model.NewsCommentary;
//import com.example.News_service_REST_API.service.DatabaseNewsCommentaryService;
//import com.example.News_service_REST_API.web.model.NewsCommentaryListResponse;
//import com.example.News_service_REST_API.web.model.NewsCommentaryResponse;
//import com.example.News_service_REST_API.web.model.UpsertNewsCommentaryRequest;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/v2/commentary")
//@RequiredArgsConstructor
//public class NewsCommentaryControllerV2 {
//
//    private final DatabaseNewsCommentaryService commentaryService;
//
//    private final NewsCommentaryMapperV2 commentaryMapper;
//
//    @GetMapping
//    public ResponseEntity<NewsCommentaryListResponse> findAll(){
//        return ResponseEntity.ok(
//                commentaryMapper.newsCommentaryListResponse(commentaryService.findALl())
//        );
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<NewsCommentaryResponse> findById(@PathVariable @Valid Long id){
//
//        return ResponseEntity.ok(
//                commentaryMapper.newsCommentaryToResponses(commentaryService.findById(id))
//        );
//    }
//
//    @PostMapping
//    public ResponseEntity<NewsCommentaryResponse> create(@RequestBody @Valid UpsertNewsCommentaryRequest request){
//        NewsCommentary newsCommentary = commentaryService.create(commentaryMapper.requestToNewsCommentary(request));
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(commentaryMapper.newsCommentaryToResponses(newsCommentary));
//
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<NewsCommentaryResponse> update(@PathVariable @Valid Long id, @Valid UpsertNewsCommentaryRequest request ){
//        NewsCommentary commentary = commentaryService.update(commentaryMapper.requestToNewsCommentary(id, request));
//
//        return ResponseEntity.ok(
//                commentaryMapper.newsCommentaryToResponses(commentary)
//        );
//
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable @Valid Long id){
//        commentaryService.delete(id);
//
//        return ResponseEntity.noContent().build();
//    }
//
//}
