package com.example.tinder_roush.Register;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.Register3Data;
import com.example.tinder_roush.Objects.RegisterResponse;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class FragmentRegister3 extends Fragment implements RegisterInterfaces.fragment3{

    Context context;
    Button back_to_r2, next_r4;
    ImageButton photo1, photo2, photo3, photo4, photo5, photo6;
    String currentPhotoPath, UrlPhoto1, UrlPhoto2, UrlPhoto3, UrlPhoto4, UrlPhoto5, UrlPhoto6, idPerson;
    Register3Data register3Data;
    RegisterPresenters presenter;
    boolean principal;
    public int RESULT_PHOTO = 100;
    public final int RESULT_PHOTO_1 = 101;
    public final int RESULT_PHOTO_2 = 102;
    public final int RESULT_PHOTO_3 = 103;
    public final int RESULT_PHOTO_4 = 104;
    public final int RESULT_PHOTO_5 = 105;
    public final int RESULT_PHOTO_6 = 106;
    LocalData localData;
    int REQUEST_CODE = 200;

    public FragmentRegister3() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_3, container, false);
        context = view.getContext();
        initObjets(view);
        ActivatePermissions();
        listener();
        return view;
    }

    private void initObjets(View view) {
        idPerson = "";
        UrlPhoto1 = "";
        UrlPhoto2 = "";
        UrlPhoto3 = "";
        UrlPhoto4 = "";
        UrlPhoto5 = "";
        UrlPhoto6 = "";
        principal = true;
        back_to_r2 = view.findViewById(R.id.back_r3_button);
        next_r4 = view.findViewById(R.id.next_r3_button);
        photo1 = view.findViewById(R.id.photo_1_register);
        photo2 = view.findViewById(R.id.photo_2_register);
        photo3 = view.findViewById(R.id.photo_3_register);
        photo4 = view.findViewById(R.id.photo_4_register);
        photo5 = view.findViewById(R.id.photo_5_register);
        photo6 = view.findViewById(R.id.photo_6_register);
        localData=new LocalData();
        presenter=new RegisterPresenters(null, null, this, null);
    }

    public void listener(){
        back_to_r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentRegister2 Register2 = new FragmentRegister2();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.login_view, Register2);
                transaction.commit();
            }
        });
        next_r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UrlPhoto1.isEmpty()){
                    Toast.makeText(BaseContext.getContext(),"Agrega una foto para tu perfil",Toast.LENGTH_SHORT).show();
                    return;
                }
                register3();
            }
        });
        photo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RESULT_PHOTO = RESULT_PHOTO_1;
                getImageFromAlbum();

            }
        });
        photo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RESULT_PHOTO = RESULT_PHOTO_2;
                getImageFromAlbum();
            }
        });
        photo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RESULT_PHOTO = RESULT_PHOTO_3;
                getImageFromAlbum();
            }
        });
        photo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RESULT_PHOTO = RESULT_PHOTO_4;
                getImageFromAlbum();
            }
        });
        photo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RESULT_PHOTO = RESULT_PHOTO_5;
                getImageFromAlbum();
            }
        });
        photo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RESULT_PHOTO = RESULT_PHOTO_6;
                getImageFromAlbum();
            }
        });
    }

    private void getImageFromAlbum() {
        try {
            Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, RESULT_PHOTO);
        } catch (Exception exp) {
            Log.i("Error", exp.toString());
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == RESULT_PHOTO_1 && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            currentPhotoPath = getPath(selectedImage);
            Bitmap bitmap= BitmapFactory.decodeFile(currentPhotoPath);
            photo1.setImageBitmap(bitmap);
            UrlPhoto1 = currentPhotoPath;
            localData.register(currentPhotoPath, "Image1");
            Log.e("PATH PICKED IMAGE_1", currentPhotoPath);
        }
        if (requestCode == RESULT_PHOTO_2 && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            currentPhotoPath = getPath(selectedImage);
            Bitmap bitmap= BitmapFactory.decodeFile(currentPhotoPath);
            photo2.setImageBitmap(bitmap);
            UrlPhoto2 = currentPhotoPath;
            localData.register(currentPhotoPath, "Image2");
            Log.e("PATH PICKED IMAGE_2", currentPhotoPath);
        }
        if (requestCode == RESULT_PHOTO_3 && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            currentPhotoPath = getPath(selectedImage);
            Bitmap bitmap= BitmapFactory.decodeFile(currentPhotoPath);
            photo3.setImageBitmap(bitmap);
            UrlPhoto3 = currentPhotoPath;
            localData.register(currentPhotoPath, "Image3");
            Log.e("PATH PICKED IMAGE_3", currentPhotoPath);
        }
        if (requestCode == RESULT_PHOTO_4 && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            currentPhotoPath = getPath(selectedImage);
            Bitmap bitmap= BitmapFactory.decodeFile(currentPhotoPath);
            photo4.setImageBitmap(bitmap);
            UrlPhoto4 = currentPhotoPath;
            localData.register(currentPhotoPath, "Image4");
            Log.e("PATH PICKED IMAGE_4", currentPhotoPath);
        }
        if (requestCode == RESULT_PHOTO_5 && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            currentPhotoPath = getPath(selectedImage);
            Bitmap bitmap= BitmapFactory.decodeFile(currentPhotoPath);
            photo5.setImageBitmap(bitmap);
            UrlPhoto5 = currentPhotoPath;
            localData.register(currentPhotoPath, "Image5");
            Log.e("PATH PICKED IMAGE_5", currentPhotoPath);
        }
        if (requestCode == RESULT_PHOTO_6 && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            currentPhotoPath = getPath(selectedImage);
            Bitmap bitmap= BitmapFactory.decodeFile(currentPhotoPath);
            photo6.setImageBitmap(bitmap);
            UrlPhoto6 = currentPhotoPath;
            localData.register(currentPhotoPath, "Image6");
            Log.e("PATH PICKED IMAGE_6", currentPhotoPath);

        }
    }


    public String getPath(Uri uri) {

        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = getActivity().managedQuery(uri, projection, null, null, null);
      //  Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();

        return cursor.getString(column_index);
    }

    public void performRegisterFinal(){
        FragmentRegister4 Register4 = new FragmentRegister4();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.login_view, Register4);
        transaction.commit();
    }

    @Override
    public void register3() {
        register3Data = new Register3Data(currentPhotoPath);
        presenter.register3Presenters(register3Data);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void ActivatePermissions(){
        int storagePermission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int storagePermission2 = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (storagePermission == PackageManager.PERMISSION_GRANTED && storagePermission2 == PackageManager.PERMISSION_GRANTED){
            Log.e("Permiso", String.valueOf(storagePermission));
        }else {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE);
        }
    }

}