package com.tomatoes.giti.domain.giti.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GitiType {

    ENFP("재기발랄한 활동가"),
    ENTJ("대담한 통솔자"),
    ISFJ("용감한 수호자"),
    ENTP("뜨거운 논쟁을 즐기는 변론가"),
    ESFP("자유로운 영혼의 연예인"),
    ISTJ("청렴결백한 논리주의자"),
    ESTJ("엄격한 관리자"),
    ESFJ("사교적인 외교관"),
    INFP("열정적인 중재자"),
    INTP("논리적인 사색가"),
    INTJ("용의주도한 전략가"),
    INFJ("선의의 응호자"),
    ENFJ("정의로운 사회 운동가"),
    ISFP("호기심 많은 예술가"),
    ISTP("만능 재주꾼"),
    ESTP("모험을 즐기는 사업가"),
    ;

    private final String nickname;
}
