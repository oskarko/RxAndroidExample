package es.org.rxbusexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * @autor Óscar Rodríguez <oscar.garrucho@gmail.com>
 * @since 19/3/16 12:21
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fragment fragmentOne = new FragmentOne();
        Fragment fragmentTwo = new FragmentTwo();

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.Container_1, fragmentOne).commit();
        fm.beginTransaction().add(R.id.Container_2, fragmentTwo).commit();
    }

}