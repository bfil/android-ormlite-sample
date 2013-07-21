package com.bfil.ormliterepo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.bfil.ormliterepo.data.Repo;
import com.bfil.ormliterepo.models.User;

public class Main extends Activity {

	TextView txtOutput;
	Repo repo;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        txtOutput = (TextView) findViewById(R.id.output);
        
        repo = new Repo(this);
        
        User user = new User("Bruno", "Shadow", "MySecretPassword",
        		"email@gmail.com");
        
        txtOutput.append("Creating User: " + user.getAlias());
        user.save(repo);
        txtOutput.append("\nUser: " + user.getAlias() + " created successfully!");
        user = repo.Users.getByUsername("Shadow");
        txtOutput.append("\nUser: " + user.getAlias() + " retrieved successfully!");
        user.delete(repo);
        txtOutput.append("\nUser: " + user.getAlias() + " deleted successfully!");
        
    }
}