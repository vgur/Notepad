package com.example.a16719756.myapplication.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.a16719756.myapplication.R;
import com.example.a16719756.myapplication.data.Note;

import java.util.Collections;
import java.util.List;


public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.NoteViewHolder> {

    class NoteViewHolder extends RecyclerView.ViewHolder {
        private final TextView id;
        private final TextView title;
        private final TextView content;

        private NoteViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id._id);
            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
        }
    }

    private final LayoutInflater mInflater;
    private List<Note> notesList = Collections.emptyList(); // Cached copy of words

    public NoteListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new NoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        Note current = notesList.get(position);
        holder.id.setText(String.valueOf(current.getId()));
        holder.title.setText(current.getTitle());
        holder.content.setText(current.getContent());
    }

    public void setNotes(List<Note> notes) {
        notesList = notes;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }
}


