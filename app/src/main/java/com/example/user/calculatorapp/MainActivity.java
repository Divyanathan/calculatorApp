package com.example.user.calculatorapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements ValueParsingListnerInterFace, View.OnClickListener
{

    //int a=0;
    ShowResultFragment mShowResult;
    NumberPadFragment mNumberPadFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowResult=new ShowResultFragment();
        mNumberPadFragment=new NumberPadFragment();

        FragmentManager lFragmentManager=getFragmentManager();
        FragmentTransaction lFragmentTransaction=lFragmentManager.beginTransaction();
        lFragmentTransaction.add(R.id.resultFragment,mShowResult);
        lFragmentTransaction.add(R.id.keyPadFragment,mNumberPadFragment);
        lFragmentTransaction.commit();
       // mShowResult =(ShowResultFragment) getSupportFragmentManager().findFragmentById(R.id.resultFragment);
     /*   ShowResultFragment lShow = new ShowResultFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.idj,lShow).commit();*/

    }

    @Override
    public void passOprands(char pOprands) {
        //a=a*10+pOprands;

        mShowResult.displayOprands(pOprands);
    }

    @Override
    public void passOperator(char pOprators) {
        mShowResult.displayWithOprator(pOprators);
       // a=0;
    }

    @Override
    public void passManipulators(char pManipulators) {

        mShowResult.manipulatos(pManipulators);
    }

    @Override
    public void onClick(View v) {

    }
}


