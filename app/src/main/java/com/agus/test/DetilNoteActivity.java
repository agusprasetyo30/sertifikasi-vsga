package com.agus.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.agus.test.models.Note;
import com.agus.test.viewModel.MainViewModel;

public class DetilNoteActivity extends AppCompatActivity {
	private MainViewModel viewModel;
	
	private EditText et_nama;
	private EditText et_keterangan;
	private EditText et_waktu;
	private TextView tv_id;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detil_note);
		this.viewModel = ViewModelProviders.of(DetilNoteActivity.this).get(MainViewModel.class);
		
		initData();
		initComponent();
	}
	
	private void initData() {
		et_nama = findViewById(R.id.et_nama);
		et_keterangan = findViewById(R.id.et_keterangan);
		et_waktu = findViewById(R.id.et_waktu);
		tv_id = findViewById(R.id.tv_id);
	}
	
	private void initComponent() {
		Intent i = getIntent();
		
		int id = i.getIntExtra("DATA_ID", 0);
		String nama = i.getStringExtra("DATA_NAMA");
		String keterangan = i.getStringExtra("DATA_KETERANGAN");
		String waktu = i.getStringExtra("DATA_WAKTU");
		
		et_nama.setText(nama);
		et_keterangan.setText(keterangan);
		et_waktu.setText(waktu);
		tv_id.setText(String.valueOf(id));
	}
	
	public void btnEdit(View view)
	{
		Note note = makeNote();
		
		this.viewModel.updateNote(note);
		Toast.makeText(this, "Update data sukses", Toast.LENGTH_LONG).show();
		this.clearInput();
		this.backMainActivity();
	}
	
	public void btnKembali(View view) {
		this.clearInput();
		this.backMainActivity();
	}
	
	public void btnHapus(View view)
	{
		Note note = makeNote();
		this.viewModel.deleteNote(note);
		Toast.makeText(this, "Hapus data sukses", Toast.LENGTH_LONG).show();
		
		this.backMainActivity();
		this.clearInput();
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
		
		note.setId(Integer.valueOf(tv_id.getText().toString()));
		note.setNama(et_nama.getText().toString());
		note.setKeterangan(et_keterangan.getText().toString());
		note.setWaktu(et_waktu.getText().toString());
		
		return note;
	}
	
	private void backMainActivity()
	{
		Intent i = new Intent(DetilNoteActivity.this, MainActivity.class);
		startActivity(i);
		finish();
	}
}
