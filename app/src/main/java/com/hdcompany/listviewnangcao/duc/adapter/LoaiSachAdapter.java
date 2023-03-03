package com.hdcompany.listviewnangcao.duc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hdcompany.listviewnangcao.duc.R;
import com.hdcompany.listviewnangcao.duc.model.LoaiSach;

import java.time.Month;
import java.util.List;

public class LoaiSachAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<LoaiSach> loaiSachList;

    public LoaiSachAdapter(Context context, int layout, List<LoaiSach> loaiSachList) {
        this.context = context;
        this.layout = layout;
        this.loaiSachList = loaiSachList;
    }

    @Override
    public int getCount() {
        return loaiSachList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);


        TextView txt_ten_sach = (TextView) convertView.findViewById(R.id.txt_ten_sach);
        ImageView img_anh_sach = (ImageView) convertView.findViewById(R.id.img_anh_sach);

        LoaiSach loaiSach = loaiSachList.get(position);
        txt_ten_sach.setText(loaiSach.getTenSach());
        img_anh_sach.setImageResource(loaiSach.getHinhAnh());


        return convertView;
    }


}
