package net.cattaka.android.snippets.example.adapter.factory;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.cattaka.android.snippets.adapter.AdapterConverter;
import net.cattaka.android.snippets.adapter.ForwardingListener;
import net.cattaka.android.snippets.adapter.ScrambleAdapter;
import net.cattaka.android.snippets.example.R;

/**
 * Created by cattaka on 16/05/02.
 */
public class SimpleNumberViewHolderFactory implements ScrambleAdapter.IViewHolderFactory<ScrambleAdapter, RecyclerView.ViewHolder, ForwardingListener<ScrambleAdapter, RecyclerView.ViewHolder>, SimpleNumberViewHolderFactory.ViewHolder, ForwardingListener<ScrambleAdapter, RecyclerView.ViewHolder>> {
    @Override
    public ViewHolder onCreateViewHolder(ScrambleAdapter adapter, ViewGroup parent, ForwardingListener forwardingListener) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_simple_number, parent, false);
        ViewHolder vh = new ViewHolder(view);
        view.setTag(ForwardingListener.VIEW_HOLDER, vh);
        view.setOnClickListener(forwardingListener);
        view.setOnLongClickListener(forwardingListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(ScrambleAdapter adapter, ViewHolder holder, int position, Object object) {
        Number item = (Number) object;

        String str = "Number = " + item;
        holder.text.setText(str);
    }

    @Override
    public boolean isAssignable(Object object) {
        return object instanceof Number;
    }

    public static class ViewHolder extends AdapterConverter.ViewHolder {
        TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
