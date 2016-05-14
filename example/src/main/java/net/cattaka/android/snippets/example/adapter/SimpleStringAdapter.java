package net.cattaka.android.snippets.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.cattaka.android.snippets.adapter.AdapterConverter;
import net.cattaka.android.snippets.adapter.CustomRecyclerAdapter;
import net.cattaka.android.snippets.example.R;

import java.util.List;

/**
 * Created by cattaka on 16/05/02.
 */
public class SimpleStringAdapter extends CustomRecyclerAdapter<SimpleStringAdapter.ViewHolder, String> {
    Context mContext;
    List<String> mItems;

    public SimpleStringAdapter(Context mContext, List<String> mItems) {
        this.mContext = mContext;
        this.mItems = mItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_simple_string, parent, false);
        ViewHolder vh = new ViewHolder(view);
        view.setTag(VIEW_HOLDER, vh);
        view.setOnClickListener(getForwardingListener());
        view.setOnLongClickListener(getForwardingListener());
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = mItems.get(position);

        holder.text.setText(item);
    }

    @Override
    public String getItemAt(int position) {
        return mItems.get(position);
    }

    @Override
    public List<String> getItems() {
        return mItems;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class ViewHolder extends AdapterConverter.ViewHolder {
        TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
