package com.tomatoes.giti.domain.giti.domain.repository;

import com.tomatoes.giti.domain.giti.domain.Giti;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GitiRepository extends CrudRepository<Giti, Long> {

    Optional<Giti> findByGithubId(String githubId);
}
