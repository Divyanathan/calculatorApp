package com.example.user.calculatorapp;

import android.app.Fragment;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ShowResultFragment extends Fragment {

    TextView mManuplateTextView;
    TextView mViewReslutTextView;

    String mValueOfOprandOne, mValueOfOpranTwo;
    String mExistingValue;

    char mTheOprator;

    Boolean mIsOpratorEnter =false;
    Boolean mIsEqualsUsed = false;
    Boolean mIsFormatError=false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_show_result, container,false);
        mManuplateTextView = (TextView) root.findViewById(R.id.manipulate);
        mViewReslutTextView = (TextView) root.findViewById(R.id.reslult);

        mManuplateTextView.setText("0");
        mValueOfOprandOne = "";
        mValueOfOpranTwo = "";
        mIsOpratorEnter = false;

        return root;
    }


    void displayOprands(char pOprands) {

        if (mIsEqualsUsed) {

            mValueOfOpranTwo = "";
            mViewReslutTextView.setText("");
            mIsEqualsUsed = false;
            mTheOprator = '\0';
            mIsOpratorEnter = false;
            mIsFormatError=false;
            mExistingValue = "";

            mValueOfOprandOne = "" + pOprands;
            mManuplateTextView.setText(mValueOfOprandOne);

        } else if (mManuplateTextView.getText().toString().equals("0")) {

            if (pOprands == '.') {

                mValueOfOprandOne = "0" + pOprands;
                mManuplateTextView.setText("" + mValueOfOprandOne);

            } else {

                mValueOfOprandOne = "" + pOprands;
                mManuplateTextView.setText("" + mValueOfOprandOne);

            }
        } else {

            //checking with sign operations
            if (!mIsOpratorEnter) {
                if (mValueOfOprandOne.equals("-")) {

                    if (pOprands == '.') {

                        mValueOfOprandOne = mValueOfOprandOne + "0" + pOprands;
                        mManuplateTextView.setText(mValueOfOprandOne);

                    } else {

                        if(mValueOfOprandOne.length()<15) {
                            mValueOfOprandOne = mValueOfOprandOne + pOprands;
                        }
                        mManuplateTextView.setText(mValueOfOprandOne);

                    }
                }

                // mValueOfOprandOne = mValueOfOprandOne * 10 + pOprands;
                else if (!mManuplateTextView.getText().toString().contains(".")) {

                    if(mValueOfOprandOne.length()<15) {
                        mValueOfOprandOne = mValueOfOprandOne + pOprands;
                    }
                    mManuplateTextView.setText("" + mValueOfOprandOne);

                } else {

                    if (pOprands != '.') {

                        if(mValueOfOprandOne.length()<15) {
                            mValueOfOprandOne = mValueOfOprandOne + pOprands;
                        }
                        mManuplateTextView.setText("" + mValueOfOprandOne);

                    }

                }
                //mManuplateTextView.setText(mManuplateTextView.getText().toString() + pOprands);
            } else {

                //cheking with sing simbol
                if (mValueOfOpranTwo.equals("-")) {

                    if (pOprands == '.') {

                        mValueOfOpranTwo = mValueOfOpranTwo + "0" + pOprands;
                        mManuplateTextView.setText(mValueOfOprandOne + mTheOprator + mValueOfOpranTwo);

                    } else {

                        if (mValueOfOpranTwo.length()<15) {
                            mValueOfOpranTwo = mValueOfOpranTwo + pOprands;
                        }
                        mManuplateTextView.setText(mValueOfOprandOne + mTheOprator + mValueOfOpranTwo);

                    }
                }

                // mValueOfOpranTwo=mValueOfOpranTwo*10+pOprands;
                else if (mValueOfOpranTwo.equals("")) {

                    if (pOprands == '.') {

                        mValueOfOpranTwo = "0" + pOprands;
                        mManuplateTextView.setText(mValueOfOprandOne + mTheOprator + mValueOfOpranTwo);

                    } else {

                        if (mValueOfOpranTwo.length()<15) {
                            mValueOfOpranTwo = mValueOfOpranTwo + pOprands;
                        }
                        mManuplateTextView.setText(mValueOfOprandOne + mTheOprator + mValueOfOpranTwo);

                    }
                } else {

                    if (mValueOfOpranTwo.contains(".")) {

                        if (pOprands != '.') {

                            if (mValueOfOpranTwo.length() < 15) {
                                mValueOfOpranTwo = mValueOfOpranTwo + pOprands;
                            }
                          isMorethanTwentyCharacter();

                        }


                    } else {
                        if (mValueOfOpranTwo.length() < 15) {
                            mValueOfOpranTwo = mValueOfOpranTwo + pOprands;
                        }
                       isMorethanTwentyCharacter();

                    }
                }
            }
        }
    }

    void checkIsEqualsUsed() {
        if (mIsEqualsUsed == true && mValueOfOprandOne.equals("")) {
            mValueOfOprandOne = mExistingValue;
            mManuplateTextView.setText("" + mValueOfOprandOne);
            mIsEqualsUsed = false;
        }
    }


    void displayWithOprator(char pOprators) {

        checkIsEqualsUsed();

        if(mValueOfOprandOne.equals("-")){
        }
       else if (mValueOfOpranTwo.equals("")) {

            mTheOprator = pOprators;
            mIsOpratorEnter = true;
            mManuplateTextView.setText("" + mValueOfOprandOne + "" + mTheOprator);

        }
        else {

            mTheOprator = pOprators;
            mIsOpratorEnter = true;
            mManuplateTextView.setText("" + mValueOfOprandOne + "" + mTheOprator + "" + mValueOfOpranTwo);

        }


        mViewReslutTextView.setText("");
    }

    void manipulatos(char pOprator) {

        switch (pOprator) {

            case 'c':

                mManuplateTextView.setText("0");
                mViewReslutTextView.setText("");
                mValueOfOprandOne="";
                mValueOfOpranTwo="";
                mIsEqualsUsed = false;
                mIsOpratorEnter=false;
                mIsFormatError=false;
                break;

            case 'd':

                if (mIsEqualsUsed) {

                    mManuplateTextView.setText("0");
                    mViewReslutTextView.setText("");
                    mIsEqualsUsed = false;

                } else {

                    if (mIsOpratorEnter) {

                        if (mValueOfOpranTwo.equals("")) {

                            mManuplateTextView.setText("" + mValueOfOprandOne);
                            mIsOpratorEnter = false;

                        } else {

                            if (mValueOfOpranTwo.length() > 1)
                                mValueOfOpranTwo = mValueOfOpranTwo.substring(0, mValueOfOpranTwo.length() - 1);
                            else {
                                mValueOfOpranTwo = "";
                            }

                            isMorethanTwentyCharacter();
                           // mManuplateTextView.setText(mValueOfOprandOne + mTheOprator + mValueOfOpranTwo);
                        }

                    } else {

                        if (mValueOfOprandOne.length() > 1) {
                            mValueOfOprandOne = mValueOfOprandOne.substring(0, mValueOfOprandOne.length() - 1);
                        }
                        else {
                            mValueOfOprandOne = "0";
                        }

                        mManuplateTextView.setText("" + mValueOfOprandOne);
                    }
                }
                break;

            case 's':

                double lDecimalSign;

                if (mIsEqualsUsed) {

                   // mValueOfOprandOne = mExistingValue.contains(".") ? ( ""+ parsingDoubleValue(mExistingValue) * -1)  : (""+ parsingLaongValue(mExistingValue) * -1);
                    mValueOfOprandOne=isOprandContainsE_OrNot(parsingDoubleValue(mExistingValue) * -1);
                /*    mValueOfOprandOne=""+lDecimalSign;
                    if(mValueOfOprandOne.contains("E")){
                        mValueOfOprandOne= String.format("%.0f", lDecimalSign);
                    }
                    else {
                        mValueOfOprandOne=isDecimalOrNot(mValueOfOprandOne);
                    }*/


                   if(mIsFormatError){
                      showFormatError();
                   }else {
                       mManuplateTextView.setText(mValueOfOprandOne);
                       mIsOpratorEnter = false;
                       mIsEqualsUsed = false;
                       mIsFormatError=false;
                       mViewReslutTextView.setText("");
                   }

                } else if (mIsOpratorEnter) {

                    if (mValueOfOpranTwo.equals("")) {

                        mValueOfOpranTwo = "-";
                        mManuplateTextView.setText(mValueOfOprandOne + mTheOprator + mValueOfOpranTwo);

                    }
                    else if (mValueOfOpranTwo.equals("-")) {

                        mValueOfOpranTwo = "";
                        mManuplateTextView.setText(mValueOfOprandOne + mTheOprator + mValueOfOpranTwo);

                    }
                   /* else if(mValueOfOpranTwo.contains(".")){

                        lDecimalSign=parsingDoubleValue(mValueOfOpranTwo)*-1;
                        if(mIsFormatError){
                           showFormatError();
                        }else {
                            mValueOfOpranTwo = "" + lDecimalSign;
                            mManuplateTextView.setText(mValueOfOprandOne + mTheOprator + mValueOfOpranTwo);
                        }

                    }*/else {

                        //lSign = parsingLaongValue(mValueOfOpranTwo) * -1;
                       // mValueOfOpranTwo=isDecimalOrNot(""+parsingDoubleValue(mValueOfOpranTwo)*-1);
                        mValueOfOpranTwo=isOprandContainsE_OrNot(parsingDoubleValue(mValueOfOpranTwo)*-1);
                        if(mIsFormatError){
                            showFormatError();
                        }else {
                           // mValueOfOpranTwo = "" + lSign;
                            mManuplateTextView.setText(mValueOfOprandOne + mTheOprator + mValueOfOpranTwo);
                        }

                    }

                } else {

                    if (mManuplateTextView.getText().toString().equals("0")) {

                        mValueOfOprandOne = "-";
                        mManuplateTextView.setText(mValueOfOprandOne);

                    } else if (mValueOfOprandOne.equals("-")) {

                        mValueOfOprandOne = "0";
                        mManuplateTextView.setText(mValueOfOprandOne);

                    } /*else if(mValueOfOprandOne.contains(".")){

                        lDecimalSign = parsingDoubleValue(mValueOfOprandOne) * -1;
                        if(mIsFormatError){
                           showFormatError();
                        }
                        else {
                            mValueOfOprandOne = "" + lDecimalSign;
                            mManuplateTextView.setText(mValueOfOprandOne);
                        }

                    }*/
                    else {

                       // lSign = parsingLaongValue(mValueOfOprandOne) * -1;
                       // mValueOfOprandOne=isDecimalOrNot(""+parsingDoubleValue(mValueOfOprandOne)*-1);
                        mValueOfOprandOne=isOprandContainsE_OrNot(parsingDoubleValue(mValueOfOprandOne)*-1);
                        if(mIsFormatError){
                            showFormatError();
                        }else {
                           // mValueOfOprandOne = "" + lSign;
                            mManuplateTextView.setText(mValueOfOprandOne);
                        }

                    }
                }
                break;

            case '=':
                if (!mValueOfOpranTwo.equals("") && !mValueOfOpranTwo.equals("-"))
                    calculationOfTheOprands();
                break;
        }
    }


    void showFormatError(){

            mViewReslutTextView.setText("Number formate error");
            mIsFormatError=false;

    }
    double parsingDoubleValue(String pOprand){

        double lDoubleValue;
        try {
            lDoubleValue=Double.valueOf(pOprand);
        }catch (NumberFormatException e){
            mIsFormatError=true;
            lDoubleValue=0.0D;
        }
        return  lDoubleValue;

    }

    double calculation(double pOprandOne, double pOprandTwo){

        if(mTheOprator=='+') {
            return pOprandOne + pOprandTwo;

        }else if (mTheOprator=='-'){
            return pOprandOne - pOprandTwo;

        }else if (mTheOprator=='*'){
            return pOprandOne * pOprandTwo;

        }else if(mTheOprator== '/'){
            return pOprandOne / pOprandTwo;
        }
        return Double.NaN;

    }
    String isDecimalOrNot(String pOprand){

        String[] findDecimalValue = pOprand.split("\\.");

        if (findDecimalValue[1].equals("0")) {

            return findDecimalValue[0];

        } else {
            return pOprand;
        }
    }
    String isOprandContainsE_OrNot(double pOprand){

        String lOprand=""+pOprand;

        if(lOprand.contains("E")) {

            return "" + String.format("%.0f", pOprand);

        }
        else {
            return isDecimalOrNot(lOprand);
        }
    }
    void isMorethanTwentyCharacter(){


        if (mManuplateTextView.getText().toString().length() >=20) {
            mManuplateTextView.setText(mValueOfOprandOne +"\n" +mTheOprator + mValueOfOpranTwo);
        }
        else {
            mManuplateTextView.setText(mValueOfOprandOne + mTheOprator + mValueOfOpranTwo);
        }
    }
    void calculationOfTheOprands(){


        double result = calculation(parsingDoubleValue(mValueOfOprandOne) ,parsingDoubleValue(mValueOfOpranTwo));

        mExistingValue=isOprandContainsE_OrNot(result);

       if(mIsFormatError){
            showFormatError();
        }

        else {
           if(mExistingValue.length()>15){
               mExistingValue=mExistingValue.substring(0,15);
           }
            mViewReslutTextView.setText(mExistingValue);
            mIsEqualsUsed = true;
            mIsOpratorEnter = false;
            mValueOfOprandOne = "";
            mValueOfOpranTwo = "";

        }
    }

}
