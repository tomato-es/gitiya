package com.tomatoes.giti.global.feign.github;

import com.tomatoes.giti.global.feign.github.dto.GithubInformationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "GithubClient", url = "https://api.github.com")
public interface GithubClient {

    @GetMapping("/users/{username}")
    GithubInformationResponse getGithubInformation(@PathVariable String username);

}