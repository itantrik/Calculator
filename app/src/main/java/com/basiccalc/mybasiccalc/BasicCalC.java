package com.basiccalc.mybasiccalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

<<<<<<< HEAD
    
    public Button btnAdd, btnSub, btnDiv, btnMul, btnRes, btnClear;
    public TextView expressionHistory, resultPane;
    String num="0",exp="",display="",functionResult="0";
    int operator=0;
=======
public class BasicCalC extends AppCompatActivity {
    private TextView viewNum;
    private String display = "";
    private String currentOperator = "";
    private String result = "";
>>>>>>> local
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calculator);
        viewNum = (TextView)findViewById(R.id.viewNum);
        viewNum.setText(display);
    }

<<<<<<< HEAD
    private void init() {
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnRes = (Button) findViewById(R.id.btnRes);
        btnClear = (Button) findViewById(R.id.btnClear);
        resultPane = (TextView) findViewById(R.id.resultPane);
        expressionHistory = (TextView) findViewById(R.id.expressionHistory);
=======
    private void updateScreen(){
        viewNum.setText(display);
    }
>>>>>>> local

    public void onClickNumber(View v){
        if(result != ""){
            clear();
            updateScreen();
        }
        Button b = (Button) v;
        display += b.getText();
        updateScreen();
    }

<<<<<<< HEAD
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
=======
    private boolean isOperator(char op){
        switch (op){
            case '+':
            case '-':
            case 'x':
            case '÷':return true;
            default: return false;
        }
    }

    public void onClickOperator(View v){
        if(display == "") return;

        Button b = (Button)v;

        if(result != ""){
            String _display = result;
            clear();
            display = _display;
>>>>>>> local
        }

        if(currentOperator != ""){
            Log.d("CalcX", ""+display.charAt(display.length()-1));
            if(isOperator(display.charAt(display.length()-1))){
                display = display.replace(display.charAt(display.length()-1), b.getText().charAt(0));
                updateScreen();
                return;
            }else{
                getResult();
                display = result;
                result = "";
            }
            currentOperator = b.getText().toString();
        }
        display += b.getText();
        currentOperator = b.getText().toString();
        updateScreen();
    }

    private void clear(){
        display = "";
        currentOperator = "";
        result = "";
    }

    public void onClickClear(View v){
        clear();
        updateScreen();
    }

    private double operate(String a, String b, String op){
        switch (op){
            case "+": return Double.valueOf(a) + Double.valueOf(b);
            case "-": return Double.valueOf(a) - Double.valueOf(b);
            case "x": return Double.valueOf(a) * Double.valueOf(b);
            case "÷": try{
                return Double.valueOf(a) / Double.valueOf(b);
            }catch (Exception e){
                Log.d("Calc", e.getMessage());
            }
            default: return -1;
        }
    }

    private boolean getResult(){
        if(currentOperator == "") return false;
        String[] operation = display.split(Pattern.quote(currentOperator));
        if(operation.length < 2) return false;
        result = String.valueOf(operate(operation[0], operation[1], currentOperator));
        return true;
    }

    public void onClickEqual(View v){
        if(display == "") return;
        if(!getResult()) return;
        viewNum.setText(display + "\n" + String.valueOf(result));
    }
}
