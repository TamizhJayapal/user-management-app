package com.user.app.dao;

import java.sql.*;
import java.util.*;

import com.user.app.model.User;

public class UserDAO {

	private static final String INSERT_USER = "insert into users(name,email,country) values(?,?,?)";

	private static final String UPDATE_USER = "update users set name=?,email=?,country=? where id=?";

	private static final String SELECT_USER = "select * from users where id=?";

	private static final String SELECT_ALL_USER = "select * from users";

	private static final String DELETE_USER = "delete from users where id=?";

	// select all user
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		try {
			Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(SELECT_ALL_USER);
			while (rs.next()) {
				System.out.println(rs.getString(2));
				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				users.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	// select user
	public User getUserById(int id) {
		User user = null;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con.prepareStatement(SELECT_USER);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			rs.next();
			user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("country"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	// insert user

	public boolean addUser(User user) {
		int rows = 0;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con.prepareStatement(INSERT_USER);
			st.setString(1, user.getName());
			st.setString(2, user.getEmail());
			st.setString(3, user.getCountry());
			rows = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows > 0;
	}

	// update user
	public boolean updateUser(User user) {
		int rows = 0;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con.prepareStatement(UPDATE_USER);
			st.setString(1, user.getName());
			st.setString(2, user.getEmail());
			st.setString(3, user.getCountry());
			st.setInt(4, user.getId());
			rows = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows > 0;
	}
	
	// delete use
	public boolean deleteUser(int id) {
		int rows = 0;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con.prepareStatement(DELETE_USER);
			st.setInt(1, id);
			rows = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows > 0;
	}
}
