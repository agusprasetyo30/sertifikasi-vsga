package com.agus.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.agus.test.adapters.NoteListAdapter;
import com.agus.test.models.Note;
import com.agus.test.viewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
	// View Model
	private MainViewModel viewModel;
	
	private RecyclerView rvNote;
	private Button btnTambah;
	private NoteListAdapter noteListAdapter;
	private ArrayList<Note> noteList = new ArrayList<>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.viewModel = ViewModelProviders.of(MainActivity.this).get(MainViewModel.class);
		
		initData();
		initComponent();
	}
	
	
	private void initData() {
//		noteList.add(new Note("Sarapan", "Kegiatan sebelum kuliah", "06.00"));
//		noteList.add(new Note("Belajar", "Kegiatan belajar", "06.00"));
//		noteList.add(new Note("Belajar", "Kegiatan belajar", "06.00"));
//		noteList.add(new Note("Belajar", "Kegiatan belajar", "06.00"));
//		noteList.add(new Note("Belajar", "Kegiatan belajar", "06.00"));
//		noteList.add(new Note("Belajar", "Kegiatan belajar", "06.00"));
		
		this.noteListAdapter = new NoteListAdapter(this);
	}
	
	private void initComponent() {
		this.rvNote = findViewById(R.id.rv_note);
		this.btnTambah = findViewById(R.id.btn_add_note);
		
		this.rvNote.setLayoutManager(new GridLayoutManager(this, 1));
		this.rvNote.setAdapter(noteListAdapter);
		
		this.viewModel.getNoteList().observe(this, new Observer<List<Note>>() {
			@Override
			public void onChanged(List<Note> notes) {
				noteListAdapter.setNoteList(notes);
			}
		});
//		this.noteListAdapter.setNoteList(noteList);
	}
	
	public void btnTambahNoteBaru(View view) {
		Intent i = new Intent(MainActivity.this, TambahNoteActivity.class);
		startActivity(i);
	}
}
