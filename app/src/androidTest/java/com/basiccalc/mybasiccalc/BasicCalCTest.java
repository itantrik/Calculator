package com.basiccalc.mybasiccalc;

import android.test.ActivityInstrumentationTestCase2;
//import android.test.suitebuilder.annotation.LargeTest;
//import android.widget.Button;
import android.widget.Button;
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

        solo.unlockScreen();

        solo.clickOnView(solo.getView(R.id.btn1));
        solo.clickOnView(solo.getView(R.id.btn2));

        solo.clickOnView(solo.getView(R.id.btnAdd));

        solo.clickOnView(solo.getView(R.id.btn3));
        solo.clickOnView(solo.getView(R.id.btn4));

        float num1=12, num2=34;
        float testResult = num1 + num2;

        solo.clickOnButton("=");

        TextView output = (TextView)solo.getView(R.id.viewNum);
        assertEquals(String.valueOf(testResult),output.getText().toString());
    }

    public void testForSubtraction() {

        solo.clickOnView(solo.getView(R.id.btn5));
        solo.clickOnView(solo.getView(R.id.btn6));

        solo.clickOnView(solo.getView(R.id.btnSub));

        solo.clickOnView(solo.getView(R.id.btn7));
        solo.clickOnView(solo.getView(R.id.btn8));

        float num1=56, num2=78;
        float testResult = num1 - num2;

        solo.clickOnButton("=");

        TextView output = (TextView)solo.getView(R.id.viewNum);
        assertEquals(String.valueOf(testResult),output.getText().toString());

    }

    public void testForMultiplication() {

        solo.clickOnView(solo.getView(R.id.btn9));
        solo.clickOnView(solo.getView(R.id.btn0));

        solo.clickOnView(solo.getView(R.id.btnMul));

        solo.clickOnView(solo.getView(R.id.btn1));
        solo.clickOnView(solo.getView(R.id.btn8));

        float num1=90, num2=18;
        float testResult = num1 * num2;

        solo.clickOnButton("=");

        TextView output = (TextView)solo.getView(R.id.viewNum);
        assertEquals(String.valueOf(testResult),output.getText().toString());
    }

    public void testForDivision() {
        solo.clickOnView(solo.getView(R.id.btn4));
        solo.clickOnView(solo.getView(R.id.btn6));

        solo.clickOnView(solo.getView(R.id.btnDiv));

        solo.clickOnView(solo.getView(R.id.btn8));
        solo.clickOnView(solo.getView(R.id.btn2));

        float num1=46, num2=82;
        float testResult = num1 / num2;

        solo.clickOnButton("=");

        TextView output = (TextView)solo.getView(R.id.viewNum);
        assertEquals(String.valueOf(testResult),output.getText().toString());

    }

    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }
}