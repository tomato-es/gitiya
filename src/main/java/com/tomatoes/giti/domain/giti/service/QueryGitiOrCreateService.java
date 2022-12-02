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
            int contributions = githubGraphqlClient.getContributions(githubId);
            GithubInformationResponse githubInformationResponse = githubClient.getGithubInformation(githubId);
            Giti savedGiti = gitiRepository.save(Giti.builder().build());
            return GitiResponse.of(savedGiti);
        }

        return GitiResponse.of(giti.get());
    }

    private Giti createGiti() {
        return null;
    }
}
