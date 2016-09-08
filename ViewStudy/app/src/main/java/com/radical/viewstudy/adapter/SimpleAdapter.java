package com.radical.viewstudy.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.radical.viewstudy.R;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Copyright (c)
 * Title.
 * <p/>
 * Description.
 *
 * @author radical
 * @version 1.0
 * @since 2016-08-28
 */
public class SimpleAdapter extends BaseAdapter {
    private static final String[] CONTENTS = "The quick brown fox jumps over the lazy dog".split(" ");
    private final LayoutInflater inflater;
    @BindDrawable(R.mipmap.ic_launcher)
    Drawable bg;

    public SimpleAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return CONTENTS.length;
    }

    @Override
    public String getItem(int position) {
        return CONTENTS[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        String word = getItem(position);
        holder.word.setText("Word: " + word);
        holder.length.setText("Length: " + word.length());
        holder.position.setText("Position: " + position);
        holder.imageView.setImageDrawable(bg);
        // Note: don't actually do string concatenation like this in an adapter's getView.

        return convertView;
    }

    static final class ViewHolder {
        @BindView(R.id.word)
        TextView word;
        @BindView(R.id.length)
        TextView length;
        @BindView(R.id.position)
        TextView position;
        @BindView(R.id.bg)
        ImageView imageView;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
