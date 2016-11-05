package com.cwxin.bottomsheetdemo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/5.
 */

public class BottomDialogFragment extends DialogFragment {

    private TextView txt_play_title;
    private ListView list_play; // 播放列表
    private List<PlayListBO> playLists = new ArrayList<PlayListBO>();
    private PlayListBO playList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_bottom_sheet, container);
        txt_play_title = (TextView) view.findViewById(R.id.txt_play_title);
        list_play = (ListView) view.findViewById(R.id.list_play);
        for (int i = 0; i < 8; i++) {
            playList = new PlayListBO();
            playList.setMusicTitle("Lolita");
            playList.setMusicPlayer("金海心");
            playLists.add(playList);
        }
        String playtitle = String.format(getResources().getString(R.string.txt_play_title), playLists.size());
        txt_play_title.setText(playtitle);
        PlayListApdater playListApdater = new PlayListApdater(getContext(), playLists);
        list_play.setAdapter(playListApdater);
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity(), R.style.MyBottomSheet);
        dialog.setContentView(R.layout.layout_bottom_sheet);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        params.gravity = Gravity.BOTTOM; // 设置面板的位置在屏幕底部
        params.width = dm.widthPixels;
        params.height = dm.heightPixels / 2;
        window.setAttributes(params);
        return dialog;
    }
}
