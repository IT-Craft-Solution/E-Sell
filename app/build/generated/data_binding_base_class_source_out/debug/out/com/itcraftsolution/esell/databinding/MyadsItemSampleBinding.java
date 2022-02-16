// Generated by view binder compiler. Do not edit!
package com.itcraftsolution.esell.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.itcraftsolution.esell.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MyadsItemSampleBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView igItemImage;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView txDate;

  @NonNull
  public final TextView txDesc;

  @NonNull
  public final TextView txEdit;

  @NonNull
  public final TextView txItemLocation;

  @NonNull
  public final TextView txItemName;

  @NonNull
  public final TextView txItemPrice;

  private MyadsItemSampleBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView igItemImage,
      @NonNull ImageView imageView3, @NonNull TextView textView2, @NonNull TextView txDate,
      @NonNull TextView txDesc, @NonNull TextView txEdit, @NonNull TextView txItemLocation,
      @NonNull TextView txItemName, @NonNull TextView txItemPrice) {
    this.rootView = rootView;
    this.igItemImage = igItemImage;
    this.imageView3 = imageView3;
    this.textView2 = textView2;
    this.txDate = txDate;
    this.txDesc = txDesc;
    this.txEdit = txEdit;
    this.txItemLocation = txItemLocation;
    this.txItemName = txItemName;
    this.txItemPrice = txItemPrice;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MyadsItemSampleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MyadsItemSampleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.myads_item_sample, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MyadsItemSampleBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.igItemImage;
      ImageView igItemImage = ViewBindings.findChildViewById(rootView, id);
      if (igItemImage == null) {
        break missingId;
      }

      id = R.id.imageView3;
      ImageView imageView3 = ViewBindings.findChildViewById(rootView, id);
      if (imageView3 == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.txDate;
      TextView txDate = ViewBindings.findChildViewById(rootView, id);
      if (txDate == null) {
        break missingId;
      }

      id = R.id.txDesc;
      TextView txDesc = ViewBindings.findChildViewById(rootView, id);
      if (txDesc == null) {
        break missingId;
      }

      id = R.id.txEdit;
      TextView txEdit = ViewBindings.findChildViewById(rootView, id);
      if (txEdit == null) {
        break missingId;
      }

      id = R.id.txItemLocation;
      TextView txItemLocation = ViewBindings.findChildViewById(rootView, id);
      if (txItemLocation == null) {
        break missingId;
      }

      id = R.id.txItemName;
      TextView txItemName = ViewBindings.findChildViewById(rootView, id);
      if (txItemName == null) {
        break missingId;
      }

      id = R.id.txItemPrice;
      TextView txItemPrice = ViewBindings.findChildViewById(rootView, id);
      if (txItemPrice == null) {
        break missingId;
      }

      return new MyadsItemSampleBinding((ConstraintLayout) rootView, igItemImage, imageView3,
          textView2, txDate, txDesc, txEdit, txItemLocation, txItemName, txItemPrice);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
