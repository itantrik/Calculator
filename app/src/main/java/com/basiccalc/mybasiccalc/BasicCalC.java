package com.basiccalc.mybasiccalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

public class BasicCalC extends AppCompatActivity implements View.OnClickListener {

    public Button btnAdd, btnSub, btnDiv, btnMul, btnRes, btnClear;
    public TextView expression;
    public EditText viewNum;
    String num="0",exp="",functionResult="0";
    int operator=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calculator);
        init();
    }

    private void init() {
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnRes = (Button) findViewById(R.id.btnRes);
        btnClear = (Button) findViewById(R.id.btnClear);
        viewNum = (EditText) findViewById(R.id.viewNum);
        expression = (TextView) findViewById(R.id.expression);

    }

    public void onClickNumber (View view) {

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAdd:
                if(num.equals(functionResult)) {
                    num = viewNum.getText().toString();
                    exp = exp.concat(num);
                }
                exp=exp.concat(" + ");
                num = viewNum.getText().toString();
                viewNum.setText("");
                operator=1;
                break;
            case R.id.btnSub:
                if(num.equals(functionResult)) {
                    num = viewNum.getText().toString();
                    exp = exp.concat(num);
                }
                exp=exp.concat(" - ");
                num = viewNum.getText().toString();
                viewNum.setText("");
                operator=2;
                break;
            case R.id.btnDiv:
                if(num.equals(functionResult)) {
                    num = viewNum.getText().toString();
                    exp = exp.concat(num);
                }
                exp=exp.concat(" / ");
                num = viewNum.getText().toString();
                viewNum.setText("");
                operator=4;
                break;
            case R.id.btnMul:
                if(num.equals(functionResult)) {
                    num = viewNum.getText().toString();
                    exp = exp.concat(num);
                }
                exp=exp.concat(" x ");
                num = viewNum.getText().toString();
                viewNum.setText("");
                operator=3;
                break;
            case R.id.btnRes:
                functionResult = viewNum.getText().toString();
                switch (operator) {
                    case 1:
                        exp=exp.concat(String.valueOf(functionResult));
                        expression.setText(exp);
                        functionResult = String.valueOf(Float.parseFloat(num) + Float.parseFloat(functionResult));
                        break;
                    case 2:
                        exp=exp.concat(String.valueOf(functionResult));
                        expression.setText(exp);
                        functionResult = String.valueOf(Float.parseFloat(num) - Float.parseFloat(functionResult));
                        break;
                    case 3:
                        exp=exp.concat(String.valueOf(functionResult));
                        expression.setText(exp);
                        functionResult = String.valueOf(Float.parseFloat(num) * Float.parseFloat(functionResult));
                        break;
                    case 4:
                        exp=exp.concat(String.valueOf(functionResult));
                        expression.setText(exp);
                        functionResult = String.valueOf(Float.parseFloat(num) / Float.parseFloat(functionResult));
                        break;
                }
                viewNum.setText(functionResult);
                break;
            case R.id.btnClear:
                viewNum.setText("");
                expression.setText("");
                exp="";
                num="0";
                functionResult = "0";
                break;
        }
    }
}