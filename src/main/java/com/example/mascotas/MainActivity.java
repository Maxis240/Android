package com.example.mascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mascotas.POJO.Contacto;
import com.example.mascotas.adapter.ContactoAdaptador;
import com.example.mascotas.adapter.PageAdapter;
import com.example.mascotas.fragment.PerfilFragment;
import com.example.mascotas.fragment.RecyclerViewFragment;
import com.google.android.material.tabs.TabLayout;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
        registerForContextMenu(tvNombre);
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menudeopciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                Intent intent = new Intent(this, ActivityAbout.class);
                startActivity(intent);
                break;
            case R.id.mSettings:
                Intent intent2 = new Intent(this, ActivitySettings.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = new MenuInflater(this);
        getMenuInflater().inflate(R.menu.menudecontexto, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mEdit:
                // Intent
                Toast.makeText(this, getResources().getString(R.string.menu_edit), Toast.LENGTH_SHORT).show();
                break;
            case R.id.mDelete:
                // Intent
                Toast.makeText(this, getResources().getString(R.string.menu_delete), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void levantarMenuPoPup(View v){
        ImageView imagen = (ImageView) findViewById(R.id.imgImagen);
        PopupMenu popupMenu = new PopupMenu(this, imagen);
        popupMenu.getMenuInflater().inflate(R.menu.menupopup, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mView:
                        Toast.makeText(getBaseContext(), getResources().getString(R.string.menu_view), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.mViewDetail:
                        Toast.makeText(getBaseContext(), getResources().getString(R.string.menu_detail), Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.calendar);
        tabLayout.getTabAt(1).setIcon(R.drawable.perro);
    }
    /* checks if external storage is available for read and write */
    public boolean isExternalStorageWritable(){
        String state= Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            return true;
        }
        return false;
    }
    /* checks if external storage is available to at least read */
    public boolean isExternalStorageReadable(){
        String state= Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            return true;
        }
        return false;
    }
    /*
        public void irSegundaActividad(View v) {
            Intent intent = new Intent(this, DetalleContacto.class);
            startActivity(intent);
        }
    */
}
