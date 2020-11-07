package com.artyushin.hw122;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_PERMISSION_READ_STORAGE = 10;
    private String fileName;
    private NameImage file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        Button bSaveSetting = findViewById (R.id.setting);
        bSaveSetting.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, SettingActivity.class);
                startActivity (intent);
            }
        });

        calculator ( );
    }

    protected void onRestart() {
        super.onRestart ( );

        file = new NameImage ();
        fileName = file.toString ();

        int permissionStatus = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE);

        if (permissionStatus == PackageManager.PERMISSION_GRANTED) {
            try {
                LoadImg(fileName);
            } catch (FileNotFoundException e) {
                Toast.makeText(this, "Ошибка загрузки", Toast.LENGTH_LONG).show();
                e.printStackTrace ( );
            } catch (IOException e) {
                Toast.makeText(this, "Ошибка загрузки", Toast.LENGTH_LONG).show();
                e.printStackTrace ( );
            }
        }
        else
        {
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_CODE_PERMISSION_READ_STORAGE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_PERMISSION_READ_STORAGE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    file = new NameImage ();
                    fileName = file.toString ();
                    try {
                        LoadImg(fileName);
                    } catch (FileNotFoundException e) {
                        Toast.makeText(this, "Ошибка загрузки", Toast.LENGTH_LONG).show();
                        e.printStackTrace ( );
                    } catch (IOException e) {
                        Toast.makeText(this, "Ошибка загрузки", Toast.LENGTH_LONG).show();
                        e.printStackTrace ( );
                    }
                } else {
                    Toast.makeText(this, "Отказано в доступе", Toast.LENGTH_LONG).show();
                }
                return;
        }
    }

    public void LoadImg(String fileName) throws IOException {

        ImageView view = (ImageView) findViewById(R.id.imageView);
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);
        if (!file.exists()) { Toast.makeText(this, "Файл отстутствует", Toast.LENGTH_LONG).show(); }
        Bitmap b = BitmapFactory.decodeFile(file.getAbsolutePath());
        view.setImageBitmap(b);
    }

    private void calculator() {
        //Собственно 'калькулятор'
        final TextView textview = (TextView) findViewById(R.id.textView);

        Button one = (Button) findViewById(R.id.one);
        Button two = (Button) findViewById(R.id.two);
        Button three = (Button) findViewById(R.id.three);
        Button four = (Button) findViewById(R.id.four);
        Button five = (Button) findViewById(R.id.five);
        Button six = (Button) findViewById(R.id.six);
        Button seven = (Button) findViewById(R.id.seven);
        Button eight = (Button) findViewById(R.id.eight);
        Button nine = (Button) findViewById(R.id.nine);
        Button zero = (Button) findViewById(R.id.zero);
        Button comma = (Button) findViewById(R.id.comma);
        Button clear = (Button)findViewById(R.id.clear);
        Button negative = (Button)findViewById(R.id.negative);
        Button percentage = (Button)findViewById(R.id.percentage);
        Button div = (Button)findViewById(R.id.division);
        Button mul = (Button)findViewById(R.id.mul);
        Button sub = (Button)findViewById(R.id.sub);
        Button add = (Button)findViewById(R.id.plus);
        Button equally = (Button)findViewById(R.id.equally);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.append("1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.append("2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.append("3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.append("4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.append("5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.append("6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.append("7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.append("8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.append("9");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.append("0");
            }
        });

        comma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.append(",");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText("");
            }
        });
    }
}