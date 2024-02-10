package com.example.News_service_REST_API.mapper.v2;

import com.example.News_service_REST_API.model.User;
import com.example.News_service_REST_API.web.model.UpsertUserRequest;
import com.example.News_service_REST_API.web.model.UserListResponse;
import com.example.News_service_REST_API.web.model.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;


import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapperV2 {

    User requestToUser(UpsertUserRequest request);

    @Mapping(source = "userId", target = "id")
    User requestToUser(Long userId, UpsertUserRequest request);


    UserResponse userToResponse(User user);

    default UserListResponse userListToUserResponseList(List<User> users){
        UserListResponse  response = new UserListResponse();

        response.setUsers(users.stream()
                .map(this::userToResponse)
                .collect(Collectors.toList()));

        return response;
    }





}
