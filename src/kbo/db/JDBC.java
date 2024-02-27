package kbo.db;

import java.sql.*;

public class JDBC {
    // DB Driver
    String dbDriver = "com.mysql.cj.jdbc.Driver";

    // DB URL
    // IP:PORT/스키마
    String dbUrl = "jdbc:mysql://localhost:3306/sampledb";

    // DB ID/PW
    String dbUser = "root";
    String dbPassword = "madp0116";

    Connection connection= null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public JDBC() {
        dbConnection(); // 생성자에서 dbConnection 메서드 호출
    }

    public void dbConnection()
    {
        try
        {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            System.out.println("DB 연결 완료");
        }
        catch (SQLException e)
        {
            System.out.println("JDBC 드라이버 로드 에러");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("DB 연결 에러");
            e.printStackTrace();
        }
    }

    public boolean join(String userId, String userPassword) {
        boolean isIdExist = false;

        try {
            pstmt = connection.prepareStatement("SELECT id FROM member WHERE id = ?");
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                isIdExist = true; // 중복된 아이디 존재
                System.out.println("중복 회원 존재");
            } else {
                pstmt = connection.prepareStatement("INSERT INTO member (id, password) VALUES (?, ?)");
                pstmt.setString(1, userId);
                pstmt.setString(2, userPassword);
                pstmt.executeUpdate();
                System.out.println("회원 가입 완료");
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("SQL 실행 에러");
            e.printStackTrace();
        }

        return isIdExist;
    }

    public boolean login(String userId, String userPassword){
        boolean isCorrect = false;

        try {
            pstmt = connection.prepareStatement("SELECT * FROM member WHERE id = ? AND password = ?");
            pstmt.setString(1, userId);
            pstmt.setString(2, userPassword);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                isCorrect = true;
                System.out.println("로그인 성공");
            } else {
                System.out.println("로그인 실패: 아이디 또는 비밀번호가 일치하지 않습니다.");
            }
        } catch (SQLException e) {
            System.out.println("SQL 실행 에러");
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return isCorrect;
    }

    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
        } catch (SQLException e) {
            System.out.println("리소스 닫기 에러");
            e.printStackTrace();
        }
    }
}