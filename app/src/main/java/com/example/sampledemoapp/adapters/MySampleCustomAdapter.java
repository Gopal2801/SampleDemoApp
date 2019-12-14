package com.example.sampledemoapp.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.sampledemoapp.R;
import com.example.sampledemoapp.models.SongResponse;

import java.util.ArrayList;

public class MySampleCustomAdapter extends RecyclerView.Adapter<MySampleCustomAdapter.CustomViewHolder> {
    private final Activity mContext;
    public static ArrayList<SongResponse> mItemList = new ArrayList<>();
    private RecyclerViewClickListener mListener;
    private CustomListener mCListener;
    private SongResponse mMode;

    public MySampleCustomAdapter(Activity c, ArrayList<SongResponse> questions) {
        this.mContext = c;
        this.mItemList = questions;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = null;
        view = inflater.inflate(R.layout.custom_spinner_items, parent, false);
        return new CustomViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomViewHolder holder, int position) {
        SongResponse aMode = mItemList.get(position);
        holder.itemName.setText(mItemList.get(position).getName());
       /* holder.itemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCListener != null) {
                    mCListener.selectData();
                    setMode(aMode);
                }


            }
        });*/

    }

    private void setMode(SongResponse aMode) {
        mMode = aMode;

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public SongResponse getValue() {
        return mMode;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView itemName;
        private RecyclerViewClickListener mListener;

        public CustomViewHolder(@NonNull View itemView, RecyclerViewClickListener aListener) {
            super(itemView);
            //mListener = aListener;
            itemView.setOnClickListener(this);
            itemName = itemView.findViewById(R.id.name_TXT);
        }

        @Override
        public void onClick(View view) {
//            mListener.onClick(view, getAdapterPosition());
        }
    }


    public interface RecyclerViewClickListener {

        void onClick(View view, int position);
    }

    public void selectData(CustomListener aLister) {
        mCListener = aLister;
    }

    public interface CustomListener {

        void selectData();
    }
}
