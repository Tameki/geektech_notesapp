package com.geektech.notesapp.presentation.main.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.geektech.notesapp.model.NoteEntity;

public class NoteItemViewHolder extends RecyclerView.ViewHolder {

    private NoteClickListener mListener;

    NoteItemViewHolder(
            @NonNull View itemView,
            NoteClickListener listener
    ) {
        super(itemView);
        mListener = listener;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(getAdapterPosition());
            }
        });
    }

    void onBind(NoteEntity noteEntity) {
        //TODO: Set all note data into views
    }

    public interface NoteClickListener {
        void onClick(int position);
    }
}
