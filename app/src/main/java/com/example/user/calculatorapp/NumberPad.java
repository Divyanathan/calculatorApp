package com.example.user.calculatorapp;

import android.app.Activity;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class NumberPad extends Fragment implements View.OnClickListener
{


    Button buttonZero,buttonOne,buttonTwo,buttonThree,buttonFour,buttonFive,buttonSix,buttonSeven,buttonEight,buttonNine,buttonDot;
    Button buttonCancel,buttonSign,buttonEquals,buttonBracket,buttonAdd,buttonSubtract,buttonDivision,buttonMultiplication,buttonDelete;
    ValueParsingListner parseValue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.activity_number_pad, null);
        buttonZero=(Button)root.findViewById(R.id.zero);
        buttonZero.setOnClickListener(this);
        buttonOne=(Button) root.findViewById(R.id.one);
        buttonOne.setOnClickListener(this);
        buttonTwo=(Button) root.findViewById(R.id.two);
        buttonTwo.setOnClickListener(this);
        buttonThree=(Button) root.findViewById(R.id.three);
        buttonThree.setOnClickListener(this);
        buttonFour=(Button) root.findViewById(R.id.four);
        buttonFour.setOnClickListener(this);
        buttonFive=(Button) root.findViewById(R.id.five);
        buttonFive.setOnClickListener(this);
        buttonSix=(Button) root.findViewById(R.id.six);
        buttonSix.setOnClickListener(this);
        buttonSeven=(Button) root.findViewById(R.id.seven);
        buttonSeven.setOnClickListener(this);
        buttonEight=(Button) root.findViewById(R.id.eight);
        buttonEight.setOnClickListener(this);
        buttonNine=(Button) root.findViewById(R.id.nine);
        buttonNine.setOnClickListener(this);
        buttonDot=(Button) root.findViewById(R.id.dot);
        buttonDot.setOnClickListener(this);
        buttonSign=(Button) root.findViewById(R.id.sign);
        buttonSign.setOnClickListener(this);
        buttonEquals=(Button) root.findViewById(R.id.sum);
        buttonEquals.setOnClickListener(this);
        buttonBracket=(Button) root.findViewById(R.id.bracket);
        buttonBracket.setOnClickListener(this);
        buttonAdd=(Button) root.findViewById(R.id.addition);
        buttonAdd.setOnClickListener(this);
        buttonSubtract=(Button) root.findViewById(R.id.subtract);
        buttonSubtract.setOnClickListener(this);
        buttonDivision=(Button) root.findViewById(R.id.division);
        buttonDivision.setOnClickListener(this);
        buttonMultiplication=(Button) root.findViewById(R.id.muliplication);
        buttonMultiplication.setOnClickListener(this);
        buttonDelete=(Button) root.findViewById(R.id.delete);
        buttonDelete.setOnClickListener(this);
        buttonCancel=(Button) root.findViewById(R.id.cacncel);
        buttonCancel.setOnClickListener(this);
        return root;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            parseValue = (ValueParsingListner) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnFileSelectedListener");
        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.zero:
                parseValue.passOprands(Integer.parseInt(buttonZero.getText().toString()));
                //Toast.makeText(getActivity(), "zero", Toast.LENGTH_SHORT).show();
                break;

            case R.id.one:
                parseValue.passOprands(1);
                //Toast.makeText(getActivity(), "one", Toast.LENGTH_SHORT).show();
                break;

            case R.id.two:
                parseValue.passOprands(2);
                break;

            case R.id.three:
                parseValue.passOprands(3);
                break;

            case R.id.four:
                parseValue.passOprands(4);
                break;
            case R.id.five:
                parseValue.passOprands(5);
                break;
            case R.id.six:
                parseValue.passOprands(6);
                break;
            case R.id.seven:
                parseValue.passOprands(7);
                break;
            case R.id.eight:
                parseValue.passOprands(8);
                break;
            case R.id.nine:
                parseValue.passOprands(9);
                break;


            case R.id.dot:
                parseValue.passOperator('.');
                break;
            case R.id.sign:
                parseValue.passOperator('s');
                break;
            case R.id.sum:
                parseValue.passOperator('=');
                break;
            case R.id.bracket:
                parseValue.passOperator('(');
                break;
            case R.id.addition:
                parseValue.passOperator('+');
                break;
            case R.id.subtract:
                parseValue.passOperator('-');
                break;
            case R.id.division:
                parseValue.passOperator('/');
                break;
            case R.id.muliplication:
                parseValue.passOperator('*');
                break;
            case R.id.delete:
                parseValue.passOperator('d');
                break;
            case R.id.cacncel:
                parseValue.passOperator('c');
                break;
        }
    }
}
