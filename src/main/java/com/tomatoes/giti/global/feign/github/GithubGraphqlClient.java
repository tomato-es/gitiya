package com.tomatoes.giti.global.feign.github;

import com.tomatoes.giti.global.feign.github.dto.GithubContributionResponse;
import com.tomatoes.giti.global.properties.GithubProperties;
import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GithubGraphqlClient {

    private final GraphQLWebClient graphQLWebClient;
    private final GithubProperties githubProperties;

    public int getContributions(String username) {
        GraphQLRequest request = GraphQLRequest.builder()
                .header("Authorization", "bearer " + githubProperties.getToken())
                .query("query { \n" +
                        "  user(login: \"" + username + "\") {\n" +
                        "    contributionsCollection {\n" +
                        "      contributionCalendar {\n" +
                        "        totalContributions\n" +
                        "        weeks {\n" +
                        "          contributionDays {\n" +
                        "            weekday\n" +
                        "            date \n" +
                        "            contributionCount \n" +
                        "            color\n" +
                        "          }\n" +
                        "        }\n" +
                        "        months  {\n" +
                        "          name\n" +
                        "            year\n" +
                        "            firstDay \n" +
                        "          totalWeeks \n" +
                        "          \n" +
                        "        }\n" +
                        "      }\n" +
                        "    }\n" +
                        "  }\n" +
                        "  \n" +
                        "}")
                .build();
        GraphQLResponse response = graphQLWebClient.post(request).block();
        return response.get("user", GithubContributionResponse.class)
                .getContributionsCollection()
                .getContributionCalendar()
                .getTotalContributions();
    }
}