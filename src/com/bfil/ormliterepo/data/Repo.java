package com.bfil.ormliterepo.data;
import android.content.Context;

public class Repo {
	
	DatabaseHelper db;
	
	public RepoUsers Users;
	
	public Repo(Context context)
	{
		DatabaseManager<DatabaseHelper> manager = new DatabaseManager<DatabaseHelper>();
		db = manager.getHelper(context);
		
		Users = new RepoUsers(db);
	
	}	
	
}
