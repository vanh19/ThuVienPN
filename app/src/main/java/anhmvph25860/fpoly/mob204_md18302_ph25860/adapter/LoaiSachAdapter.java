package anhmvph25860.fpoly.mob204_md18302_ph25860.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import anhmvph25860.fpoly.mob204_md18302_ph25860.R;
import anhmvph25860.fpoly.mob204_md18302_ph25860.dao.LoaiSachDAO;
import anhmvph25860.fpoly.mob204_md18302_ph25860.model.ItemClick;
import anhmvph25860.fpoly.mob204_md18302_ph25860.model.LoaiSach;

public class LoaiSachAdapter extends RecyclerView.Adapter<LoaiSachAdapter.ViewHolder> {
    private Context context;
    private ArrayList<LoaiSach> list;
    private ItemClick itemClick;

    public LoaiSachAdapter(Context context, ArrayList<LoaiSach> list, ItemClick itemClick) {
        this.context = context;
        this.list = list;
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_recycler_loaisach, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.txtTenLoai.setText("Tên Loại: " + list.get(position).getTenLoai());
    holder.txtMaLoai.setText("Mã Loại: " + String.valueOf(list.get(position).getId()));

    holder.imgDel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            LoaiSachDAO loaiSachDAO = new LoaiSachDAO(context);
            int check = loaiSachDAO.xoaLoaiSach(list.get(holder.getAdapterPosition()).getId());
            switch (check){
                case 1:
                    //load data
                    list.clear();
                    list = loaiSachDAO.getDSLoaiSach();
                    notifyDataSetChanged();
                    break;
                case -1:
                    Toast.makeText(context, "Không thể xoá loại sách này", Toast.LENGTH_SHORT).show();
                    break;
                case 0:
                    Toast.makeText(context, "Xoá loại sách không thành công", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    });
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoaiSach loaiSach = list.get(holder.getAdapterPosition());
                itemClick.onClick(loaiSach);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtMaLoai, txtTenLoai;
        ImageView imgDel, imgEdit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMaLoai = itemView.findViewById(R.id.txtMaLoai);
            txtTenLoai = itemView.findViewById(R.id.txtTenLoai);
            imgDel = itemView.findViewById(R.id.ivDel);
            imgEdit = itemView.findViewById(R.id.ivEdit);
        }
    }
}
