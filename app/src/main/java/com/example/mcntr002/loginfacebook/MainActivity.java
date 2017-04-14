package com.example.mcntr002.loginfacebook;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    Thread thread;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        thread=new Thread(new Mythread());
        thread.start();
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                progressBar.setProgress(msg.arg1);
            }
        };

    }


    class Mythread implements Runnable{

        public void run()
        {

            for (int i=0;i<100;i++)
            {
                Message message=Message.obtain();
                message.arg1=i;
                handler.sendMessage(message);
                try {
                    thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }

}

