package com.tomatoes.giti.global.feign.github.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GithubContributionResponse {
    private ContributionCollection contributionsCollection;

    @Getter
    @NoArgsConstructor
    public static class ContributionCollection {
        private ContributionCalendar contributionCalendar;
    }

    @Getter
    @NoArgsConstructor
    public static class ContributionCalendar {
        private int totalContributions;
    }
}
