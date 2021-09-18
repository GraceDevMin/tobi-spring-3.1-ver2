package com.tobi.dao;

import com.tobi.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao_lookup {
    private ConnectionMaker connectionMaker; //인터페이스를 통해 오브젝트에 접근하므로 구체적인 클래스 정보 필요X

    //의존관계 검색을 이용하는 UserDao 생성자
    //but, 코드 안에 오브젝트 팩토리 클래스나 스프링 API가 나타나므로 어색함...
    //따라서 대개는 의존관계 주입방식을 사용하는 편이 나음
    //이때는 UserDao가 반드시 스프링이 만들고 관리하는 빈일 필요는 없다 (ConectionMaker만 스프링 빈이면 됨)
    public UserDao_lookup() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DaoFactory.class);
        this.connectionMaker = context.getBean("connectionMaker", ConnectionMaker.class);
    }

    public void add(User user) throws SQLException, ClassNotFoundException {
        Connection c = connectionMaker.makeConnection(); //인터페이스에 정의된 메소드를 사용하므로
        // 클래스가 바뀐다해도 메소드 이름 변경될 걱정X
    }

//    public User get(String id) throws SQLException, ClassNotFoundException {
//        Connection c = connectionMaker.makeConnection();
//    }
}
