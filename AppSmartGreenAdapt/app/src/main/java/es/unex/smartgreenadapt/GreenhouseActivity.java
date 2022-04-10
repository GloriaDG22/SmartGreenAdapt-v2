package es.unex.smartgreenadapt;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import es.unex.smartgreenadapt.ui.information.InformationFragment;
import es.unex.smartgreenadapt.ui.login.LoginActivity;
import es.unex.smartgreenadapt.ui.notifications.NotificationsFragment;
import es.unex.smartgreenadapt.ui.state.StateFragment;


public class GreenhouseActivity extends AppCompatActivity {
    public static final String EXTRA_GREENHOUSE = "ID_GREENHOUSE";
    Toolbar toolbar;
    BottomNavigationView bottomBar;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Parte superior de la pantalla
        toolbar = findViewById(R.id.toolbar_general);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        View logoView = toolbar.getChildAt(0);
        logoView.setOnClickListener(v -> {
            cargarFragment(new InformationFragment());
            bottomBar.setSelectedItemId(R.id.navigation_information);
        });

        // Parte inferior de la pantalla
        bottomBar = findViewById(R.id.nav_view);
        bottomBar.setOnItemSelectedListener(menuItem -> {
            Fragment fragment = null;
            switch (menuItem.getItemId()) {
                case R.id.navigation_information:
                    fragment = new InformationFragment();
                    break;

                case R.id.navigation_state:
                    fragment = new StateFragment();
                    break;

                case R.id.navigation_notifications:
                    fragment = new NotificationsFragment();
                    break;
            }
            return cargarFragment(fragment);
        });
        bottomBar.setSelectedItemId(R.id.navigation_information);
    }

    // Carga los fragment del main activity
    private boolean cargarFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case (R.id.action_profile):
                executeProfile();
                return false;
            case (R.id.action_logout):
                executeLogout();
                return true;
            case (R.id.action_about):
                executeAbout();
                return true;
            case (android.R.id.home):
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    // Activity setting
    public void executeAbout(){
        Intent i = new Intent(this, About.class);
        startActivity(i);
    }

    // Activity profile
    public void executeProfile(){
        Intent i = new Intent(this, Profile.class);
        startActivity(i);
    }

    //Activity login
    private void executeLogout() {
        //TODO logout
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);

        finish();
        finish();
    }
}