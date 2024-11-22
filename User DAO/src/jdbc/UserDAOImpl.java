package jdbc;

import java.sql.*;
import java.util.*;

public  class UserDAOImpl implements UserDAO {
	 private static final String URL = "jdbc:mysql://localhost:3306/db";
	    private static final String USER = "root";
	    private static final String PASSWORD = "root";

	    // Database connection
	    private Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }

	    @Override
	    public void addUser(User user) {
	        String query = "INSERT INTO UserApp (UserName, email, password, mobileno,address) VALUES (?, ?, ?, ?,?)";
	        try (Connection conn = getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(query)) {
	            pstmt.setString(1, user.getName());
	            pstmt.setString(2, user.getEmail());
	            pstmt.setString(3, user.getPassword());
	            pstmt.setInt(4, user.getPhoneNo());
	            pstmt.setString(5, user.getAddress());
	            
	            pstmt.executeUpdate();

	            System.out.println("User added successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public User getUserById(int id) {
	        String query = "SELECT * FROM UserApp WHERE id = ?";
	        User user = null;
	        try (Connection conn = getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(query)) {

	            pstmt.setInt(1, id);
	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()) {
	                user = new User(rs.getInt("id"), rs.getString("UserName"), rs.getString("email"), rs.getString("password"), rs.getInt("mobileno"),rs.getString("adress"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return user;
	    }

	    @Override
	    public List<User> getAllUsers() {
	        List<User> users = new ArrayList<>();
	        String query = "SELECT * FROM UserApp";
	        try (Connection conn = getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(query)) {

	            while (rs.next()) {
	                User user = new User(rs.getInt("id"), rs.getString("UserName"), rs.getString("email"), rs.getString("password"), rs.getInt("mobileno"),rs.getString("adress"));
	                users.add(user);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
	    }

	    @Override
	    public void updateUser(User user) {
	        String query = "UPDATE UserApp SET UserName = ?, email = ?, password = ?, mobileno = ? WHERE id = ?";
	        try (Connection conn = getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(query)) {

	            pstmt.setString(1, user.getName());
	            pstmt.setString(2, user.getEmail());
	            pstmt.setString(3, user.getPassword());
	            pstmt.setInt(4, user.getPhoneNo());
	            pstmt.setInt(5, user.getId());
	            pstmt.executeUpdate();

	            System.out.println("User updated successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteUser(int id) {
	        String query = "DELETE FROM UserApp WHERE id = ?";
	        try (Connection conn = getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(query)) {

	            pstmt.setInt(1, id);
	            pstmt.executeUpdate();
	            System.out.println("User deleted successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
}
}
