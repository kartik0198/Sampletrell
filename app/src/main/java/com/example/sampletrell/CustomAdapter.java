package com.example.sampletrell;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<MainActivity.Dataset> values;

    public CustomAdapter(List<MainActivity.Dataset> myDataset) {
        values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.list_item_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);

        // Changes the height and width to the specified *pixels*
//

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // get element from your data set at this position & replace the contents of the view with that element

        ViewGroup.LayoutParams params = holder.layout.getLayoutParams();
        if (position % 2 == 0) {
            params.height = 660;
        } else if (position % 3 == 0) {
            params.height = 890;
        } else params.height = 400;
        holder.layout.setLayoutParams(params);
        // Log.d("mytag","value = " + i);

        holder.txtFooter.setText(values.get(position).getName());
        holder.mImage.setImageResource(values.get(position).getImage());

        holder.mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtFooter;
        public ImageView mImage;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            mImage = (ImageView) v.findViewById(R.id.imageId);
            txtFooter = (TextView) v.findViewById(R.id.videoTitle);

        }
    }


    @Override
    public int getItemCount() {
        return values.size();
    }

}
