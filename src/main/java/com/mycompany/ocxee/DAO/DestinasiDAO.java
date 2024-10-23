package com.mycompany.ocxee.DAO;

import com.mycompany.ocxee.model.Destinasi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DestinasiDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/oxcee"; 
    private String jdbcUsername = "root"; 
    private String jdbcPassword = "";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void insertDestinasi(Destinasi destinasi) {
        String sql = "INSERT INTO destinasi (id_destinasi, nama_destinasi, kedalaman, flora, fauna, pendamping) VALUES (?,?,?,?,?,?)";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, destinasi.getIdDestinasi());
            preparedStatement.setString(2, destinasi.getNamaDestinasi()); // Ganti dengan getNamaDestinasi()
            preparedStatement.setString(3, destinasi.getKedalaman());
            preparedStatement.setString(4, destinasi.getFlora());
            preparedStatement.setString(5, destinasi.getFauna());
            preparedStatement.setString(6, destinasi.getPendamping());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Destinasi getDestinasi(String id) {
        Destinasi destinasi = null;
        String sql = "SELECT * FROM destinasi WHERE id_destinasi = ?";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                destinasi = new Destinasi(
                    resultSet.getInt("id_destinasi"),
                    resultSet.getString("nama_destinasi"), // Ganti dengan nama kolom yang benar
                    resultSet.getString("Kedalaman"),
                    resultSet.getString("Flora"),
                    resultSet.getString("Fauna"),
                    resultSet.getString("Pendamping")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return destinasi;
    }

    public List<Destinasi> getAllDestinasi() {
        List<Destinasi> destinasiList = new ArrayList<>();
        String sql = "SELECT * FROM destinasi";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Destinasi destinasi = new Destinasi(
                    resultSet.getInt("id_destinasi"),
                    resultSet.getString("nama_destinasi"), // Ganti dengan nama kolom yang benar
                    resultSet.getString("kedalaman"),
                    resultSet.getString("flora"),
                    resultSet.getString("fauna"),
                    resultSet.getString("Pendamping")
                );
                destinasiList.add(destinasi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return destinasiList;
    }
}