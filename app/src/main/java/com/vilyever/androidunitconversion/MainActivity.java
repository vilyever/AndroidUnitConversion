package com.vilyever.androidunitconversion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.vilyever.unitconversion.DimenConverter;
import com.vilyever.unitconversion.TimeConverter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("from Milliseconds to Minutes " + TimeConverter.convertMillisecondsToMinutes(41891564l));
        System.out.println("from Milliseconds to String " + TimeConverter.convertMillisecondsToString(41891564l, TimeConverter.TimeUnits.Hour, TimeConverter.TimeUnits.Millisecond));
        System.out.println("from Milliseconds to String  " + TimeConverter.convertMillisecondsToString(41891564l, TimeConverter.TimeUnits.Hour, TimeConverter.TimeUnits.Millisecond));

        int px = DimenConverter.dpToPixel(18);
        int dp = DimenConverter.pixelToDp(px);
        System.out.println("px " + px + " : dp " + dp);
        px = DimenConverter.spToPixel(20);
        int sp = DimenConverter.pixelToSp(px);
        System.out.println("px " + px + " : sp " + sp);

    }

}
