package gatsan.vehicletracker;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;

import gatsan.vehicletracker.models.user;

import static android.content.ContentValues.TAG;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button login = null;
    String e;
    String pass;
    EditText email, password;
    TCPClient mTcpClient;
    static user cuser;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.email_sign_in_button);
        login.setOnClickListener(this);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        new connector().execute("");

    }

    public void handleMessage(String msg, Context c)
    {
        String[] info = msg.split(",");
        if(info[0].equals("ui"))
        {
            cuser = new user();
            cuser.setName(info[1]);
            cuser.setEmail(info[2]);
            cuser.setPhone(info[3]);
            cuser.setExpirationTime(info[4]);
            //Toast.makeText(c, "logged in", Toast.LENGTH_LONG).show();
        }
        if(info[0].equals("al"))
        {
            Toast.makeText(c, "already logged in", Toast.LENGTH_LONG).show();
        }
        if(info[0].equals("inc"))
        {
            Toast.makeText(c, "wrong un or pass", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.email_sign_in_button:
                e = email.getText().toString();
                pass = password.getText().toString();
                showMessage("Email: " + e + "\nPassword: " + pass);
        }
    }

    private void showMessage(String msg)
    {
        if(mTcpClient != null)
        {
            mTcpClient.sendMessage("li,"+e+","+pass);
            Toast.makeText(this, "li,"+e+","+pass, Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Unable to connect to server", Toast.LENGTH_LONG).show();
        }
    }

    private void getDevices()
    {
        if(mTcpClient != null)
        {
            mTcpClient.sendMessage("info,devices");
        }
    }

    public class connector extends AsyncTask<String, String, TCPClient> {

        @Override
        protected TCPClient doInBackground(String... message) {

            //we create a TCPClient object
            mTcpClient = new TCPClient(new TCPClient.OnMessageReceived() {
                @Override
                //here the messageReceived method is implemented
                public void messageReceived(String message) {
                    //this method calls the onProgressUpdate
                    publishProgress(message);
                }
            });
            mTcpClient.run();

            return null;
        }

        @Override
        protected void onProgressUpdate(final String... values) {
            super.onProgressUpdate(values);
            String[] info = values[0].split(",");
            if(info[0].equals("ui"))
            {
                cuser = new user();
                cuser.setName(info[1]);
                cuser.setEmail(info[2]);
                cuser.setPhone(info[3]);
                cuser.setExpirationTime(info[4]);
                Intent main = new Intent(getBaseContext(), main.class);
                startActivity(main);
                //Toast.makeText(c, "logged in", Toast.LENGTH_LONG).show();
            }
        }

    }
}
