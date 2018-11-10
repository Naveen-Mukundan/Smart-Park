package dan.naveen.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Register extends ActionBarActivity {


    Button bregister;
    EditText etfname, etlname, etphone,etusername, etmail, etpassword, etcarcomp, etcarcomp1, etcarnumber;
    MyDbHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etfname = (EditText) findViewById(R.id.etfname);
        etlname = (EditText) findViewById(R.id.etlname);
        etphone = (EditText) findViewById(R.id.etphone);
        etmail = (EditText) findViewById(R.id.etmail);
        etusername = (EditText) findViewById(R.id.us);
        etpassword = (EditText) findViewById(R.id.etpassword);
        etcarcomp = (EditText) findViewById(R.id.etcarcomp);
        etcarcomp1 = (EditText) findViewById(R.id.etcarcomp1);
        etcarnumber = (EditText) findViewById(R.id.etcarnumber);
        bregister = (Button) findViewById(R.id.bregister);


        dbHandler = new MyDbHandler(this);
    }


    public void regbuttonclicked(View view) {

        Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_LONG).show();


        Register1 register1 = new Register1(etfname.getText().toString(),
                etlname.getText().toString(),
              etphone.getText().toString(),
                etusername.getText().toString(),
                etcarnumber.getText().toString(),
                etcarcomp.getText().toString(),
                etcarcomp1.getText().toString(),
                etmail.getText().toString(),
                etpassword.getText().toString());

        dbHandler.add(register1);
        etfname.setText("");
        etlname.setText("");
        etphone.setText("");
        etusername.setText("");
        etcarnumber.setText("");
        etcarcomp.setText("");
        etcarcomp1.setText("");
        etmail.setText("");
        etpassword.setText("");
        startActivity(new Intent(this,Login.class));
    }



}

