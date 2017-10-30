package com.example.quaresma.conhecendoeaj.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quaresma.conhecendoeaj.R;
import com.example.quaresma.conhecendoeaj.model.Local;

import java.util.List;

public class LocalAdapter extends RecyclerView.Adapter {

    Context c;
    List<Local> localList;

    public LocalAdapter(Context c, List<Local> localList) {
        this.c = c;
        this.localList = localList;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.local_inflater, parent, false);
        LocalViewHolder localViewHolder = new LocalViewHolder(view);
        return localViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        LocalViewHolder localViewHolder = (LocalViewHolder) holder;
        Local localEscolhido = localList.get(position);
        localViewHolder.nomeLocal.setText(localEscolhido.getNome());
        localViewHolder.contato.setText(localEscolhido.getContato());
    }

    @Override
    public int getItemCount() {
        return localList == null ? 0 : localList.size();
    }

    public static class LocalViewHolder extends RecyclerView.ViewHolder{

        final TextView nomeLocal;
        final TextView contato;


        public LocalViewHolder(View v){
            super(v);

            nomeLocal = v.findViewById(R.id.nome_local);
            contato = v.findViewById(R.id.contato);
        }

    }
}
