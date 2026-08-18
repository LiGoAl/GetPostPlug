package com.example.test.plug.Repositories;

import com.example.test.plug.DTOS.UserDTO;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;

@Repository
public class DataBaseWorker {

    public UserDTO select(String login) throws SQLException {
        String sql = "select upd.*, ue.email from user_passwords_dates upd join user_emails ue on upd.login = ue.login where upd.login = ?";

        try (Connection conn = DriverManager.getConnection("${app.database.url}", "${app.database.user}", "${app.database.password}");
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, login);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    LocalDateTime date = rs.getTimestamp("date").toLocalDateTime();
                    return new UserDTO(rs.getString("login"), rs.getString("password"), rs.getString("email"), date);
                } else {
                    throw new SQLException("No record found for login: " + login);
                }
            }
        }
    }

    public int insert(UserDTO user) throws SQLException {
        String sql1 = "insert into user_passwords_dates (login, password, date) values (?, ?, ?)";
        String sql2 = "insert into user_emails (login, email) values (?, ?)";

        try (Connection conn = DriverManager.getConnection("${app.database.url}", "${app.database.user}", "${app.database.password}");
        PreparedStatement ps1 = conn.prepareStatement(sql1);
        PreparedStatement ps2 = conn.prepareStatement(sql2)) {
            conn.setAutoCommit(false);

            ps1.setString(1, user.getLogin());
            ps1.setString(2, user.getPassword());
            ps1.setTimestamp(3, Timestamp.valueOf(user.getDate()));

            int result1 = ps1.executeUpdate();

            ps2.setString(1, user.getLogin());
            ps2.setString(2, user.getEmail());

            int result2 = ps2.executeUpdate();

            conn.commit();
            return result1 + result2;
        }
    }
}
