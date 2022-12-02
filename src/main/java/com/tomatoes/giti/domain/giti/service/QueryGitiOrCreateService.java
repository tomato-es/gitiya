package com.tomatoes.giti.domain.giti.service;

import com.tomatoes.giti.domain.giti.domain.Giti;
import com.tomatoes.giti.domain.giti.domain.repository.GitiRepository;
import com.tomatoes.giti.domain.giti.presentation.dto.GitiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QueryGitiOrCreateService {

    private final GitiRepository gitiRepository;

    @Transactional
    public GitiResponse execute(String githubId) {
        Optional<Giti> giti = gitiRepository.findByGithubId(githubId);

        if (giti.isEmpty()) {
            return GitiResponse.of(createGiti());
        }

        return null;
    }

    private Giti createGiti() {
        return null;
    }
}
