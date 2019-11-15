package com.agus.test.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.agus.test.DetilNoteActivity;
import com.agus.test.R;
import com.agus.test.models.Note;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteItemViewHolder>
{
    private Context context;
    private List<Note> noteList;

    public NoteListAdapter(Context context)
    {
        this.context = context;
    }

    public List<Note> getNoteList()
    {
        return noteList;
    }

    public void setNoteList(List<Note> noteList)
    {
        this.noteList = noteList;

        // Biar nge-refresh
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        // Dapatkan inflater
        LayoutInflater inflater = LayoutInflater.from(this.context);

        // Render view pakai inflater
        View noteItemView = inflater.inflate(R.layout.item_note, parent, false);

        // View-nya dilempar ke ViewHolder
        NoteItemViewHolder vhNoteItem = new NoteItemViewHolder(noteItemView);

        // Jadikan nilai balik method ini
        return vhNoteItem;
    }

    // Ketika sedang me-render satu-persatu baris dari RecyclerView-nya...
    // Terjadi pe-renderan view holder satu persatu juga.
    @Override
    public void onBindViewHolder(@NonNull final NoteItemViewHolder holder, int position)
    {
        // Dapatkan data di posisi saat ini...
        final Note currentNote = this.noteList.get(position);

        // Pasang datanya di ViewHolder saat ini
        String nama = currentNote.getNama();
        String keterangan = currentNote.getKeterangan();
        String waktu = currentNote.getWaktu();
        CardView card = holder.getCardView();
        
        holder.getTvNama().setText(nama);
        holder.getTvKeterangan().setText(keterangan);
        holder.getTvWaktu().setText(waktu);
        
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetilNoteActivity.class);
                i.putExtra("DATA_ID", currentNote.getId());
                i.putExtra("DATA_NAMA", holder.getTvNama().getText().toString());
                i.putExtra("DATA_KETERANGAN", holder.getTvKeterangan().getText().toString());
                i.putExtra("DATA_WAKTU", holder.getTvWaktu().getText().toString());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        if (this.noteList == null) {
            return 0;
        } else {
            return this.noteList.size();
        }
    }
}


