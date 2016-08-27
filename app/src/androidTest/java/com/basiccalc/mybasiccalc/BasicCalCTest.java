package com.basiccalc.mybasiccalc;

import android.test.ActivityInstrumentationTestCase2;
//import android.test.suitebuilder.annotation.LargeTest;
//import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.robotium.solo.Solo;

/**
 * Created by SGANGWAL on 8/23/2016.
 */
public class BasicCalCTest extends ActivityInstrumentationTestCase2<BasicCalC> {

    private Solo solo;

    public BasicCalCTest() {
        super(BasicCalC.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testForAddition() {
        float firstNumber = 10;
        float secondNumber = 20;

        EditText firstEditText = (EditText) solo.getView(R.id.resultPane);
        solo.enterText(firstEditText , String.valueOf(firstNumber));

        EditText secondEditText = (EditText) solo.getView(R.id.viewNum2);
        solo.enterText(secondEditText , String.valueOf(secondNumber));

        float testResult = firstNumber + secondNumber;
        solo.clickOnButton("ADD");

        TextView output = (TextView)solo.getView(R.id.result);
        assertEquals(String.valueOf(testResult),output.getText().toString());
    }

    public void testForSubtraction() {
        float firstNumber = 10;
        float secondNumber = 20;

        EditText firstEditText = (EditText) solo.getView(R.id.resultPane);
        solo.enterText(firstEditText , String.valueOf(firstNumber));

        EditText secondEditText = (EditText) solo.getView(R.id.viewNum2);
        solo.enterText(secondEditText , String.valueOf(secondNumber));

        float testResult = firstNumber - secondNumber;
        solo.clickOnButton("SUB");

        TextView output = (TextView)solo.getView(R.id.result);
        assertEquals(String.valueOf(testResult),output.getText().toString());

    }

    public void testForMultiplication() {
        float firstNumber = 10;
        float secondNumber = 20;

        EditText firstEditText = (EditText) solo.getView(R.id.resultPane);
        solo.enterText(firstEditText , String.valueOf(firstNumber));

        EditText secondEditText = (EditText) solo.getView(R.id.viewNum2);
        solo.enterText(secondEditText , String.valueOf(secondNumber));

        float testResult = firstNumber * secondNumber;
        solo.clickOnButton("MUL");

        TextView output = (TextView)solo.getView(R.id.result);
        assertEquals(String.valueOf(testResult),output.getText().toString());

    }

    public void testForDivision() {
        //float firstNumber = 10;
        //float secondNumber = 4;

        EditText firstEditText = (EditText) solo.getView(R.id.resultPane);
        solo.enterText(firstEditText , "10");

        EditText secondEditText = (EditText) solo.getView(R.id.viewNum2);
        solo.enterText(secondEditText , "20");

        double testResult = 10.0 / 20.0;
        solo.clickOnButton("DIV");

        TextView output = (TextView)solo.getView(R.id.result);
        assertEquals(String.valueOf(testResult),output.getText().toString());

    }

    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }
}