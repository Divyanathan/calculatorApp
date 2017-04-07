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
    void displayOprands(char oprands){
        if(manuplateTextView.getText().toString().equals("0")){
           // valueOfOprandOne = valueOfOprandOne * 10 + oprands;
            if(oprands=='.'){
                valueOfOprandOne="0"+oprands;
                manuplateTextView.setText(""+valueOfOprandOne);
            }else {
                valueOfOprandOne = "" + oprands;
                manuplateTextView.setText("" + valueOfOprandOne);
            }
        }else {
            //checking with sign operations
            if(!isOpratorEnter) {
                if(valueOfOprandOne.equals("-")){
                    if(oprands=='.'){
                        valueOfOprandOne=valueOfOprandOne+"0"+oprands;
                        manuplateTextView.setText(valueOfOprandOne);
                    }else {
                        valueOfOprandOne=valueOfOprandOne+oprands;
                        manuplateTextView.setText(valueOfOprandOne);
                    }
                }

               // valueOfOprandOne = valueOfOprandOne * 10 + oprands;
                else if(!manuplateTextView.getText().toString().contains(".")) {
                    valueOfOprandOne = valueOfOprandOne + oprands;
                    manuplateTextView.setText("" + valueOfOprandOne);
                }
                else {
                    if(oprands!='.') {
                        valueOfOprandOne = valueOfOprandOne + oprands;
                        manuplateTextView.setText("" + valueOfOprandOne);
                    }

                }
                //manuplateTextView.setText(manuplateTextView.getText().toString() + oprands);
            }else {
                //cheking with sing simbol
                if(valueOfOpranTwo.equals("-")){
                    if(oprands=='.'){
                        valueOfOpranTwo=valueOfOpranTwo+"0"+oprands;
                        manuplateTextView.setText(valueOfOprandOne+theOprator+valueOfOpranTwo);
                    }else {
                        valueOfOpranTwo=valueOfOpranTwo+oprands;
                        manuplateTextView.setText(valueOfOprandOne+theOprator+valueOfOpranTwo);
                    }
                }

               // valueOfOpranTwo=valueOfOpranTwo*10+oprands;
               else if(valueOfOpranTwo.equals("")){
                    if(oprands=='.'){
                        valueOfOpranTwo="0"+oprands;
                        manuplateTextView.setText(valueOfOprandOne+theOprator+valueOfOpranTwo);
                    }
                    else {
                        valueOfOpranTwo=valueOfOpranTwo+oprands;
                        manuplateTextView.setText(valueOfOprandOne+theOprator+valueOfOpranTwo);
                    }
                }
                else {
                    if(valueOfOpranTwo.contains(".")){
                        if(oprands!='.'){
                            valueOfOpranTwo=valueOfOpranTwo+oprands;
                            manuplateTextView.setText(valueOfOprandOne+theOprator+valueOfOpranTwo);

                        }
                    }
                    else {
                        valueOfOpranTwo=valueOfOpranTwo+oprands;
                        manuplateTextView.setText(valueOfOprandOne+theOprator+valueOfOpranTwo);

                    }
                }
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
                if(isEqualsUsed){
                    manuplateTextView.setText("0");
                    viewReslutTextView.setText("");
                    isEqualsUsed=false;
                }else {
                    if (isOpratorEnter) {

                        if (valueOfOpranTwo.equals("")) {
                            manuplateTextView.setText("" + valueOfOprandOne);
                            isOpratorEnter = false;
                            break;
                        }
                        if(valueOfOpranTwo.contains(".")){
                                valueOfOpranTwo=valueOfOpranTwo.substring(0,valueOfOpranTwo.length()-1);

                        }else {
                            temp = Long.parseLong(valueOfOpranTwo);
                            valueOfOpranTwo = "" + temp / 10;
                        }
                        if (valueOfOpranTwo.equals("0")) {
                            valueOfOpranTwo = "";
                            manuplateTextView.setText("" + valueOfOprandOne + "" + theOprator);
                        } else {
                            manuplateTextView.setText("" + valueOfOprandOne + "" + theOprator + "" + valueOfOpranTwo);
                        }
                    } else {
                        if (valueOfOprandOne.contains(".")){
                            valueOfOprandOne=valueOfOprandOne.substring(0,valueOfOprandOne.length()-1);
                        }else {
                            temp = Long.parseLong(valueOfOprandOne);
                            valueOfOprandOne = "" + temp / 10;
                        }
                        manuplateTextView.setText("" + valueOfOprandOne);
                    }
                }
                break;

            case 's':
                long sing;
                if(isEqualsUsed){
                    double temp;
                    if(existingValue.contains(".")){
                        temp=Double.parseDouble(existingValue)*-1;
                        manuplateTextView.setText(""+temp);
                        valueOfOprandOne=""+temp;

                    }else {
                        sing=Long.parseLong(existingValue)*-1;
                        valueOfOprandOne=""+sing;
                        manuplateTextView.setText(""+sing);
                    }
                }
               else if(isOpratorEnter){
                    if(valueOfOpranTwo.equals(""))
                    {
                        valueOfOpranTwo="-";
                        manuplateTextView.setText(valueOfOprandOne + theOprator + valueOfOpranTwo);
                    }
                    else if(valueOfOpranTwo.equals("-")) {
                        valueOfOpranTwo="";
                        manuplateTextView.setText(valueOfOprandOne + theOprator + valueOfOpranTwo);
                    }
                    else {
                        sing = Long.parseLong(valueOfOpranTwo) * -1;
                        valueOfOpranTwo = "" + sing;
                        manuplateTextView.setText(valueOfOprandOne + theOprator + valueOfOpranTwo);
                    }
                }else {
                    if(manuplateTextView.getText().toString().equals("0")){
                        valueOfOprandOne="-";
                        manuplateTextView.setText(valueOfOprandOne);
                    }
                    else if(valueOfOprandOne.equals("-")){
                        valueOfOprandOne="0";
                        manuplateTextView.setText(valueOfOprandOne);
                    }else {
                        sing = Long.parseLong(valueOfOprandOne) * -1;
                        valueOfOprandOne = "" + sing;
                        manuplateTextView.setText(valueOfOprandOne + theOprator + valueOfOpranTwo);
                    }
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
        double res1;

        if(numberOfOprators==0){
            viewReslutTextView.setText("="+valueOfOprandOne);
        }else {
            switch (theOprator){
                case '+':
                    if(valueOfOprandOne.contains(".")||valueOfOpranTwo.contains(".")){
                        res1=Double.parseDouble(valueOfOprandOne)+Double.parseDouble(valueOfOpranTwo);
                        existingValue=""+res1;
                        viewReslutTextView.setText("="+res1);
                    }else {
                        res = Long.parseLong(valueOfOprandOne) + Long.parseLong(valueOfOpranTwo);
                        existingValue =""+res;
                        viewReslutTextView.setText("="+res);
                    }
                    isOpratorEnter=false;
                    numberOfOprators=0;
                   valueOfOprandOne="";;
                    valueOfOpranTwo="";
                    break;
                case '-':
                    if(valueOfOprandOne.contains(".")||valueOfOpranTwo.contains(".")){
                        res1=Double.parseDouble(valueOfOprandOne)-Double.parseDouble(valueOfOpranTwo);
                        existingValue=""+res1;
                        viewReslutTextView.setText("="+res1);
                    }else {
                        res = Long.parseLong(valueOfOprandOne) - Long.parseLong(valueOfOpranTwo);
                        existingValue =""+res;
                        viewReslutTextView.setText("="+res);
                    }
                    isOpratorEnter=false;
                    numberOfOprators=0;
                   valueOfOprandOne="";;
                    valueOfOpranTwo="";
                    break;
                case '/':
                     Double s;
                    Double opr1,opr2;
                   /* s= ((double)valueOfOprandOne/valueOfOpranTwo);
                    existingValue =s.longValue();*/
                    opr1=Double.parseDouble(valueOfOprandOne);
                    opr2=Double.parseDouble(valueOfOpranTwo);
                    s=((double)opr1/opr2);
                    existingValue =""+s;
                    viewReslutTextView.setText("="+s);
                    isOpratorEnter=false;
                    numberOfOprators=0;
                    valueOfOprandOne="";;
                    valueOfOpranTwo="";
                    break;
                case '*':
                    if(valueOfOprandOne.contains(".")||valueOfOpranTwo.contains(".")){
                        res1=Double.parseDouble(valueOfOprandOne)*Double.parseDouble(valueOfOpranTwo);
                        existingValue=""+res1;
                        viewReslutTextView.setText("="+res1);
                    }else {
                        res = Long.parseLong(valueOfOprandOne) * Long.parseLong(valueOfOpranTwo);
                        existingValue =""+res;
                        viewReslutTextView.setText("="+res);
                    }
                    isOpratorEnter=false;
                    numberOfOprators=0;
                   valueOfOprandOne="";;
                    valueOfOpranTwo="";
                    break;
            }
        }

    }

}
