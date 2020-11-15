package com.example.collegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.collegeapp.ui.about.AboutFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        navController= Navigation.findNavController(this,R.id.frame_layout);

        drawerLayout=findViewById(R.id.drawerlayout);
        navigationView=findViewById(R.id.navigation_view);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);



        NavigationUI.setupWithNavController(bottomNavigationView,navController);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;

        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_developer:
                Toast.makeText(this, "Developer", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_notice:
                Toast.makeText(this, "Notice", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_share:
                try{
                    Intent i=new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT,"City University");
                    i.putExtra(Intent.EXTRA_TEXT,"");
                    startActivity(Intent.createChooser(i,"Share with"));
                    Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    Toast.makeText(this, "Unable to Share", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.navigation_ebook:
                Intent inten=new Intent(MainActivity.this, Academiesnavigation.class);
                startActivity(inten);
                break;
            case R.id.navigation_rate_us:
                Toast.makeText(this, "Admission", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_video:
                Intent intent=new Intent(MainActivity.this, Aboutnavigation.class);
                startActivity(intent);
                break;
            case R.id.navigation_theme:
                Intent intent1=new Intent(MainActivity.this, Faculties_navigation.class);
                startActivity(intent1);
                break;
            case R.id.navigation_website:
                Toast.makeText(this, "Website", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}