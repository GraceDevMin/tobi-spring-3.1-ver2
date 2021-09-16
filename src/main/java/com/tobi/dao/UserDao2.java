package com.tobi.dao;

//싱글톤 패턴을 적용한 UserDao --> 왜 스프링이 빈을 싱글톤으로 만들어주는지 알 수 있다!! 스프링은 IoC 컨테이너이자, 싱글톤 레지스트리
public class UserDao2 {
    private static UserDao INSTANCE;

    private UserDao2(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public static synchronized UserDao getInstance() {
        if(INSTANCE == null) INSTANCE = new UserDao2()???);
        return INSTANCE;
    }

    // 이러한 일반적인 싱글톤 패턴 구현 방식의 문제
    // 1. private 생성자를 갖고 있어 상속 X
    // 2. 싱글톤은 테스트하기가 힘들다
    // 3. 서버환경에서는 싱글톤이 하나만 만들어지는 것을 보장하지 못한다
    // 4. 싱글톤의 사용은 전역 상태를 만들 수 있기 때문에 바람직하지 못하다
}
