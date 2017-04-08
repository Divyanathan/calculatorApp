package com.example.user.calculatorapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class NumberPadFragment extends Fragment implements View.OnClickListener
{


    Button mButtonZero, mButtonOne, mButtonTwo, mButtonThree, mButtonFour, mButtonFive, mButtonSix, mButtonSeven, mButtonEight, mButtonNine, mButtonDot;
    Button mButtonCancel, mButtonSign, mButtonEquals, mButtonBracket, mButtonAdd, mButtonSubtract, mButtonDivision, mButtonMultiplication, mButtonDelete;
    ValueParsingListnerInterFace mParseValuetoInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_number_pad, container,false);

        mButtonZero =(Button)root.findViewById(R.id.zero); mButtonZero.setOnClickListener(this);

        mButtonOne =(Button) root.findViewById(R.id.one); mButtonOne.setOnClickListener(this);

        mButtonTwo =(Button) root.findViewById(R.id.two); mButtonTwo.setOnClickListener(this);

        mButtonThree =(Button) root.findViewById(R.id.three); mButtonThree.setOnClickListener(this);

        mButtonFour =(Button) root.findViewById(R.id.four); mButtonFour.setOnClickListener(this);

        mButtonFive =(Button) root.findViewById(R.id.five);mButtonFive.setOnClickListener(this);

        mButtonSix =(Button) root.findViewById(R.id.six); mButtonSix.setOnClickListener(this);

        mButtonSeven =(Button) root.findViewById(R.id.seven); mButtonSeven.setOnClickListener(this);

        mButtonEight =(Button) root.findViewById(R.id.eight); mButtonEight.setOnClickListener(this);

        mButtonNine =(Button) root.findViewById(R.id.nine); mButtonNine.setOnClickListener(this);

        mButtonDot =(Button) root.findViewById(R.id.dot); mButtonDot.setOnClickListener(this);

        mButtonSign =(Button) root.findViewById(R.id.sign); mButtonSign.setOnClickListener(this);

        mButtonEquals =(Button) root.findViewById(R.id.sum); mButtonEquals.setOnClickListener(this);

        mButtonBracket =(Button) root.findViewById(R.id.bracket); mButtonBracket.setOnClickListener(this);

        mButtonAdd =(Button) root.findViewById(R.id.addition); mButtonAdd.setOnClickListener(this);

        mButtonSubtract =(Button) root.findViewById(R.id.subtract); mButtonSubtract.setOnClickListener(this);

        mButtonDivision =(Button) root.findViewById(R.id.division); mButtonDivision.setOnClickListener(this);

        mButtonMultiplication =(Button) root.findViewById(R.id.muliplication);mButtonMultiplication.setOnClickListener(this);

        mButtonDelete =(Button) root.findViewById(R.id.delete); mButtonDelete.setOnClickListener(this);

        mButtonCancel =(Button) root.findViewById(R.id.cacncel); mButtonCancel.setOnClickListener(this);
        return root;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mParseValuetoInterface = (ValueParsingListnerInterFace) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnFileSelectedListener");
        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.zero:
               // mParseValuetoInterface.passOprands(Integer.parseInt(mButtonZero.getText().toString()));
                //Toast.makeText(getActivity(), "zero", Toast.LENGTH_SHORT).show();
                mParseValuetoInterface.passOprands('0');
                break;

            case R.id.one:
                mParseValuetoInterface.passOprands('1');
                //Toast.makeText(getActivity(), "one", Toast.LENGTH_SHORT).show();
                break;

            case R.id.two:
                mParseValuetoInterface.passOprands('2');
                break;

            case R.id.three:
                mParseValuetoInterface.passOprands('3');
                break;

            case R.id.four:
                mParseValuetoInterface.passOprands('4');
                break;

            case R.id.five:
                mParseValuetoInterface.passOprands('5');
                break;

            case R.id.six:
                mParseValuetoInterface.passOprands('6');
                break;

            case R.id.seven:
                mParseValuetoInterface.passOprands('7');
                break;

            case R.id.eight:
                mParseValuetoInterface.passOprands('8');
                break;

            case R.id.nine:
                mParseValuetoInterface.passOprands('9');
                break;

            case R.id.dot:
                mParseValuetoInterface.passOprands('.');
                break;



            case R.id.bracket:
               // mParseValuetoInterface.passOperator('(');
                break;
            case R.id.addition:
                mParseValuetoInterface.passOperator('+');
                break;
            case R.id.subtract:
                mParseValuetoInterface.passOperator('-');
                break;
            case R.id.division:
                mParseValuetoInterface.passOperator('/');
                break;
            case R.id.muliplication:
                mParseValuetoInterface.passOperator('*');
                break;
            case R.id.delete:
                mParseValuetoInterface.passManipulators('d');
                break;
            case R.id.cacncel:
                mParseValuetoInterface.passManipulators('c');
                break;
            case R.id.sign:
                mParseValuetoInterface.passManipulators('s');
                break;
            case R.id.sum:
                mParseValuetoInterface.passManipulators('=');
                break;
        }
    }
}
