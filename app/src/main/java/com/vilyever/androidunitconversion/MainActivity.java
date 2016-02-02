package com.vilyever.androidunitconversion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.vilyever.contextholder.VDContextHolder;
import com.vilyever.unitconversion.VDDimenConversion;
import com.vilyever.unitconversion.VDTimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VDContextHolder.initial(getApplicationContext());

        VDTimeUnit timeUnit = new VDTimeUnit(41891564);
        System.out.println("time " + timeUnit);
        System.out.println("time " + timeUnit.convertToString(VDTimeUnit.VDTimeCategory.Hour, VDTimeUnit.VDTimeCategory.Millisecond));
        System.out.println("time " + timeUnit.convertToString(VDTimeUnit.VDTimeCategory.Second, VDTimeUnit.VDTimeCategory.Hour));

        int px = VDDimenConversion.dpToPixel(18);
        int dp = VDDimenConversion.pixelToDp(px);
        System.out.println("px " + px + " : dp " + dp);
        px = VDDimenConversion.spToPixel(20);
        int sp = VDDimenConversion.pixelToSp(px);
        System.out.println("px " + px + " : sp " + sp);

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
