package com.agus.test.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.agus.test.models.Note;
import com.agus.test.repository.NoteRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
	
	private NoteRepository noteRepository;
	
	public MainViewModel(@NonNull Application application) {
		super(application);
	
		this.noteRepository = new NoteRepository(application);
	}
	
	// Mendapatkan semua note dari database
	public LiveData<List<Note>>getNoteList()
	{
		// Memanggil dari repository
		return noteRepository.getNoteList();
	}
	
	// Untuk menyimpan kontak
	public void saveNote(Note note)
	{
		this.noteRepository.saveNote(note);
	}
	
	// Untuk Update note
	public void updateNote(Note note)
	{
		this.noteRepository.updateNote(note);
	}
	
	// Untuk Hapus note
	public void deleteNote(Note note)
	{
		this.noteRepository.deleteNote(note);
	}
}
