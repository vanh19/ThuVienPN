package anhmvph25860.fpoly.mob204_md18302_ph25860.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import anhmvph25860.fpoly.mob204_md18302_ph25860.R;
import anhmvph25860.fpoly.mob204_md18302_ph25860.adapter.PhieuMuonAdapter;
import anhmvph25860.fpoly.mob204_md18302_ph25860.dao.PhieuMuonDAO;
import anhmvph25860.fpoly.mob204_md18302_ph25860.model.PhieuMuon;

public class QLPhieuMuonFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qlphieumuon, container, false);

        RecyclerView recyclerQLPhieuMuon = view.findViewById(R.id.recyclerQLPhieuMuon);
        FloatingActionButton floatAdd = view.findViewById(R.id.floatAdd);

        //giao dien done
        //data
        PhieuMuonDAO phieuMuonDAO = new PhieuMuonDAO(getContext());
        ArrayList<PhieuMuon> list = phieuMuonDAO.getDSPhieuMuon();
        //adapter
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerQLPhieuMuon.setLayoutManager(linearLayoutManager);
        PhieuMuonAdapter adapter = new PhieuMuonAdapter(list, getContext());
        recyclerQLPhieuMuon.setAdapter(adapter);
        return view;
    }
}
