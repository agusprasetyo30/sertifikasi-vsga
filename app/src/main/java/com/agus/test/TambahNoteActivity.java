package com.agus.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.agus.test.models.Note;
import com.agus.test.viewModel.MainViewModel;

public class TambahNoteActivity extends AppCompatActivity {
	private MainViewModel viewModel;
	
	private EditText et_nama;
	private EditText et_keterangan;
	private EditText et_waktu;
	private Button btnSelesai;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tambah_note);
		this.viewModel = ViewModelProviders.of(TambahNoteActivity.this).get(MainViewModel.class);
		
		initComponent();
		this.clearInput();
	}
	
	private void initComponent()
	{
		btnSelesai = findViewById(R.id.btn_selesai_d);
		btnSelesai.setEnabled(false);
		et_nama = findViewById(R.id.et_nama);
		et_keterangan = findViewById(R.id.et_keterangan);
		et_waktu = findViewById(R.id.et_waktu);
	}
	
	public void btnTambah(View view) {
		Note newNote = this.makeNote();
		
		this.viewModel.saveNote(newNote);
		clearInput();
		Toast.makeText(this, "Tambah data sukses", Toast.LENGTH_LONG).show();
		
		Log.d("CEK", "SAVE SUKSES");
		Log.d("CEK", "Nama : " + newNote.getNama() + " | Keterangan : " + newNote.getKeterangan() + " | Waktu : " + newNote.getWaktu());
	}
	
	public void btnKembali(View view) {
		this.clearInput();
		this.backMainActivity();
	}
	
	private void clearInput()
	{
		et_nama.setText("");
		et_keterangan.setText("");
		et_waktu.setText("");
		et_nama.requestFocus();
	}
	
	private Note makeNote()
	{
		Note note = new Note();
		
		note.setNama(et_nama.getText().toString());
		note.setKeterangan(et_keterangan.getText().toString());
		note.setWaktu(et_waktu.getText().toString());
		
		return note;
	}
	
	private void backMainActivity()
	{
		Intent i = new Intent(TambahNoteActivity.this, MainActivity.class);
		startActivity(i);
		finish();
	}
}
