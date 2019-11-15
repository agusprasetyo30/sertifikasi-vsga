package com.agus.test.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.agus.test.dao.NoteDao;
import com.agus.test.models.Note;


// Untuk mengambil data di lokal ataupun internet
@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase
{
	public abstract NoteDao noteDao();
}
