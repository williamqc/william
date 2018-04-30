package upeu.edu.pe.william;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import upeu.edu.pe.dao.EventoDao;
import upeu.edu.pe.to.EventoTO;
import upeu.edu.pe.utils.EventoRecyclerAdapter;

public class ReportFragment extends Fragment {

    public EventoDao dao;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter<EventoViewHolder> adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewMyFragment =inflater.inflate(upeu.edu.pe.william.R.layout.fragment_report, container, false);

        this.recyclerView=(RecyclerView)viewMyFragment.findViewById(upeu.edu.pe.william.R.id.recyclerview);

        this.layoutManager=new LinearLayoutManager(this.getContext());
        dao=new EventoDao(this.getContext());
        List<EventoTO>lista=dao.ListarEvento();
        this.adapter=new EventoRecyclerAdapter(lista);

        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.setAdapter(adapter);

        return viewMyFragment;



    }
}
