package gdg.spanish.themoviedb;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gdg.spanish.themoviedb.Models.Movie;
import gdg.spanish.themoviedb.Services.TheMovieDbService;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoaderCallbacks<Cursor> {
    private final String BASE_URL = "https://api.themoviedb.org/3";
    private final String APP_KEY = "78536a9e51501eed828af40186b75349";
    /**
     * Id to identity READ_CONTACTS permission request.
     */

    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    public static String UID = "";
    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
      //  List<Movie> elements = SearchMovies(0,"Superman");
        Firebase.setAndroidContext(this);
        // Set up the login form.
        mEmailView = (EditText) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {

                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        Button mEmailSignUpButton = (Button) findViewById(R.id.email_sign_up_button);

        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailToCheck = mEmailView.getText().toString();
                String passToCheck = mPasswordView.getText().toString();

                Firebase ref = new Firebase("https://intense-fire-6233.firebaseio.com/");

                ref.authWithPassword(emailToCheck, passToCheck, new Firebase.AuthResultHandler() {
                    public void onAuthenticated(AuthData authData) {
                        String uid = authData.getUid();
                        UID = uid;
                        changeActivity();
                    }

                    public void onAuthenticationError(FirebaseError error) {

                        showErrorToast(R.string.loging_error);
                    }
                });


            }
        });

        mEmailSignUpButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final String emailToCheck = mEmailView.getText().toString();
                String passToCheck = mPasswordView.getText().toString();

                final Firebase ref = new Firebase("https://intense-fire-6233.firebaseio.com/");

                ref.createUser(emailToCheck, passToCheck, new Firebase.ValueResultHandler<Map<String, Object>>() {
                    @Override
                    public void onSuccess(Map<String, Object> stringObjectMap) {
                        String uid = (String) stringObjectMap.get("uid");

                        UID = uid;
                    }

                    @Override
                    public void onError(FirebaseError firebaseError) {
                        showErrorToast(R.string.signup_error);
                    }
                });
            }
        });



        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void changeActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void showErrorToast(int ref) {
        Context context = getApplicationContext();
        CharSequence text = getText(ref);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
/*
    public List<Movie> SearchMovies(int type,String queryString){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TheMovieDbService service = retrofit.create(TheMovieDbService.class);

        Call<List<Movie>> elementsList = null;
        switch(type){
            case 0:
                elementsList = service.getMovies(queryString,APP_KEY);
                break;

            case 1:
                elementsList = service.getSeries(queryString, APP_KEY);
                break;

        }

        return elementsList;
    }*/
}

