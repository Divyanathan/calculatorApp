package com.example.user.calculatorapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ShowResult extends Fragment {

    TextView manuplateTextView;
    TextView viewReslutTextView;
    String values="";
    String valueOfOprandOne,valueOfOpranTwo;
    long numberOfOprators;
    long temp;
    String existingValue;
    Boolean isOpratorEnter;
    char theOprator;

    Boolean isEqualsUsed=false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.activity_show_result, null);
        manuplateTextView=(TextView) root.findViewById(R.id.manipulate);
        viewReslutTextView=(TextView) root.findViewById(R.id.reslult);
        if(values.equals("")){
            manuplateTextView.setText("0");
        }
        valueOfOprandOne="";
        valueOfOpranTwo="";
        numberOfOprators=0;
        isOpratorEnter=false;
        init(root);
        return root;
    }
    void init(ViewGroup root){

    }
    void displayOprands(String oprands){
        if(manuplateTextView.getText().toString().equals("0")){
           // valueOfOprandOne = valueOfOprandOne * 10 + oprands;
            valueOfOprandOne=valueOfOprandOne+oprands;
            manuplateTextView.setText(""+valueOfOprandOne);
        }else {
            if(!isOpratorEnter) {
               // valueOfOprandOne = valueOfOprandOne * 10 + oprands;
                valueOfOprandOne=valueOfOprandOne+oprands;
                manuplateTextView.setText(""+valueOfOprandOne);
                //manuplateTextView.setText(manuplateTextView.getText().toString() + oprands);
            }else {
               // valueOfOpranTwo=valueOfOpranTwo*10+oprands;
                valueOfOpranTwo=valueOfOpranTwo+oprands;
                manuplateTextView.setText(valueOfOprandOne+""+theOprator + valueOfOpranTwo);
            }

            // manuplateTextView.setText(""+oprands);
        }
    }
    void displayOprators(char oprator){


        switch(oprator){
            case '+':
                if(isEqualsUsed==true && valueOfOprandOne.equals("")){
                    valueOfOprandOne= existingValue;
                    manuplateTextView.setText(""+valueOfOprandOne);
                }
                theOprator=oprator;
                isOpratorEnter=true;
                if(valueOfOpranTwo.equals(""))
                    manuplateTextView.setText(""+valueOfOprandOne+""+theOprator);
                else
                manuplateTextView.setText(""+valueOfOprandOne+""+theOprator+""+valueOfOpranTwo);
                ++numberOfOprators;
                viewReslutTextView.setText("");
                break;
            case '-':
                if(isEqualsUsed==true && valueOfOprandOne.equals("")){
                    valueOfOprandOne= existingValue;
                    manuplateTextView.setText(""+valueOfOprandOne);
                }
                theOprator=oprator;
                isOpratorEnter=true;
                if(valueOfOpranTwo.equals(""))
                    manuplateTextView.setText(""+valueOfOprandOne+""+theOprator);
                else
                manuplateTextView.setText(""+valueOfOprandOne+""+theOprator+""+valueOfOpranTwo);
                viewReslutTextView.setText("");
                ++numberOfOprators;
                break;
            case '/':
                if(isEqualsUsed==true && valueOfOprandOne.equals("")){
                    valueOfOprandOne= existingValue;
                    manuplateTextView.setText(""+valueOfOprandOne);
                }
                theOprator=oprator;
                isOpratorEnter=true;
                if(valueOfOpranTwo.equals(""))
                    manuplateTextView.setText(""+valueOfOprandOne+""+theOprator);
                else
                manuplateTextView.setText(""+valueOfOprandOne+""+theOprator+""+valueOfOpranTwo);
                viewReslutTextView.setText("");
                ++numberOfOprators;
                break;
            case '*':
                if(isEqualsUsed==true && valueOfOprandOne.equals("")){
                    valueOfOprandOne= existingValue;
                    manuplateTextView.setText(""+valueOfOprandOne);



                }
                theOprator=oprator;
                isOpratorEnter=true;
                if(valueOfOpranTwo.equals(""))
                    manuplateTextView.setText(""+valueOfOprandOne+""+theOprator);
                else
                manuplateTextView.setText(""+valueOfOprandOne+""+theOprator+""+valueOfOpranTwo);
                viewReslutTextView.setText("");
                ++numberOfOprators;
                break;
            case 'c':
                manuplateTextView.setText("0");
                values="";
                isOpratorEnter=false;
                numberOfOprators=0;
               valueOfOprandOne="";;
                valueOfOpranTwo="";
                viewReslutTextView.setText("");
                break;

            case 'd':
                if(isOpratorEnter){

                    if(valueOfOpranTwo.equals("")){
                        manuplateTextView.setText(""+valueOfOprandOne);
                        isOpratorEnter=false;
                        break;
                    }

                    temp=Long.parseLong(valueOfOpranTwo);
                    valueOfOpranTwo=""+temp/10;
                    if(valueOfOpranTwo.equals("")){
                        manuplateTextView.setText(""+valueOfOprandOne+""+theOprator);
                    }else {
                        manuplateTextView.setText("" + valueOfOprandOne + "" + theOprator + "" + valueOfOpranTwo);
                    }
                }
                else{
                    temp=Long.parseLong(valueOfOpranTwo);
                    valueOfOprandOne=""+temp/10;
                    manuplateTextView.setText(""+valueOfOprandOne);
                }

                break;
            case  '=':
                if(!valueOfOpranTwo.equals(""))
                showResult();
                break;
        }
    }
    void showResult(){
        isEqualsUsed=true;
        long res;

        if(numberOfOprators==0){
            viewReslutTextView.setText("="+valueOfOprandOne);
        }else {
            switch (theOprator){
                case '+':
                     res=Long.parseLong(valueOfOprandOne)+Long.parseLong(valueOfOpranTwo);
                    existingValue =""+res;
                    viewReslutTextView.setText("="+res);
                    isOpratorEnter=false;
                    numberOfOprators=0;
                   valueOfOprandOne="";;
                    valueOfOpranTwo="";
                    break;
                case '-':
                    res=Long.parseLong(valueOfOprandOne)-Long.parseLong(valueOfOpranTwo);
                    existingValue =""+res;
                    viewReslutTextView.setText("="+res);
                    isOpratorEnter=false;
                    numberOfOprators=0;
                   valueOfOprandOne="";;
                    valueOfOpranTwo="";
                    break;
                case '/':
                     Double s;
                   /* s= ((double)valueOfOprandOne/valueOfOpranTwo);
                    existingValue =s.longValue();*/
                    s=((double)(Long.parseLong(valueOfOprandOne)/Long.parseLong(valueOfOpranTwo)));
                    existingValue =""+s;
                    viewReslutTextView.setText("="+s);
                    isOpratorEnter=false;
                    numberOfOprators=0;
                   valueOfOprandOne="";;
                    valueOfOpranTwo="";
                    break;
                case '*':
                    res=Long.parseLong(valueOfOprandOne)+Long.parseLong(valueOfOpranTwo);
                    existingValue =""+res;
                    viewReslutTextView.setText("="+res);
                    isOpratorEnter=false;
                    numberOfOprators=0;
                   valueOfOprandOne="";;
                    valueOfOpranTwo="";
                    break;
            }
        }

    }

}
