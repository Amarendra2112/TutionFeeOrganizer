package com.example.tutiontracker;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<Student> studentList;
    LayoutInflater inflater;

    Adapter(Context context, List<Student> studentList)
    {
        this.inflater = inflater.from(context);
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {

        String name = studentList.get(i).getName();
        String date = studentList.get(i).getDate();
        holder.name.setText(name);
        holder.date.setText(date);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.CardStudentName);
            date = itemView.findViewById(R.id.CardDate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(),StudentDetails.class);
                    i.putExtra("Name",studentList.get(getAdapterPosition()).getName());
                    v.getContext().startActivity(i);
                }
            });
        }
    }
}
