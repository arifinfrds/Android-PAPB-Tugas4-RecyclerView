package com.arifinfrds.tugas4recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by arifinfrds on 11/6/17.
 */

public class OperatingSystemAdapter extends RecyclerView.Adapter<OperatingSystemAdapter.ViewHolder> {

    // MARK: - Properties
    private ArrayList<OperatingSystem> mOperatingSystems;
    private Context mContext;
    private OperatingSystemRecyclerViewCallback mCallback;

    // MARK: - Constructor
    public OperatingSystemAdapter(ArrayList<OperatingSystem> operatingSystems, Context context,
                                  OperatingSystemRecyclerViewCallback callback) {
        mOperatingSystems = operatingSystems;
        mContext = context;
        mCallback = callback;
    }

    // MARK: - RecyclerView.Adapter method
    @Override
    public OperatingSystemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_operating_system, parent, false);
        return new OperatingSystemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OperatingSystemAdapter.ViewHolder holder, final int position) {

        final OperatingSystem tiapOS = mOperatingSystems.get(position);

        holder.mTvOperatingSystem.setText(tiapOS.getName());

        holder.mIvOperatingSystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, tiapOS.getName(), Toast.LENGTH_SHORT).show();

                mCallback.onItemClick(position);

            }
        });
        Picasso.with(mContext).load(tiapOS.getImageResId()).resize(300, 300)
                .centerCrop().into(holder.mIvOperatingSystem);
    }
    @Override
    public int getItemCount() {
        return mOperatingSystems.size();
    }

    // MARK: - ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mIvOperatingSystem;
        public TextView mTvOperatingSystem;

        public ViewHolder(View itemView) {
            super(itemView);
            mIvOperatingSystem = (ImageView) itemView.findViewById(R.id.iv_operating_system);
            mTvOperatingSystem = (TextView) itemView.findViewById(R.id.tv_operating_system);
        }
    }
}
