// Generated by view binder compiler. Do not edit!
package com.example.utsanmp_160421068.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.utsanmp_160421068.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final Button btnLogin;

  @NonNull
  public final Button btnRegist;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final EditText txtPassword;

  @NonNull
  public final EditText txtUser;

  private ActivityLoginBinding(@NonNull ScrollView rootView, @NonNull Button btnLogin,
      @NonNull Button btnRegist, @NonNull TextView textView2, @NonNull TextView textView3,
      @NonNull EditText txtPassword, @NonNull EditText txtUser) {
    this.rootView = rootView;
    this.btnLogin = btnLogin;
    this.btnRegist = btnRegist;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.txtPassword = txtPassword;
    this.txtUser = txtUser;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnLogin;
      Button btnLogin = ViewBindings.findChildViewById(rootView, id);
      if (btnLogin == null) {
        break missingId;
      }

      id = R.id.btnRegist;
      Button btnRegist = ViewBindings.findChildViewById(rootView, id);
      if (btnRegist == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.txtPassword;
      EditText txtPassword = ViewBindings.findChildViewById(rootView, id);
      if (txtPassword == null) {
        break missingId;
      }

      id = R.id.txtUser;
      EditText txtUser = ViewBindings.findChildViewById(rootView, id);
      if (txtUser == null) {
        break missingId;
      }

      return new ActivityLoginBinding((ScrollView) rootView, btnLogin, btnRegist, textView2,
          textView3, txtPassword, txtUser);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
