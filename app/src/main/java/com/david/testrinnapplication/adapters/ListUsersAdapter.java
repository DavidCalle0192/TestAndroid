package com.david.testrinnapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.david.testrinnapplication.R;
import com.david.testrinnapplication.models.User;

import java.util.ArrayList;

public class ListUsersAdapter extends RecyclerView.Adapter<ListUsersAdapter.ViewHolder>{

    private ArrayList<User> dataset;

    public  ListUsersAdapter(){
        dataset = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        User u = dataset.get(position);
        holder.idTextView.setText(u.getId());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView idTextView;
        private TextView nameTextView;
        private TextView emailTextView;
        private TextView genderTextView;
        private TextView statusTextView;
        private TextView created_atTextView;
        private TextView updated_atTextView;

        public ViewHolder(View itemView){
            super(itemView);

            idTextView = itemView.findViewById(R.id.idTextView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
            genderTextView = itemView.findViewById(R.id.genderTextView);
            statusTextView = itemView.findViewById(R.id.statusTextView);
            created_atTextView = itemView.findViewById(R.id.created_atTextView);
            updated_atTextView = itemView.findViewById(R.id.updated_atTextView);
        }

    }
}
