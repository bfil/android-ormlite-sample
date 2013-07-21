package com.bfil.ormliterepo.data;

import java.sql.SQLException;
import java.util.List;

import com.bfil.ormliterepo.models.User;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

public class RepoUsers {
	
	Dao<User, String> userDao;
	
	public RepoUsers(DatabaseHelper db)
	{
		try {
			userDao = db.getUserDao();
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
	}
	
	public int create(User user)
	{
		try {
			return userDao.create(user);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int update(User user)
	{
		try {
			return userDao.update(user);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int delete(User user)
	{
		try {
			return userDao.delete(user);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public User getByUsername(String username)
	{		
		try {
			QueryBuilder<User, String> qb = userDao.queryBuilder();
			
			qb.where().eq("username", username);
			
			PreparedQuery<User> pq = qb.prepare();
			return userDao.queryForFirst(pq);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}
	public List<User> getAll()
	{		
		try {
			return userDao.queryForAll();
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

}
