package com.vilyever.androidunitconversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.vilyever.vdunitconversion.VDDimenConversion;
import com.vilyever.vdunitconversion.VDTimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VDTimeUnit timeUnit = new VDTimeUnit(41891564);
        System.out.println("time " + timeUnit);
        System.out.println("time " + timeUnit.toString(VDTimeUnit.VDTimeCategory.Hour, VDTimeUnit.VDTimeCategory.Millisecond));
        System.out.println("time " + timeUnit.toString(VDTimeUnit.VDTimeCategory.Second, VDTimeUnit.VDTimeCategory.Hour));

        int px = VDDimenConversion.dpToPixel(18);
        int dp = VDDimenConversion.pixelToDp(18);
        px = VDDimenConversion.spToPixel(18);
        int sp = VDDimenConversion.pixelToSp(18);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
