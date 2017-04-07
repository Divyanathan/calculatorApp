package com.example.user.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements  ValueParsingListner
{

    //int a=0;
    ShowResult showResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showResult=(ShowResult) getSupportFragmentManager().findFragmentById(R.id.resultFragment);
        ShowResult lShow = new ShowResult();
        getSupportFragmentManager().beginTransaction().add(R.id.idj,lShow).commit();

    }

    @Override
    public void passOprands(int oprands) {
        //a=a*10+oprands;

        showResult.displayOprands(""+oprands);
    }

    @Override
    public void passOperator(char oprators) {
        showResult.displayOprators(oprators);
       // a=0;
    }
}
