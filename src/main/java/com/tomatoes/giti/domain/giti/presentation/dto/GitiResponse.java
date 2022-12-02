package com.tomatoes.giti.domain.giti.presentation.dto;

import com.tomatoes.giti.domain.giti.domain.Giti;
import com.tomatoes.giti.domain.giti.domain.GitiType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GitiResponse {

    private String githubId;
    private String giti;
    private String profileImage;
    private String nickname;

    public static GitiResponse of(Giti giti) {
        return GitiResponse.builder()
                .githubId(giti.getGithubId())
                .giti(giti.getGiti())
                .profileImage("https://avatars.githubusercontent.com/" + giti.getGithubId())
                .nickname(GitiType.valueOf(giti.getGiti()).getNickname())
                .build();
    }
}
