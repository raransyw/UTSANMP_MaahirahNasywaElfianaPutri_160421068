// Generated by view binder compiler. Do not edit!
package com.example.utsanmp_160421068.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.utsanmp_160421068.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentReadBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button btnNext;

  @NonNull
  public final Button btnPrevious;

  @NonNull
  public final ImageView imageDetail;

  @NonNull
  public final TextView txtAuthor;

  @NonNull
  public final TextView txtDescDetail;

  @NonNull
  public final TextView txtSubDetail;

  @NonNull
  public final TextView txtTitleDetail;

  private FragmentReadBinding(@NonNull FrameLayout rootView, @NonNull Button btnNext,
      @NonNull Button btnPrevious, @NonNull ImageView imageDetail, @NonNull TextView txtAuthor,
      @NonNull TextView txtDescDetail, @NonNull TextView txtSubDetail,
      @NonNull TextView txtTitleDetail) {
    this.rootView = rootView;
    this.btnNext = btnNext;
    this.btnPrevious = btnPrevious;
    this.imageDetail = imageDetail;
    this.txtAuthor = txtAuthor;
    this.txtDescDetail = txtDescDetail;
    this.txtSubDetail = txtSubDetail;
    this.txtTitleDetail = txtTitleDetail;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentReadBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentReadBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_read, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentReadBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnNext;
      Button btnNext = ViewBindings.findChildViewById(rootView, id);
      if (btnNext == null) {
        break missingId;
      }

      id = R.id.btnPrevious;
      Button btnPrevious = ViewBindings.findChildViewById(rootView, id);
      if (btnPrevious == null) {
        break missingId;
      }

      id = R.id.imageDetail;
      ImageView imageDetail = ViewBindings.findChildViewById(rootView, id);
      if (imageDetail == null) {
        break missingId;
      }

      id = R.id.txtAuthor;
      TextView txtAuthor = ViewBindings.findChildViewById(rootView, id);
      if (txtAuthor == null) {
        break missingId;
      }

      id = R.id.txtDescDetail;
      TextView txtDescDetail = ViewBindings.findChildViewById(rootView, id);
      if (txtDescDetail == null) {
        break missingId;
      }

      id = R.id.txtSubDetail;
      TextView txtSubDetail = ViewBindings.findChildViewById(rootView, id);
      if (txtSubDetail == null) {
        break missingId;
      }

      id = R.id.txtTitleDetail;
      TextView txtTitleDetail = ViewBindings.findChildViewById(rootView, id);
      if (txtTitleDetail == null) {
        break missingId;
      }

      return new FragmentReadBinding((FrameLayout) rootView, btnNext, btnPrevious, imageDetail,
          txtAuthor, txtDescDetail, txtSubDetail, txtTitleDetail);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
