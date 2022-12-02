package com.tomatoes.giti.global.feign.github;

import com.tomatoes.giti.global.feign.github.dto.GithubInformationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "GithubClient", url = "https://api.github.com")
public interface GithubClient {

    @GetMapping("/users/{username}")
//    GithubInformationResponse getGithubInformation(@RequestHeader(value = "Authorization") String token, @PathVariable String username);
    GithubInformationResponse getGithubInformation(@PathVariable String username);
}