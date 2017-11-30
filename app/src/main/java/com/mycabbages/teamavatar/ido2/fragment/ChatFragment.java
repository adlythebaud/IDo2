package com.mycabbages.teamavatar.ido2.fragment;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraCaptureSession;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;

import com.mycabbages.teamavatar.ido2.R;

/**
 * Created by Preston on 11/17/2017.
 */

public class ChatFragment extends Fragment /*implements View.OnClickListener, ActivityCompat.OnRequestPermissionsResultCallback*/ {
    private String mCameraId;                           //ID of the current mCameraDevice
    private CameraCaptureSession mCaptureSession;       //For camera preview
    private CameraDevice mCameraDevice;                 //A reference to the opened CameraDevice    private String mCameraId;
    private Size mPreviewSize;                          //The size of camera preview

    public static ChatFragment create() { return new ChatFragment();  }

/*    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_empty, container, false);
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstance) {
        view.findViewById(R.id.vmt_center_image).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }*/
}
