// Generated by view binder compiler. Do not edit!
package com.itcraftsolution.esell.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.itcraftsolution.esell.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView cardviewHome;

  @NonNull
  public final EditText editText;

  @NonNull
  public final ImageView igHomeCat;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final RecyclerView rvHomeCategory;

  @NonNull
  public final RecyclerView rvHomeFreshItems;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView tvCityName;

  @NonNull
  public final TextView txHomecat;

  private FragmentHomeBinding(@NonNull ConstraintLayout rootView, @NonNull CardView cardviewHome,
      @NonNull EditText editText, @NonNull ImageView igHomeCat, @NonNull ImageView imageView,
      @NonNull RecyclerView rvHomeCategory, @NonNull RecyclerView rvHomeFreshItems,
      @NonNull TextView textView, @NonNull TextView textView3, @NonNull TextView tvCityName,
      @NonNull TextView txHomecat) {
    this.rootView = rootView;
    this.cardviewHome = cardviewHome;
    this.editText = editText;
    this.igHomeCat = igHomeCat;
    this.imageView = imageView;
    this.rvHomeCategory = rvHomeCategory;
    this.rvHomeFreshItems = rvHomeFreshItems;
    this.textView = textView;
    this.textView3 = textView3;
    this.tvCityName = tvCityName;
    this.txHomecat = txHomecat;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cardviewHome;
      CardView cardviewHome = ViewBindings.findChildViewById(rootView, id);
      if (cardviewHome == null) {
        break missingId;
      }

      id = R.id.editText;
      EditText editText = ViewBindings.findChildViewById(rootView, id);
      if (editText == null) {
        break missingId;
      }

      id = R.id.igHomeCat;
      ImageView igHomeCat = ViewBindings.findChildViewById(rootView, id);
      if (igHomeCat == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.rvHomeCategory;
      RecyclerView rvHomeCategory = ViewBindings.findChildViewById(rootView, id);
      if (rvHomeCategory == null) {
        break missingId;
      }

      id = R.id.rvHomeFreshItems;
      RecyclerView rvHomeFreshItems = ViewBindings.findChildViewById(rootView, id);
      if (rvHomeFreshItems == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.tvCityName;
      TextView tvCityName = ViewBindings.findChildViewById(rootView, id);
      if (tvCityName == null) {
        break missingId;
      }

      id = R.id.txHomecat;
      TextView txHomecat = ViewBindings.findChildViewById(rootView, id);
      if (txHomecat == null) {
        break missingId;
      }

      return new FragmentHomeBinding((ConstraintLayout) rootView, cardviewHome, editText, igHomeCat,
          imageView, rvHomeCategory, rvHomeFreshItems, textView, textView3, tvCityName, txHomecat);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
