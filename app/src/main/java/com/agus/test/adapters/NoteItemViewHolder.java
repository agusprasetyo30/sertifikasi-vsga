package com.agus.test.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.agus.test.R;

public class NoteItemViewHolder extends RecyclerView.ViewHolder
{
    private TextView tvNama;
    private TextView tvKeterangan;
    private TextView tvWaktu;
    private CardView cardView;

    public NoteItemViewHolder(@NonNull View itemView)
    {
        super(itemView);

        this.tvNama = itemView.findViewById(R.id.tv_note_nama);
        this.tvKeterangan = itemView.findViewById(R.id.tv_note_keterangan);
        this.tvWaktu = itemView.findViewById(R.id.tv_note_waktu);
        this.cardView = itemView.findViewById(R.id.card_view);
    }
    
    public CardView getCardView() {
        return cardView;
    }
    
    public TextView getTvNama() {
        return tvNama;
    }
    
    public TextView getTvKeterangan() {
        return tvKeterangan;
    }
    
    public TextView getTvWaktu() {
        return tvWaktu;
    }
}
