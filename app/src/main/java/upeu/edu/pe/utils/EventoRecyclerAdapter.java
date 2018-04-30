package upeu.edu.pe.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import upeu.edu.pe.to.EventoTO;
import upeu.edu.pe.william.EventoViewHolder;
import upeu.edu.pe.william.R;

/**
 * Created by William on 29/04/2018.
 */

public class EventoRecyclerAdapter extends RecyclerView.Adapter<EventoViewHolder> {

    List<EventoTO> eventos;


    public EventoRecyclerAdapter(List<EventoTO> eventos){
        this.eventos=eventos;
    }

    @Override
    public EventoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        Context context =parent.getContext();
        View view= LayoutInflater.from(context).inflate(R.layout.listaevento,parent,false);

        EventoViewHolder eventoViewHolder = new EventoViewHolder(view);

        return eventoViewHolder;

    }

    @Override
    public void onBindViewHolder(EventoViewHolder holder, int position) {


        EventoTO eventox =eventos.get(position);
        holder.setEvento(eventox);
    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }
}
