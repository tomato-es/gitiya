package com.tomatoes.giti.domain.giti.presentation.dto;

import com.tomatoes.giti.domain.giti.domain.Giti;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GitiResponse {

    private String githubId;
    private String giti;

    public static GitiResponse of(Giti giti) {
        return GitiResponse.builder()
                .githubId(giti.getGithubId())
                .giti(giti.getGiti())
                .build();
    }
}
