package com.tomatoes.giti.domain.giti.service;

import com.tomatoes.giti.domain.giti.domain.Giti;
import com.tomatoes.giti.domain.giti.domain.repository.GitiRepository;
import com.tomatoes.giti.domain.giti.presentation.dto.GitiResponse;
import com.tomatoes.giti.global.feign.github.GithubClient;
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

    @Transactional
    public GithubInformationResponse execute(String githubId) {
        Optional<Giti> giti = gitiRepository.findByGithubId(githubId);

        if (giti.isEmpty()) {
            return githubClient.getGithubInformation(githubId);
        }

        return null;
    }

    private Giti createGiti() {
        return null;
    }
}
