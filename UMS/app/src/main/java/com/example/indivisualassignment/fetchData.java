package com.example.indivisualassignment;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class fetchData extends RecyclerView.Adapter<fetchData.ViewHolder> {
    private ArrayList<UserModel> userList;
    Context context;
    UserDbHelper helper;
    public fetchData(ArrayList<UserModel> userList, Context context) {
        this.userList = userList;
        this.context = context;
        helper=new UserDbHelper(context);
    }

    @NonNull
    @Override
    public fetchData.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.user_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull fetchData.ViewHolder holder, final int position) {
        holder.username.setText(userList.get(position).getUsername());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, UserDetail.class);
                intent.putExtra("user",userList.get(position));
                context.startActivity(intent);
            }
        });
        holder.setItemOnLongClickLisene(new ItemOnLongClickLisener() {
            @Override
            public void onLongClickListener(View view, int id) {
                UserModel model=userList.get(id);
                userList.remove(id);
                notifyItemRemoved(id);
            }
        });



    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        ItemOnLongClickLisener itemOnLongClickLisene;
        public TextView username;

        public ViewHolder(View itemView) {
            super(itemView);
            ItemOnLongClickLisener itemOnLongClickLisener;
            username = itemView.findViewById(R.id.username);
            itemView.setOnLongClickListener(this);


            }
                public void setItemOnLongClickLisene(ItemOnLongClickLisener itemOnLongClickLisener){
            this.itemOnLongClickLisene=itemOnLongClickLisener;
        }

        @Override
        public boolean onLongClick(View v) {
            this.itemOnLongClickLisene.onLongClickListener(v, getLayoutPosition());
            return true;
        }

    }
}
