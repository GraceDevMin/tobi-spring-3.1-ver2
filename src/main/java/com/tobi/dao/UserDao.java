package com.tobi.dao;

import com.tobi.domain.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    private DataSource dataSource; //인터페이스를 통해 오브젝트에 접근하므로 구체적인 클래스 정보 필요X
    
    //생성자로 의존관계 주입
//    public UserDao(ConnectionMaker connectionMaker) {
//        this.connectionMaker = connectionMaker;
//    }

    //수정자로 의존관계 주입
    public void setConnectionMaker(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void add(User user) throws SQLException, ClassNotFoundException {
        Connection c = dataSource.getConnection(); //인터페이스에 정의된 메소드를 사용하므로
        // 클래스가 바뀐다해도 메소드 이름 변경될 걱정X
    }

//    public User get(String id) throws SQLException, ClassNotFoundException {
//        Connection c = connectionMaker.makeConnection();
//    }
}
