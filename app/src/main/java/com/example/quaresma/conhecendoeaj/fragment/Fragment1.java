package com.example.quaresma.conhecendoeaj.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.quaresma.conhecendoeaj.MyRecycler;
import com.example.quaresma.conhecendoeaj.R;
import com.example.quaresma.conhecendoeaj.adapter.LocalAdapter;
import com.example.quaresma.conhecendoeaj.model.Local;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment  {

    private List<Local> localArrayList;
    Fragment3 fragment3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentManager fm = getFragmentManager();
        fm.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if (getFragmentManager().getBackStackEntryCount() == 0)
                    try {
                        finalize();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
            }
        });

        localArrayList = new ArrayList<>();

        View v = inflater.inflate(R.layout.activity_fragment1, container, false);


        final RecyclerView recyclerView = v.findViewById(R.id.recycler);

        carregaFrutas();

        final LocalAdapter localAdapter = new LocalAdapter(getContext(), localArrayList);
        Log.i("TESTE", String.valueOf(localArrayList.size()));
        recyclerView.setAdapter(localAdapter);

        /*Animação do adaptador, mais informações em  https://github.com/wasabeef/recyclerview-animators
        * Ao usar comente a linha "recyclerView.setAdapter(localAdapter)";
        * */
        //recyclerView.setAdapter(new SlideInLeftAnimationAdapter(localAdapter));


        RecyclerView.LayoutManager layout = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        /*
        Exemplos dos outros layouts possíveis
        */
        //RecyclerView.LayoutManager layout = new GridLayoutManager(this, 5);
        //RecyclerView.LayoutManager layout = new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.VERTICAL);
        //RecyclerView.LayoutManager layout = new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(layout);


        /*
         Esse código não funciona
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Não funciona", Toast.LENGTH_SHORT).show();
            }
        });
         */

        recyclerView.addOnItemTouchListener(new MyRecycler(getActivity(), recyclerView, new MyRecycler.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                //LocalAdapter.LocalViewHolder localViewHolder = new LocalAdapter.LocalViewHolder(view);


                recyclerView.addOnItemTouchListener(new MyRecycler(getActivity(), recyclerView, new MyRecycler.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        TabLayout tab = getActivity().findViewById(R.id.tab);
                        tab.getTabAt(1).select();

                        TextView textoPadrao = getActivity().findViewById(R.id.msgPadrao);
                        textoPadrao.setVisibility(View.GONE);

                        LinearLayout linearLayout = getActivity().findViewById(R.id.infomacoes);
                        linearLayout.setVisibility(View.VISIBLE);


                        ImageView imgLocal = getActivity().findViewById(R.id.logo);
                        TextView nome = getActivity().findViewById(R.id.nome);
                        TextView coord = getActivity().findViewById(R.id.coord);
                        TextView contato = getActivity().findViewById(R.id.contact);
                        TextView horaFunc = getActivity().findViewById(R.id.hora);
                        TextView descri = getActivity().findViewById(R.id.descricao);

                        imgLocal.setImageResource(carregaFrutas().get(position).getImagem());
                        imgLocal.setVisibility(View.VISIBLE);

                        nome.setText(carregaFrutas().get(position).getNome());
                        coord.setText(carregaFrutas().get(position).getCoordenador());
                        contato.setText(carregaFrutas().get(position).getContato());
                        horaFunc.setText(carregaFrutas().get(position).getHoraFuncionamento());
                        descri.setText(carregaFrutas().get(position).getDescricao());

                    }

                    @Override
                    public void onItemLongClick(View view, int position) {

                    }
                }));
            }


            @Override
            public void onItemLongClick(View view, int position) {


            }
        }));


        //setUpItemTouchHelper(recyclerView);

        /*
        Exemplos da biblioteca https://github.com/wasabeef/recyclerview-animators
         */
        //recyclerView.setItemAnimator(new FadeInDownAnimator());
        //recyclerView.setItemAnimator(new FlipInTopXAnimator());
        //recyclerView.setItemAnimator(new OvershootInLeftAnimator());
        //recyclerView.setItemAnimator(new LandingAnimator());


        return v;
    }

    public List<Local> carregaFrutas() {
        localArrayList.add(new Local(R.drawable.masc, "Alojamento Masculino", "-", "07:00 ~ 18:00", "(84) 9999-9999", "Alojamento com toda infraestrutura para o jovem crescer como ser humano e aluno", new LatLng(-5.885786, -35.365748)));
        localArrayList.add(new Local(R.drawable.feminino, "Alojamento Feminino", "-", "07:00 ~ 18:00", "(84) 9999-9999", "Alojamento com toda infraestrutura para a jovem crescer como ser humano e aluna", null));
        localArrayList.add(new Local(R.drawable.aves, "Avicultura", "Nao sei", "07:00 ~ 18:00", "(84) 9999-9999", "A avicultura é a criação de aves para produção de alimentos, em especial carne e ovos. " +
                "Entre as espécies criadas na avicultura destaca-se o frango. " +
                "Em muito menor escala, também são criadas aves como perus, patos, gansos, codornas e avestruzes.", null));
        localArrayList.add(new Local(R.drawable.biblioteca, "Biblioteca Prof. Rodolfo Helinski", "Nao sei", "07:00 ~ 18:00", "(84) 9999-9999", "Livros para estudos dos alunos da graduação e ensino médio", null));
        localArrayList.add(new Local(R.drawable.cvt, "Centro Vocacional Tecnológico - CVT", "Nao sei", "07:00 ~ 18:00", "(84) 9999-9999", "Local de aulas tanto de cursos técnicos como de gradução", null));
        localArrayList.add(new Local(R.drawable.agro, "Curso Técnico em Agropecuária/Agroindústria - ADM", "Nao sei", "07:00 ~ 18:00", "(84) 9999-9999", "Parte administrativa dos cursos de Agropecuária e Agroindústria", null));
        localArrayList.add(new Local(R.drawable.etec, "Coordenação E-tec", "Nao sei", "07:00 ~ 18:00", "(84) 9999-9999", "A Rede e-Tec Brasil é uma iniciativa do Ministério da Educação (MEC) que oferta cursos " +
                "de educação profissional e tecnológica semi-presenciais, " +
                "atuando na formação de trabalhadores egressos do ensino médio e da educação de jovens e adultos, através de um sistema virtual complementado com as atividades presenciais " +
                "desenvolvidas nos polos de apoio presencial com infraestrutura necessária para os alunos.", null));
        localArrayList.add(new Local(R.drawable.info, "Curso Técnico em Informática", "Nao sei", "07:00 ~ 18:00", "(84) 9999-9999", "Curso instituido pela lenda vida Josenalde", null));
        localArrayList.add(new Local(R.drawable.diretoria, "Diretoria Geral", "Nao sei", "07:00 ~ 18:00", "(84) 9999-9999", "Diretoria geral que coordena todas as atividades do Campus", null));
        localArrayList.add(new Local(R.drawable.escola, "Escola Alfedro J.Monteverde", "Nao sei", "07:00 ~ 18:00", "(84) 9999-9999", "Escola de ensino fundamental, qualidade garantida pelo Governo Federal", null));
        localArrayList.add(new Local(R.drawable.gremio, "Grêmio Estutantil", "Nao sei", "07:00 ~ 18:00", "(84) 9999-9999", "Onde as escolhas dos alunos fazem a diferença", null));
        localArrayList.add(new Local(R.drawable.inter, "Inst. Inter. de Neurociências de Natal", "Nao sei", "07:00 ~ 18:00", "(84) 9999-9999", "O crescimento mundial da neurociência e sua consequente tecnologia" +
                " de ponta possibilitaram avanços inovadores na compreensão essencial das " +
                "funções do cérebro sadio e dos mecanismos fisiopatológicos subjacentes às doenças neurológicas. " +
                "Esses avanços podem beneficiar milhões de pessoas no mundo, possibilitando diagnósticos precoces e " +
                "novos tratamentos para doenças graves como Alzheimer, mal de Parkinson ou outros danos neurológicos " +
                "causados por doenças ou acidentes.", null));
        localArrayList.add(new Local(R.drawable.aquicultura, "Prédio do Curso Técnico em Aquicultura", "Nao sei", "07:00 ~ 18:00", "(84) 9999-9999", "Prédio onde ocorre as aulas do curso técnico de aquicultura", null));
        localArrayList.add(new Local(R.drawable.ensino_medio, "Prédio do Ensino Médio", "Nao sei", "07:00 ~ 18:00", "(84) 9999-9999", "Muito bom", null));
        localArrayList.add(new Local(R.drawable.graduacao, "Prédio de Graduação", "Nao sei", "07:00 ~ 18:00", "(84) 9999-9999", "Prédio onde abriga os cursos de Zootecnia, Engenharia Florestal, Agronomia", null));
        localArrayList.add(new Local(R.drawable.quadra, "Quadra de Esportes - Prof. Jovenal L. Neto", "Nao sei", "07:00 ~ 18:00", "(84) 9999-9999", "Local de campeonatos e confratenizações do Campus", null));
        localArrayList.add(new Local(R.drawable.mel, "Unid. de Extração de Produtos Apícolas", "Nao sei", "07:00 ~ 18:00", "(84) 9999-9999", "Local para aquisição de mel de abelha", null));

        return localArrayList;
    }




}
