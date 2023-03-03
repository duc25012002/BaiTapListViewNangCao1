package com.hdcompany.listviewnangcao.duc;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.hdcompany.listviewnangcao.duc.adapter.LoaiSachAdapter;
import com.hdcompany.listviewnangcao.duc.model.LoaiSach;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RadioButton radio_giao_khoa, radio_tieu_thuyet, radio_khoa_hoc, radio_tam_ly;
    EditText edt_nhap_ten_sach;
    Button btn_dat_sach, btn_cap_nhat;

    ListView lv_danh_sach;

    ArrayList<LoaiSach> arr_loai_sach = new ArrayList<>();

    LoaiSachAdapter loaiSachAdapter;

    String tamThoi, tenSach;
    int anhSach, viTri = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        xuLy();

    }


    private void xuLy() {
        arr_loai_sach.add(new LoaiSach("Tiếng Việt 1", R.drawable.icon_sach_1));
        arr_loai_sach.add(new LoaiSach("Khoa học 5", R.drawable.icon_sach_3));
        arr_loai_sach.add(new LoaiSach("Sherlock Holmes", R.drawable.icon_sach_2));
        arr_loai_sach.add(new LoaiSach("Tại sao phải học", R.drawable.icon_sach_4));
        loaiSachAdapter = new LoaiSachAdapter(this, R.layout.item_sach, arr_loai_sach);
        lv_danh_sach.setAdapter(loaiSachAdapter);
        xoaDuLieu();
        caiDatAnhSach();
        themDuLieu();
        suaDuLieu();


    }


    //setting image book.
    private void caiDatAnhSach() {
        if (radio_giao_khoa.isChecked() == true) {
            anhSach = R.drawable.icon_sach_1;

        } else if (radio_tieu_thuyet.isChecked() == true) {
            anhSach = R.drawable.icon_sach_2;
        } else if (radio_khoa_hoc.isChecked() == true) {
            anhSach = R.drawable.icon_sach_3;
        } else {
            anhSach = R.drawable.icon_sach_4;
        }
    }


    //update book.
    private void suaDuLieu() {
        lv_danh_sach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edt_nhap_ten_sach.setText(arr_loai_sach.get(position).getTenSach());
                viTri = position;
            }
        });
        btn_cap_nhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caiDatAnhSach();

                arr_loai_sach.set(viTri, new LoaiSach(edt_nhap_ten_sach.getText().toString(), anhSach));
                Toast.makeText(MainActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                loaiSachAdapter.notifyDataSetChanged();
            }
        });

    }

    //add data
    private void themDuLieu() {
        btn_dat_sach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tenSach = edt_nhap_ten_sach.getText().toString();
                caiDatAnhSach();
                arr_loai_sach.add(new LoaiSach(tenSach, anhSach));
                Toast.makeText(MainActivity.this, "Thêm thành công: " + tenSach, Toast.LENGTH_SHORT).show();
                loaiSachAdapter.notifyDataSetChanged();
            }
        });
    }


    //delete data
    private void xoaDuLieu() {
        lv_danh_sach.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                tamThoi = arr_loai_sach.get(position).getTenSach().toString();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông báo");

                builder.setMessage("Bạn có chắc chắn muốn xóa không?");

                // Nút "Có"
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        arr_loai_sach.remove(position);
                        Toast.makeText(MainActivity.this, "Xóa thành công: " + tamThoi, Toast.LENGTH_SHORT).show();
                        loaiSachAdapter.notifyDataSetChanged();
                    }
                });

                // Nút "Không"
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(MainActivity.this, "Không xóa", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                return false;
            }
        });
    }


    private void anhXa() {
        lv_danh_sach = (ListView) findViewById(R.id.lv_danh_sach);
        edt_nhap_ten_sach = (EditText) findViewById(R.id.edt_nhap_ten_sach);
        radio_giao_khoa = (RadioButton) findViewById(R.id.radio_giao_khoa);
        radio_khoa_hoc = (RadioButton) findViewById(R.id.radio_khoa_hoc);
        radio_tam_ly = (RadioButton) findViewById(R.id.radio_tam_ly);
        radio_tieu_thuyet = (RadioButton) findViewById(R.id.radio_tieu_thuyet);
        btn_cap_nhat = (Button) findViewById(R.id.btn_cap_nhat);
        btn_dat_sach = (Button) findViewById(R.id.btn_dat_sach);
    }
}