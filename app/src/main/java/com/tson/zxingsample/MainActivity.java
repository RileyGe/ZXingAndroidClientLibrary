package com.tson.zxingsample;

import android.Manifest;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.zxing.client.android.CaptureActivity;
import permissions.dispatcher.*;

import permissions.dispatcher.NeedsPermission;

@RuntimePermissions
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivityPermissionsDispatcher.initWithCheck(this);
        //init();
    }

    @NeedsPermission(Manifest.permission.CAMERA)
    void init() {
        Intent i = new Intent(MainActivity.this,CaptureActivity.class);
        startActivity(i);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // NOTE: delegate the permission handling to generated method
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }
}
