package com.tomatoes.giti.domain.giti.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "tbl_giti")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Giti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String githubId;

    @Column(nullable = false)
    private String giti;

    @Builder
    public Giti(String githubId, String giti) {
        this.githubId = githubId;
        this.giti = giti;
    }
}
