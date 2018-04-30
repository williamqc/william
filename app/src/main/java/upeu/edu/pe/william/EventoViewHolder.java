package upeu.edu.pe.william;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import upeu.edu.pe.to.EventoTO;


public class EventoViewHolder extends RecyclerView.ViewHolder {

    private TextView txtNombre,txtLugar;

    private EventoTO eventoTO;

    public EventoViewHolder(View itemView) {
        super(itemView);

        this.txtNombre=(TextView)itemView.findViewById(upeu.edu.pe.william.R.id.txtNombre);
        this.txtLugar=(TextView)itemView.findViewById(upeu.edu.pe.william.R.id.txtLugar);

    }

    public void setEvento(EventoTO eventoy){

        this.eventoTO=eventoy;
        this.txtNombre.setText(eventoTO.getNombreevento());
        this.txtLugar.setText(eventoTO.getLugarevento());

    }
}
