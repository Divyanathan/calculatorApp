package com.example.user.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ValueParsingListnerInterFace
{

    //int a=0;
    ShowResultFragment mShowResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowResult =(ShowResultFragment) getSupportFragmentManager().findFragmentById(R.id.resultFragment);
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
        mShowResult.displayOprators(pOprators);
       // a=0;
    }
}
