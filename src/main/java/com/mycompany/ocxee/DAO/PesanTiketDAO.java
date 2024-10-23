package com.mycompany.ocxee.DAO;

import com.mycompany.ocxee.model.PesanTiket; // Updated to use the correct package
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PesanTiketDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/oxcee";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    // Method to connect to the database
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // Method to insert a ticket booking into the database
    public void insertPesanTiket(PesanTiket tiket) {
        String sql = "INSERT INTO pesantiket (id_tiket, id_penyelam, id_destinasi, tanggal) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, tiket.getIdTiket());
            preparedStatement.setString(2, tiket.getIdPenyelam());
            preparedStatement.setString(3, tiket.getIdDestinasi());
            preparedStatement.setDate(4, tiket.getTanggal());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the SQL exception
        }
    }
}
