package com.agus.test.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.agus.test.models.Note;

import java.util.List;

@Dao
public interface NoteDao {
	
	@Insert
	void insertAll(Note... notes);
	
	// Menggunakan LIVE DATA
	@Query("SELECT * FROM note")
	public LiveData<List<Note>> findAll();
	
	// hapus data
	@Delete
	void deleteNote(Note notes);
	
	@Update
	void updateNote(Note notes);
	
}
