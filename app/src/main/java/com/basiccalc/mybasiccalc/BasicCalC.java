package com.basiccalc.mybasiccalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

public class BasicCalC extends AppCompatActivity  {

    
    public Button btnAdd, btnSub, btnDiv, btnMul, btnRes, btnClear;
    public TextView expressionHistory, resultPane;
    String num="0",exp="",display="",functionResult="0";
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
        resultPane = (TextView) findViewById(R.id.resultPane);
        expressionHistory = (TextView) findViewById(R.id.expressionHistory);

    }

    public void onClickNumber (View view) {
        Button b = (Button) view;
        display += b.getText().toString();
        resultPane.setText(display);
    }

    public void onClickOperator (View view) {
        switch (view.getId()) {
            case R.id.btnAdd:
                if(num.equals(functionResult)) {
                    num = resultPane.getText().toString();
                    exp = exp.concat(num);
                }
                exp=exp.concat(" + ");
                num = resultPane.getText().toString();
                resultPane.setText("");
                operator=1;
                expressionHistory.setText(exp);
                display="";
                break;
            case R.id.btnSub:
                if(num.equals(functionResult)) {
                    num = resultPane.getText().toString();
                    exp = exp.concat(num);
                }
                exp=exp.concat(" - ");
                num = resultPane.getText().toString();
                resultPane.setText("");
                expressionHistory.setText(exp);
                display="";
                operator=2;
                break;
            case R.id.btnDiv:
                if(num.equals(functionResult)) {
                    num = resultPane.getText().toString();
                    exp = exp.concat(num);
                }
                exp=exp.concat(" / ");
                num = resultPane.getText().toString();
                resultPane.setText("");
                expressionHistory.setText(exp);
                display="";
                operator=4;
                break;
            case R.id.btnMul:
                if(num.equals(functionResult)) {
                    num = resultPane.getText().toString();
                    exp = exp.concat(num);
                }
                exp=exp.concat(" x ");
                num = resultPane.getText().toString();
                resultPane.setText("");
                expressionHistory.setText(exp);
                display="";
                operator=3;
                break;
            case R.id.btnRes:
                functionResult = resultPane.getText().toString();
                switch (operator) {
                    case 1:
                        exp=exp.concat(String.valueOf(functionResult));
                        expressionHistory.setText(exp);
                        functionResult = String.valueOf(Float.parseFloat(num) + Float.parseFloat(functionResult));
                        break;
                    case 2:
                        exp=exp.concat(String.valueOf(functionResult));
                        expressionHistory.setText(exp);
                        functionResult = String.valueOf(Float.parseFloat(num) - Float.parseFloat(functionResult));
                        break;
                    case 3:
                        exp=exp.concat(String.valueOf(functionResult));
                        expressionHistory.setText(exp);
                        functionResult = String.valueOf(Float.parseFloat(num) * Float.parseFloat(functionResult));
                        break;
                    case 4:
                        exp=exp.concat(String.valueOf(functionResult));
                        expressionHistory.setText(exp);
                        functionResult = String.valueOf(Float.parseFloat(num) / Float.parseFloat(functionResult));
                        break;
                }
                resultPane.setText(functionResult);
                display="";
                break;
            case R.id.btnClear:
                resultPane.setText("0");
                expressionHistory.setText("00");
                exp=display="";
                num="0";
                functionResult = "0";
                break;
        }
    }
}