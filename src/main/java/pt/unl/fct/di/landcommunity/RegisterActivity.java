package pt.unl.fct.di.landcommunity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    EditText nameRegister;
    EditText emailRegister;
    EditText usernameRegister;
    EditText phoneRegister;
    EditText cityRegister;
    EditText addressRegister;
    EditText postalCodeRegister;
    EditText nifRegister;
    EditText passwordLogin;
    EditText repasswordLogin;
    Button registerButton;
    CheckBox checkBox;
    Switch switchButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        // loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory()).get(LoginViewModel.class);

        // Register variables
        nameRegister = (EditText) findViewById(R.id.et_nameRegister);
        emailRegister = (EditText) findViewById(R.id.et_emailRegister);
        usernameRegister = (EditText) findViewById(R.id.et_usernameRegister);
        phoneRegister = (EditText) findViewById(R.id.et_phoneRegister);
        cityRegister = (EditText) findViewById(R.id.et_cityRegister);
        addressRegister = (EditText) findViewById(R.id.et_addressRegister);
        postalCodeRegister = (EditText) findViewById(R.id.et_postalCodeRegister);
        nifRegister = (EditText) findViewById(R.id.et_nifRegister);
        passwordLogin = (EditText) findViewById(R.id.et_passwordRegister);
        repasswordLogin = (EditText) findViewById(R.id.et_repasswordRegister);

        checkBox = (CheckBox) findViewById(R.id.et_checkBoxSeePassword);
        registerButton = (Button) findViewById(R.id.btn_register);
        switchButton = (Switch) findViewById(R.id.et_switchRegister);
        final Button goToLoginButton = (Button) findViewById(R.id.goToLoginButton);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    // Show Password
                    passwordLogin.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                else
                    // Hide Password
                    passwordLogin.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    switchButton.setText("Private Profile");
                    switchButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_privacy, 0, 0, 0);
                }
                else {
                    // When is nothing selected, means we have a public profile.
                    switchButton.setText("Public Profile");
                    switchButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_user, 0, 0, 0);
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
                startActivity(new Intent(RegisterActivity.this, MapsActivity.class)); // Register --> Maps
            }
        });

        goToLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class)); // Register --> Login
            }
        });

        // NAME
        nameRegister.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
                checkValidation();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (!isValidLetters(nameRegister))
                    nameRegister.setError("Not a valid name");
            }
        });

        // EMAIL
        emailRegister.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
                checkValidation();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (isEmail(emailRegister) == false)
                    emailRegister.setError("Not a valid email");
            }
        });

        // USERNAME
        usernameRegister.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
                checkValidation();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (isEmpty(usernameRegister))
                    usernameRegister.setError("Not a valid username");
            }
        });

        // PHONE NUMBER
        phoneRegister.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
                checkValidation();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(isPhone(phoneRegister) == false)
                    phoneRegister.setError("Not a valid phone number");
                else
                if(!isValidPortuguesePhoneNumber(phoneRegister))
                    phoneRegister.setError("Please enter a valid portuguese phone number");
            }
        });

        // CITY
        cityRegister.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
                checkValidation();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (!isValidLetters(cityRegister))
                    cityRegister.setError("Not a valid city");
            }
        });

        // ADDRESS
        addressRegister.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
                checkValidation();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (isEmpty(addressRegister))
                    addressRegister.setError("Not a valid address");
            }
        });

        // POSTAL CODE
        postalCodeRegister.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
                checkValidation();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(postalCodeRegister.length() != 8)
                    postalCodeRegister.setError("Postal code must have 8 characters");
                else
                if(!isPostalCode(postalCodeRegister))
                    postalCodeRegister.setError("Not a valid postal code");
            }
        });

        // NIF
        nifRegister.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
                checkValidation();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(!isNumber(nifRegister))
                    nifRegister.setError("Not a valid NIF number");
            }
        });

        // PASSWORD
        passwordLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
                checkValidation();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(passwordLogin.length() < 5)
                    passwordLogin.setError("Password must be >5 characters");
                else {
                    if (!isValidPassword(passwordLogin))
                        passwordLogin.setError("Please insert at least 1 special character without spaces");
                    else
                    if(weakPassword(passwordLogin, nameRegister) == true)
                        passwordLogin.setError("Please don't include your first name for security reasons");
                }
            }
        });

        // REPEAT PASSWORD
        repasswordLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
                checkValidation();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(!checkPasswords(passwordLogin, repasswordLogin))
                    repasswordLogin.setError("Passwords do not match!");
            }
        });
    }

    public void sendMessageRegister(View view) {
        // Do something in response to button
        Button registerButton = (Button) findViewById(R.id.btn_register);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, MapsActivity.class)); // Register --> Maps
            }
        });
    }

    public void sendMessageToLogin(View view) {
        // Do something in response to button
        Button goToLoginButton = (Button) findViewById(R.id.goToLoginButton);

        goToLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class)); // Register --> Login
            }
        });
    }

    boolean isEmail(EditText text) {
        String email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isPhone(EditText text) {
        String email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.PHONE.matcher(email).matches());
    }

    boolean isValidPortuguesePhoneNumber(EditText text) {
        String phoneStr = "";
        String checkPhoneCode = "";
        String phone = text.getText().toString();
        String[] splitName = phone.split("\\s+");

        for(int i = 0; i < splitName.length; i++)
            phoneStr += splitName[i];

        char[] charArr = phoneStr.toCharArray();

        for(int i = 0; i < charArr.length; i++) {

            checkPhoneCode += charArr[i];

            if (checkPhoneCode.equals("+351"))
                if (charArr.length != 13)
                    return false;

            if (charArr[0] == '2' || charArr[0] == '9')
                if (charArr.length != 9)
                    return false;
        }

        return true;
    }

    public boolean isValidLetters(EditText text) {
        Matcher matcher;
        Pattern pattern = Pattern.compile("^[\\p{L} .'-]+$");
        String string = text.getText().toString();
        matcher = pattern.matcher(string);
        return !TextUtils.isEmpty(string) && matcher.matches();
    }

    boolean isNumber(EditText text) {
        String nif = text.getText().toString();
        boolean digitsOnly = TextUtils.isDigitsOnly(nif);
        return !TextUtils.isEmpty(nif) && digitsOnly;
    }

    boolean isPostalCode(EditText text) {
        String firstFour = "";
        String lastThree = "";

        String postalCode = text.getText().toString();
        char[] charSequence = postalCode.toCharArray();

        for(int i = 0; i <= 3; i++)
            firstFour += charSequence[i];
        boolean digitsOnlyFirstFour = TextUtils.isDigitsOnly(firstFour);

        for(int j = 5; j <= 7; j++)
            lastThree += charSequence[j];
        boolean digitsOnlyLastThree = TextUtils.isDigitsOnly(lastThree);

        return !TextUtils.isEmpty(postalCode) && charSequence[4] == '-' && digitsOnlyFirstFour && digitsOnlyLastThree;
    }

    boolean isEmpty(EditText text) {
        String str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean weakPassword(EditText password1, EditText name1) {
        String currentString = "";
        String name = name1.getText().toString();
        String password = password1.getText().toString();
        String[] splitName = name.split("\\s+");
        String firstName = splitName[0];
        char[] passwordArray = password.toCharArray();

        for(int i = 0; i < passwordArray.length; i++) {
            currentString += passwordArray[i];
            if (currentString.equalsIgnoreCase(firstName))
                return true;
        }
        return false;
    }

    boolean isValidPassword(EditText text) {
        Matcher matcher;
        Pattern pattern =
                Pattern.compile("^" +
                        "(?=.*[@#$%^&+=])" +     // at least 1 special character
                        "(?=\\S+$)" +            // no white spaces
                        ".{5,}" +                // at least 5 characters
                        "$");
        String password = text.getText().toString();
        matcher = pattern.matcher(password);
        return !TextUtils.isEmpty(password) && matcher.matches();
    }

    boolean checkPasswords(EditText text1, EditText text2) {
        String pass1 = text1.getText().toString();
        String pass2 = text2.getText().toString();
        return !TextUtils.isEmpty(pass2) && pass1.equals(pass2);
    }

    private void checkValidation() {
        if(checkDataEntered())
            registerButton.setEnabled(true);
        else
            registerButton.setEnabled(false);
    }

    boolean checkDataEntered() {

        if (!isValidLetters(nameRegister))
            return false;

        if (!isEmail(emailRegister))
            return false;

        if (isEmpty(usernameRegister))
            return false;

        if(!isPhone(phoneRegister))
            return false;
        else
        if(!isValidPortuguesePhoneNumber(phoneRegister))
            return false;

        if (!isValidLetters(cityRegister))
            return false;

        if (isEmpty(addressRegister))
            return false;

        if(postalCodeRegister.length() != 8)
            return false;
        else
        if(!isPostalCode(postalCodeRegister))
            return false;

        if(!isNumber(nifRegister))
            return false;

        if(passwordLogin.length() < 5)
            return false;
        else {
            if (!isValidPassword(passwordLogin))
                return false;
            else
            if(weakPassword(passwordLogin, nameRegister))
                return false;
        }

        if(!checkPasswords(passwordLogin, repasswordLogin))
            return false;

        return true;
    }
}