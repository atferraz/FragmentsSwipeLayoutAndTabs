package com.ferrazdev.fragmentsswipelayoutandtabs;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.TypedValue;


public class MainActivity extends ActionBarActivity {

    static ViewPager viewPager = null;      // Criação de um ViewPager para controlo do
                                            // Slidding como atributo para acesso geral.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // No arranque da activity liga-se o Viewpager ao Layout da activity
        viewPager = (ViewPager) findViewById(R.id.activityMain);

        // Associa o novo FragmentAdapter ao ViewPager
        FragmentManager fm = getSupportFragmentManager();   // da support.v4
        viewPager.setAdapter(new MeuFragmentAdapter(fm));

        // Controlo da titleStrip
        PagerTitleStrip titleStrip = (PagerTitleStrip) findViewById(R.id.tabTitle);
        titleStrip.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);
        titleStrip.setBackgroundColor(Color.BLACK);
        titleStrip.setTextColor(Color.MAGENTA);
    }
}

class MeuFragmentAdapter extends FragmentStatePagerAdapter {

    MeuFragmentAdapter(FragmentManager fm) {        // Recebe o fragment Adapter no contrutor.
        super(fm);
    }

    @Override
    public int getCount() {                         // devolve o nº de Fragments tratados nesta activity
        return 5;
    }                 // Devolve o nº de Fragments

    @Override
    public Fragment getItem(int position) {             // Devolve um dos Fragments, recebida a positção

        Fragment fragment = null; //

        if(position == 0){fragment = new FragmentS1();}
        if(position == 1){fragment = new FragmentS2();}
        if(position == 2){fragment = new FragmentS3();}
        if(position == 3){fragment = new FragmentS4();}
        if(position == 4){fragment = new FragmentS5();}
        return fragment;
    }

    @Override                                           // Tratamento das TABs
    public CharSequence getPageTitle(int position){

        if(position == 0){return "Tab1";}   // Fragment S1
        if(position == 1){return "Tab2";}   // Fragment S2
        if(position == 2){return "Tab3";}   // Fragment S3
        if(position == 3){return "Tab4";}   // Fragment S4
        if(position == 4){return "Tab5";}   // Fragment S5
        return null;
    }
}