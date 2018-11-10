package dan.naveen.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends ActionBarActivity {

    Button blogin,registerlink;
    EditText etusername,etpassword;
    Register r=new Register();
    MyDbHandler dbHandler=new MyDbHandler(Login.this);

    ParkProcess_act p=new ParkProcess_act();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         etusername = (EditText) findViewById(R.id.etUsername);
        etpassword = (EditText) findViewById(R.id.etpassword);
        blogin = (Button) findViewById(R.id.blogin);
        registerlink=(Button) findViewById(R.id.registerlink);
 }



   public void bloginclicked(View view) throws Exception {

        String username = etusername.getText().toString();
        String password = etpassword.getText().toString();
        Boolean sp;



       if (dbHandler.Login(username, password))
           sp = true;
       else
           sp = false;
       try{
           if(username.length() > 0 && password.length() >0) {
               if (sp) {
                   Toast.makeText(Login.this, "Login Successfull", Toast.LENGTH_LONG).show();
                    String op=dbHandler.getSinlgeEntry(username);
                   Intent a=new Intent(Login.this,ParkProcess_act.class);
                   a.putExtra("id",op);
                   a.putExtra("un",username);
                   startActivity(a);

               }
               else
                   {
                       Toast.makeText(Login.this, "Invalid UserName/Password", Toast.LENGTH_LONG).show();
                   }

           }
                else
                {
                    Toast.makeText(Login.this, "UserName/Password cannot be blank", Toast.LENGTH_LONG).show();
                }




        }catch(Exception e)
        {
            Toast.makeText(Login.this,e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void signupclicked(View view)
    {

        startActivity(new Intent(this,Register.class));
    }
}
