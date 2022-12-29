package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.wa:
                Uri uri = Uri.parse("smsto:" + "085640748658");
                Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
                return true;
            case R.id.sms:
                String sms = "tel:085640748658";
                startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse(sms)));
                return true;
            case R.id.loc:
                Intent mapIntent = (new Intent(Intent.ACTION_VIEW, Uri.parse("geo:DroidCafe")));
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                return true;
            case R.id.update:
                startActivity(new Intent(getBaseContext(), com.example.loginsqlite.UpdateActivity.class));
                return true;
            case R.id.logout:
                //logout dari aplikasi
                startActivity(new Intent(getBaseContext(), com.example.loginsqlite.MainActivity.class));
                return true;
        }return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}