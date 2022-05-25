package com.app.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder>
{
    private Context context;
    private List<MyCalendar> calendarList;
    private Calendar calendar;

    public CalendarAdapter(Context context, List<MyCalendar> calendarList, Calendar calendar) {
        this.context= context;
        this.calendarList = calendarList;
        this.calendar = calendar;
    }

    @NonNull
    @Override
    public CalendarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = null;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        listItem = layoutInflater.inflate(R.layout.calendar_child_item, parent, false);
        return new CalendarAdapter.ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarAdapter.ViewHolder holder, int position) {
        MyCalendar myCalendar = calendarList.get(position);
        holder.tvDate.setText(String.valueOf(myCalendar.getDate()));
        holder.tvMonth.setText(myCalendar.getMonth());
    }

    @Override
    public int getItemCount() {
        return calendarList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardCalender;
        TextView tvDate,tvMonth;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardCalender = itemView.findViewById(R.id.cardCalender);
            tvMonth = itemView.findViewById(R.id.tvMonth);
            tvDate = itemView.findViewById(R.id.tvDate);
        }
    }
}
