package com.example.trivia.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trivia.R;
import com.example.trivia.dao.Historydao_Impl;
import com.example.trivia.databinding.ItemsBinding;
import com.example.trivia.viewmodel.GameHistory;

import java.util.List;

public class HistAdapter extends RecyclerView.Adapter<HistAdapter.Viewholder> {
    private Context context;
    private List<GameHistory> historyList;
    String date;

    public HistAdapter(Context context, List<GameHistory> historyList,String date) {
        this.context = context;
        this.historyList = historyList;
        this.date=date;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.items,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
  GameHistory history=historyList.get(position);
  holder.binding.name.setText("Name:  "+history.getName());
  holder.binding.color.setText("Answer:  "+history.getColor());
  holder.binding.cricket.setText("Answer:  "+history.getCricker());
  holder.binding.game.setText("Game"+ position+":  "+date);
    }
   public void getupdate(List<GameHistory>list){
        this.historyList=list;
        notifyDataSetChanged();
   }
    @Override
    public int getItemCount() {
        return historyList.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder {
    ItemsBinding binding;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
        binding=ItemsBinding.bind(itemView);


        }
    }
}
