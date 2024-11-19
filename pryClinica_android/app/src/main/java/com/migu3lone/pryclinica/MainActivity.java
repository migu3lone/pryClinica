package com.migu3lone.pryclinica;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.migu3lone.pryclinica.databinding.ActivityMainBinding;
import com.migu3lone.pryclinica.ui.login.LoginActivity;
import com.migu3lone.pryclinica.ui.menu.AboutFragment;
import com.migu3lone.pryclinica.ui.menu.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
 // 0 es el índice del primer header

        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        String userRole = intent.getStringExtra("userRole");


        NavigationView naviView = findViewById(R.id.nav_view);
        View headerView = naviView.getHeaderView(0);

        TextView nameTextView = headerView.findViewById(R.id.welcomeTextView);
        TextView roleTextView = headerView.findViewById(R.id.cargoTextView);

        // Asignar valores
        nameTextView.setText(userName);
        roleTextView.setText("Rol: "+userRole);

        Log.d("NavHeader", "HeaderView: " + headerView);
        Log.d("NavHeader", "NameTextView: " + nameTextView);
        Log.d("NavHeader", "RoleTextView: " + roleTextView);




        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_especialidad, R.id.nav_medico, R.id.nav_cita, R.id.nav_paciente)
                //.setDrawerLayout(drawer)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            SettingsFragment dialogFragment = new SettingsFragment();
            dialogFragment.show(getSupportFragmentManager(), "SettingsFragment");
            return true;
        } else if (id == R.id.action_about) {
            AboutFragment dialogFragment = new AboutFragment();
            dialogFragment.show(getSupportFragmentManager(), "AboutFragment");
            /*
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment_content_main, new AboutFragment())
                    //.replace(android.R.id.content, new AboutFragment())
                    .addToBackStack(null)
                    .commit();*/
            return true;
        } else if (id == R.id.action_logout) {
            // Manejar el cierre de sesión
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        // Elimina el estado de inicio de sesión en SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("AppPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", false);
        editor.apply();

        // Redirige al usuario a la pantalla de inicio de sesión
        //Intent intent = new Intent(this, MainActivity.class);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish(); // Finaliza la actividad actual
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}