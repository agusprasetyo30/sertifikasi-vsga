package com.agus.test.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.agus.test.dao.NoteDao;
import com.agus.test.data.AppDatabase;
import com.agus.test.data.AppDbProvider;
import com.agus.test.models.Note;

import java.util.List;

public class NoteRepository {
	// Property instance database
	private AppDatabase database;
	
	// Data yang disediakan dan diperlukan untuk ViewModel
	private LiveData<List<Note>>noteList;
	
	public NoteRepository(Context context) {
		this.database = AppDbProvider.getAppDbInstance(context);
	}
	
	public LiveData<List<Note>> getNoteList() {
		this.getNoteDB();
		
		return noteList;
	}
	
	public void saveNote(Note note)
	{
		this.saveNoteDB(note);
	}
	
	public void updateNote(Note note)
	{
		this.updateNodeDB(note);
	}
	
	public void deleteNote(Note note)
	{
		new DeleteNoteTask().execute(note);
	}
	
	// mengambil data ke DB
	private void getNoteDB()
	{
		// Mengambil note dari DB
		NoteDao noteDao = this.database.noteDao();
		
		// mengambil data lewat DAO
		this.noteList = noteDao.findAll();
	}
	
	// menyimpan data ke DB
	private void saveNoteDB(Note note)
	{
		// menyimpan note secara asyncronus
		new SaveNoteTask().execute(note);
	}
	
	private void updateNodeDB(Note note)
	{
		// untuk edit note
		new UpdateNoteTask().execute(note);
	}
	
	// Membuat TASK yang dgunakan untuk menyimpan data agar bersifat asyncronous
	private class SaveNoteTask extends AsyncTask<Note, Void, Void>
	{
		@Override
		protected Void doInBackground(Note... notes) {
			NoteDao noteDao = database.noteDao();
			
			// Mengambil data pertama dari parameter
			Note note = notes[0];
			noteDao.insertAll(note);
			
			return null;
		}
	}
	
	
	// Membuat TASK yang dgunakan untuk menyimpan data agar bersifat asyncronous
	private class UpdateNoteTask extends AsyncTask<Note, Void, Void>
	{
		@Override
		protected Void doInBackground(Note... notes) {
			NoteDao noteDao = database.noteDao();
			
			// Mengambil data pertama dari parameter
			Note note = notes[0];
			noteDao.updateNote(note);
			
			return null;
		}
	}
	
	// Membuat TASK yang dgunakan untuk menyimpan data agar bersifat asyncronous
	private class DeleteNoteTask extends AsyncTask<Note, Void, Void>
	{
		@Override
		protected Void doInBackground(Note... notes) {
			NoteDao noteDao = database.noteDao();
			
			// Mengambil data pertama dari parameter
			Note note = notes[0];
			noteDao.deleteNote(note);
			
			return null;
		}
	}
}
