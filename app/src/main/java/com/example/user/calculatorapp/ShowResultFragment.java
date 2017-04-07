package com.example.user.calculatorapp;

import android.support.v4.app.Fragment;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.activity_show_result, null);
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

                        mValueOfOprandOne = mValueOfOprandOne + pOprands;
                        mManuplateTextView.setText(mValueOfOprandOne);

                    }
                }

                // mValueOfOprandOne = mValueOfOprandOne * 10 + pOprands;
                else if (!mManuplateTextView.getText().toString().contains(".")) {

                    mValueOfOprandOne = mValueOfOprandOne + pOprands;
                    mManuplateTextView.setText("" + mValueOfOprandOne);

                } else {

                    if (pOprands != '.') {

                        mValueOfOprandOne = mValueOfOprandOne + pOprands;
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

                        mValueOfOpranTwo = mValueOfOpranTwo + pOprands;
                        mManuplateTextView.setText(mValueOfOprandOne + mTheOprator + mValueOfOpranTwo);

                    }
                }

                // mValueOfOpranTwo=mValueOfOpranTwo*10+pOprands;
                else if (mValueOfOpranTwo.equals("")) {

                    if (pOprands == '.') {

                        mValueOfOpranTwo = "0" + pOprands;
                        mManuplateTextView.setText(mValueOfOprandOne + mTheOprator + mValueOfOpranTwo);

                    } else {

                        mValueOfOpranTwo = mValueOfOpranTwo + pOprands;
                        mManuplateTextView.setText(mValueOfOprandOne + mTheOprator + mValueOfOpranTwo);

                    }
                } else {

                    if (mValueOfOpranTwo.contains(".")) {

                        if (pOprands != '.') {

                            mValueOfOpranTwo = mValueOfOpranTwo + pOprands;
                            mManuplateTextView.setText(mValueOfOprandOne + mTheOprator + mValueOfOpranTwo);

                        }
                    } else {

                        mValueOfOpranTwo = mValueOfOpranTwo + pOprands;
                        mManuplateTextView.setText(mValueOfOprandOne + mTheOprator + mValueOfOpranTwo);

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


    void displayTheValuesForManipulatorTextviewWithOprator(char pOprators) {

        mTheOprator = pOprators;
        mIsOpratorEnter = true;

        if (mValueOfOpranTwo.equals("")) {
            mManuplateTextView.setText("" + mValueOfOprandOne + "" + mTheOprator);
        }
        else {
            mManuplateTextView.setText("" + mValueOfOprandOne + "" + mTheOprator + "" + mValueOfOpranTwo);
        }
        mViewReslutTextView.setText("");
    }


    void displayOprators(char pOprator) {

        switch (pOprator) {

            case '+':

                checkIsEqualsUsed();
                displayTheValuesForManipulatorTextviewWithOprator(pOprator);
                break;

            case '-':

                checkIsEqualsUsed();
                displayTheValuesForManipulatorTextviewWithOprator(pOprator);
                break;

            case '/':

                checkIsEqualsUsed();
                displayTheValuesForManipulatorTextviewWithOprator(pOprator);
                break;

            case '*':

                checkIsEqualsUsed();
                displayTheValuesForManipulatorTextviewWithOprator(pOprator);
                break;

            case 'c':

                mManuplateTextView.setText("0");
                mViewReslutTextView.setText("");
                mIsEqualsUsed = false;
                mIsOpratorEnter=false;
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

                            mViewReslutTextView.setText(mValueOfOprandOne + mTheOprator + mValueOfOpranTwo);
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
                long lSing;

                if (mIsEqualsUsed) {

                    double lTemp;

                    if (mExistingValue.contains(".")) {

                        lTemp = Double.parseDouble(mExistingValue) * -1;
                        mManuplateTextView.setText("" + lTemp);
                        mValueOfOprandOne = "" + lTemp;
                        mIsOpratorEnter = false;

                    } else {

                        lSing = Long.parseLong(mExistingValue) * -1;
                        mValueOfOprandOne = "" + lSing;
                        mManuplateTextView.setText("" + lSing);
                        mIsOpratorEnter = false;

                    }

                } else if (mIsOpratorEnter) {

                    if (mValueOfOpranTwo.equals("")) {

                        mValueOfOpranTwo = "-";
                        mManuplateTextView.setText(mValueOfOprandOne + mTheOprator + mValueOfOpranTwo);

                    } else if (mValueOfOpranTwo.equals("-")) {

                        mValueOfOpranTwo = "";
                        mManuplateTextView.setText(mValueOfOprandOne + mTheOprator + mValueOfOpranTwo);

                    } else {

                        lSing = Long.parseLong(mValueOfOpranTwo) * -1;
                        mValueOfOpranTwo = "" + lSing;
                        mManuplateTextView.setText(mValueOfOprandOne + mTheOprator + mValueOfOpranTwo);

                    }

                } else {

                    if (mManuplateTextView.getText().toString().equals("0")) {

                        mValueOfOprandOne = "-";
                        mManuplateTextView.setText(mValueOfOprandOne);

                    } else if (mValueOfOprandOne.equals("-")) {

                        mValueOfOprandOne = "0";
                        mManuplateTextView.setText(mValueOfOprandOne);

                    } else {

                        lSing = Long.parseLong(mValueOfOprandOne) * -1;
                        mValueOfOprandOne = "" + lSing;
                        mManuplateTextView.setText(mValueOfOprandOne);

                    }
                }
                break;

            case '=':
                if (!mValueOfOpranTwo.equals(""))
                    calculationOfTheOprands();
                break;
        }
    }


    double decimalCalculation(double pOprandOne,double pOprandTwo){

        if(mTheOprator=='+') {
            return pOprandOne + pOprandTwo;
        }else if (mTheOprator=='-'){
            return pOprandOne - pOprandTwo;
        }else if (mTheOprator=='*'){
            return pOprandOne * pOprandTwo;
        }else if (mTheOprator=='/'){
            return pOprandOne / pOprandTwo;
        }
        else {

        }

        return pOprandOne;
    }
    long integerCalculation(long pOprandOne,long pOprandTwo){
        if(mTheOprator=='+') {
            return pOprandOne + pOprandTwo;
        }else if (mTheOprator=='-'){
            return pOprandOne - pOprandTwo;
        }else if (mTheOprator=='*'){
            return pOprandOne * pOprandTwo;
        }else if (mTheOprator=='/'){
            return pOprandOne / pOprandTwo;
        }
        else {

        }
        return pOprandOne;
    }
    void calculationOfTheOprands(){

        mIsEqualsUsed = true;
        long lResultOfIntgerValue;
        double lResultOfDecimalValue;

        if (mValueOfOprandOne.contains(".") || mValueOfOpranTwo.contains(".")) {

            lResultOfDecimalValue = decimalCalculation(Double.parseDouble(mValueOfOprandOne) ,Double.parseDouble(mValueOfOpranTwo));
            mExistingValue = "" + lResultOfDecimalValue;
            mViewReslutTextView.setText("=" + lResultOfDecimalValue);

        } else {

            lResultOfIntgerValue = integerCalculation(Long.parseLong(mValueOfOprandOne),Long.parseLong(mValueOfOpranTwo));
            mExistingValue = "" + lResultOfIntgerValue;
            mViewReslutTextView.setText("=" + lResultOfIntgerValue);

        }

        mIsOpratorEnter = false;
        mValueOfOprandOne = "";
        mValueOfOpranTwo = "";
    }

   /* void mShowResult() {
        mIsEqualsUsed = true;
        long res;
        double res1;

        switch (mTheOprator) {
            case '+':
                if (mValueOfOprandOne.contains(".") || mValueOfOpranTwo.contains(".")) {
                    res1 = Double.parseDouble(mValueOfOprandOne) + Double.parseDouble(mValueOfOpranTwo);
                    mExistingValue = "" + res1;
                    mViewReslutTextView.setText("=" + res1);
                } else {
                    res = Long.parseLong(mValueOfOprandOne) + Long.parseLong(mValueOfOpranTwo);
                    mExistingValue = "" + res;
                    mViewReslutTextView.setText("=" + res);
                }
                mIsOpratorEnter = false;
                mValueOfOprandOne = "";
                mValueOfOpranTwo = "";
                break;
            case '-':
                if (mValueOfOprandOne.contains(".") || mValueOfOpranTwo.contains(".")) {
                    res1 = Double.parseDouble(mValueOfOprandOne) - Double.parseDouble(mValueOfOpranTwo);
                    mExistingValue = "" + res1;
                    mViewReslutTextView.setText("=" + res1);
                } else {
                    res = Long.parseLong(mValueOfOprandOne) - Long.parseLong(mValueOfOpranTwo);
                    mExistingValue = "" + res;
                    mViewReslutTextView.setText("=" + res);
                }
                mIsOpratorEnter = false;
                mValueOfOprandOne = "";
                mValueOfOpranTwo = "";
                break;
            case '/':
                Double s;
                Double opr1, opr2;
                opr1 = Double.parseDouble(mValueOfOprandOne);
                opr2 = Double.parseDouble(mValueOfOpranTwo);
                s = ((double) opr1 / opr2);
                mExistingValue = "" + s;
                mViewReslutTextView.setText("=" + s);
                mIsOpratorEnter = false;
                mValueOfOprandOne = "";
                mValueOfOpranTwo = "";
                break;
            case '*':
                if (mValueOfOprandOne.contains(".") || mValueOfOpranTwo.contains(".")) {
                    res1 = Double.parseDouble(mValueOfOprandOne) * Double.parseDouble(mValueOfOpranTwo);
                    mExistingValue = "" + res1;
                    mViewReslutTextView.setText("=" + res1);
                } else {
                    res = Long.parseLong(mValueOfOprandOne) * Long.parseLong(mValueOfOpranTwo);
                    mExistingValue = "" + res;
                    mViewReslutTextView.setText("=" + res);
                }
                mIsOpratorEnter = false;
                mValueOfOprandOne = "";
                mValueOfOpranTwo = "";
                break;
        }


    }*/

}
