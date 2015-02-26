package com.example.ferraz.fragmentsswipelayoutandtabs;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.ActionBar;
//import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    ActionBar actionBar, actionBar2;
    static ViewPager viewPager = null;      // Criação de um ViewPager para controlo do
                                            // Slidding como atributo para acesso geral.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ActionBar
        actionBar = getSupportActionBar();//getActionBar();
        actionBar2 = getSupportActionBar();//getActionBar();
        // Preparação da actionBar para receber Tabs
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);    // desatualizado

        // Criar as TABs
        //ActionBar.Tab tab1 = actionBar.newTab();
        //tab1.setText("Tab 1");
        //tab1.setTabListener(this);

        // Teste de versões para evitar métodos obsoletos e invalidar versões
        if(android.os.Build.VERSION.SDK_INT > 11){
            //inicia a action barUsa um método
        }
        else{
            //usa outro
        }





        // No arranque da activity liga-se o Viewpager ao Layout da activity
        viewPager = (ViewPager) findViewById(R.id.activityMain);

        // Associa o novo FragmentAdapter ao ViewPager
        FragmentManager fm = getSupportFragmentManager();   // da support.v4
        viewPager.setAdapter(new MeuFragmentAdapter(fm));
    }
}

class MeuFragmentAdapter extends FragmentStatePagerAdapter {

    MeuFragmentAdapter(FragmentManager fm) {        // Recebe o fragment Adapter no contrutor.
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {         // Devolve um dos Fragments, recebida a posição
        Fragment fragment = null; //

        if(position == 0){
            fragment = new FragmentS1();
        }
        if(position == 1){
            fragment = new FragmentS2();
        }
        if(position == 2){
            fragment = new FragmentS3();
        }
        return fragment;
    }

    @Override
    public int getCount() {                         // devolve o nº de Fragments tratados nesta activity
        return 3;
    }


    // Tratamento das TABs




    @Override
    public CharSequence getPageTitle(int position){

        if(position == 0){      // Fragment S1
            return "Tab1";
        }
        if(position == 1){      // Fragment S2
            return "Tab2";
        }
        if(position == 3){      // Fragment S3
            return "Tab1";
        }
        return null;
    }
}