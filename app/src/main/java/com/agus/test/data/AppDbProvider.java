package com.agus.test.data;

import android.content.Context;

import androidx.room.Room;

// Untuk mengakses Room Database
public class AppDbProvider {
	// Singleton = Akan mengembalikan nilai/object yang sama ketika di panggil/diakses
	private static AppDatabase AppDbInstance;
	
	
	public static AppDatabase getAppDbInstance(Context context)
	{
		if (AppDbProvider.AppDbInstance == null)
		{
			AppDbProvider.AppDbInstance = Room.databaseBuilder(context, AppDatabase.class, "app.db").build();
		}
		
		return AppDbProvider.AppDbInstance;
	}
}
