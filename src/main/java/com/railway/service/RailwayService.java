package com.railway.service;

import com.railway.model.Platform1;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDate;

@Service
public class RailwayService {

    private static final String URL = "jdbc:mysql://localhost:3306/windsurfstation";
    private static final String USER = "root";
    private static final String PASS = "mysql@31976343!";

    public void saveTicket(Platform1 acc) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pst = con.prepareStatement(
                     "INSERT INTO tickets (customer_name, mobile, current_location, destination, booking_date) VALUES (?, ?, ?, ?, ?)")) {

            pst.setString(1, acc.getCustomername());
            pst.setLong(2, acc.getMobile());
            pst.setString(3, "Bolaram");
            pst.setString(4, acc.getDestlocation());
            pst.setDate(5, Date.valueOf(LocalDate.now()));
            pst.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String viewLatestTicket(long mobile) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pst = con.prepareStatement(
                     "SELECT * FROM tickets WHERE mobile=? ORDER BY booking_date DESC LIMIT 1")) {

            pst.setLong(1, mobile);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return """
                    Customer Name : %s
                    Mobile        : %d
                    From          : %s
                    To            : %s
                    Date          : %s
                    """.formatted(
                        rs.getString("customer_name"),
                        rs.getLong("mobile"),
                        rs.getString("current_location"),
                        rs.getString("destination"),
                        rs.getDate("booking_date")
                );
            }
            return "No ticket found";

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String trainTimings() {
        return """
        Morning:
        7:00 AM  Bolaram to Basara
        7:30 AM  Bolaram to Karimnagar
        8:00 AM  Bolaram to Secunderabad

        Evening:
        6:00 PM  Bolaram to Tirupati
        8:00 PM  Bolaram to Kachiguda
        """;
    }
}
