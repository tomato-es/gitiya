package com.tomatoes.giti.global.feign.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GithubInformationResponse {

    @JsonProperty("login")
    private String githubId;

    private String bio;
    private int followers;
    private int following;
}
