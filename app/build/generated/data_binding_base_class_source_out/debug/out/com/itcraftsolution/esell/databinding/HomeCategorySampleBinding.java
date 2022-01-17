// Generated by view binder compiler. Do not edit!
package com.itcraftsolution.esell.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.itcraftsolution.esell.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class HomeCategorySampleBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final ImageView igSampleHomeCat;

  @NonNull
  public final TextView txSampleHomeCat;

  private HomeCategorySampleBinding(@NonNull ConstraintLayout rootView, @NonNull CardView cardView,
      @NonNull ImageView igSampleHomeCat, @NonNull TextView txSampleHomeCat) {
    this.rootView = rootView;
    this.cardView = cardView;
    this.igSampleHomeCat = igSampleHomeCat;
    this.txSampleHomeCat = txSampleHomeCat;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static HomeCategorySampleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static HomeCategorySampleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.home_category_sample, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static HomeCategorySampleBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cardView;
      CardView cardView = ViewBindings.findChildViewById(rootView, id);
      if (cardView == null) {
        break missingId;
      }

      id = R.id.igSampleHomeCat;
      ImageView igSampleHomeCat = ViewBindings.findChildViewById(rootView, id);
      if (igSampleHomeCat == null) {
        break missingId;
      }

      id = R.id.txSampleHomeCat;
      TextView txSampleHomeCat = ViewBindings.findChildViewById(rootView, id);
      if (txSampleHomeCat == null) {
        break missingId;
      }

      return new HomeCategorySampleBinding((ConstraintLayout) rootView, cardView, igSampleHomeCat,
          txSampleHomeCat);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}