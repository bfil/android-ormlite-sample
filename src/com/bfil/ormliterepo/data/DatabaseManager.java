package com.bfil.ormliterepo.data;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;

public class DatabaseManager<H extends OrmLiteSqliteOpenHelper> {
	
	private H helper;
	
	@SuppressWarnings("unchecked")
	public H getHelper(Context context)
	{
		if(helper == null)
		{
			helper = (H) OpenHelperManager.getHelper(context);
		}
		return helper;
	}
	
	public void releaseHelper(H helper)
	{
		if (helper != null) {
			OpenHelperManager.release();
			helper = null;
		}
	}
	
}
