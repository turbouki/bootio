package com.example.bootio.demo;

import java.sql.*;

public class JdbcPlainTest {
    private String DB_URL = "jdbc:postgresql://localhost:5432/mrs";
    private final String USER_NAME = "mrs";
    private final String PASSWORD = "mrs";

    // 애플리케이션이 데이터베이스와 통신하기 위한 드라이버 및 연결 객체를 요청한다
    /**
     * JDBC 프로그래밍 송수신 방법
     *  애플리케이션에서 IO작업 처리시 자원 할당 및 회수(시스템 측면) 그리고  애플리케이션 안정성 관리 중요 (Exception 처리)
     * 1.인증정보 구성 (Connection refused)
     * 2.드라이버 로딩(설치 ?) - 드라이버 로딩 테스트
     * 3.연결하기(1번 정보 전송) - 데이터베이스 연결(인증) 테스트
     * 4.명령객체 준비 -
     * 5.명령문 전송 - 쿼리(Bad grammar)
     * 6.결과(응답)객체 수신 (결과셋)
     * 7.업무처리 (걀과셋 확인 및 활용)
     * */


    // POSGRESQL dcos references
    // https://jdbc.postgresql.org/documentation/use/
    // Setting up the JDBC Driver
    // Getting the Driver - download(simple), maven, gradle
    // importing JDBC
    // Loading the Driver
    // Connecting to the Database
    // Connection Parameters



    private Connection createConnection() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //애플리케이션이 데이터베이스에 적재되어 있는 데이터를 요청하기 위해 쿼리(질의문)을 보낸다.
    private void query() {
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = createConnection();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from usr");
            while(rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) {
        JdbcPlainTest t = new JdbcPlainTest();
        t.query();
    }

}
