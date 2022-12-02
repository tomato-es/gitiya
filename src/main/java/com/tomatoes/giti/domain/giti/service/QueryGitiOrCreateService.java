package com.tomatoes.giti.domain.giti.service;

import com.tomatoes.giti.domain.giti.domain.Giti;
import com.tomatoes.giti.domain.giti.domain.repository.GitiRepository;
import com.tomatoes.giti.domain.giti.presentation.dto.GitiResponse;
import com.tomatoes.giti.global.feign.github.GithubClient;
import com.tomatoes.giti.global.feign.github.GithubGraphqlClient;
import com.tomatoes.giti.global.feign.github.dto.GithubInformationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class QueryGitiOrCreateService {

    private final GitiRepository gitiRepository;
    private final GithubClient githubClient;
    private final GithubGraphqlClient githubGraphqlClient;

    @Transactional
    public GitiResponse execute(String githubId) {
        Optional<Giti> giti = gitiRepository.findByGithubId(githubId);

        if (giti.isEmpty()) {
            return GitiResponse.of(
                    gitiRepository.save(createGiti(githubId))
            );
        }

        return GitiResponse.of(giti.get());
    }

    private Giti createGiti(String githubId) {
        return Giti.builder()
                .githubId(githubId)
                .giti(generateGiti(githubId))
                .build();
    }

    private String generateGiti(String githubId) {
        StringBuilder sb = new StringBuilder();
        GithubInformationResponse githubInformation = githubClient.getGithubInformation(githubId);
        int contributions = githubGraphqlClient.getContributions(githubId);

        sb.append(githubInformation.getFollowers() > 50 || githubInformation.getFollowers() > githubInformation.getFollowing() ? "E" : "I");
        sb.append(randomBoolean() ? "N" : "S");
        sb.append((githubInformation.getBio() != null && githubInformation.getBio().length() >= 80) ? "F" : "T");
        sb.append(contributions > 750 ? "J" : "P");
        return sb.toString();
    }

    public boolean randomBoolean(){
        return Math.random() < 0.5;
    }
}
