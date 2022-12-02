package com.tomatoes.giti.domain.giti.presentation;

import com.tomatoes.giti.domain.giti.presentation.dto.GitiResponse;
import com.tomatoes.giti.domain.giti.service.QueryGitiOrCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/giti")
@RequiredArgsConstructor
public class GitiController {

    private final QueryGitiOrCreateService queryGitiOrCreateService;

    @GetMapping
    public GitiResponse getGiti(@RequestParam(name = "github") String githubId) {
        return queryGitiOrCreateService.execute(githubId);
    }
}
