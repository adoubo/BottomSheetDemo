package com.cwxin.bottomsheetdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/11/5.
 */

public class PlayListApdater extends BaseAdapter {

    private Context mContext;
    private List<PlayListBO> playLists;

    public PlayListApdater(Context context, List<PlayListBO> playLists) {
        this.mContext = context;
        this.playLists = playLists;
    }

    @Override
    public int getCount() {
        return playLists.size();
    }

    @Override
    public Object getItem(int position) {
        return playLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_play, parent, false);
            holder.txt_musicTitle = (TextView) convertView.findViewById(R.id.txt_musicTitle);
            holder.txt_musicPlayer = (TextView) convertView.findViewById(R.id.txt_musicPlayer);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        convert(holder, position);
        return convertView;
    }

    private void convert(ViewHolder holder, int position) {
        PlayListBO playList = playLists.get(position);
        holder.txt_musicTitle.setText(playList.getMusicTitle());
        holder.txt_musicPlayer.setText(playList.getMusicPlayer());
    }

    class ViewHolder {

        TextView txt_musicTitle;

        TextView txt_musicPlayer;
    }
}
