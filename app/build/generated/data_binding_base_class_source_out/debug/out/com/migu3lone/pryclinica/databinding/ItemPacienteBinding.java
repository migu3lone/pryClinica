// Generated by view binder compiler. Do not edit!
package com.migu3lone.pryclinica.databinding;

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
import com.migu3lone.pryclinica.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemPacienteBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView editar;

  @NonNull
  public final ImageView eliminar;

  @NonNull
  public final ImageView imageLeft;

  @NonNull
  public final TextView vr1;

  @NonNull
  public final TextView vr2;

  @NonNull
  public final TextView vr3;

  @NonNull
  public final TextView vr4;

  @NonNull
  public final TextView vr5;

  @NonNull
  public final TextView vr6;

  @NonNull
  public final TextView vr7;

  @NonNull
  public final TextView vr8;

  private ItemPacienteBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView editar,
      @NonNull ImageView eliminar, @NonNull ImageView imageLeft, @NonNull TextView vr1,
      @NonNull TextView vr2, @NonNull TextView vr3, @NonNull TextView vr4, @NonNull TextView vr5,
      @NonNull TextView vr6, @NonNull TextView vr7, @NonNull TextView vr8) {
    this.rootView = rootView;
    this.editar = editar;
    this.eliminar = eliminar;
    this.imageLeft = imageLeft;
    this.vr1 = vr1;
    this.vr2 = vr2;
    this.vr3 = vr3;
    this.vr4 = vr4;
    this.vr5 = vr5;
    this.vr6 = vr6;
    this.vr7 = vr7;
    this.vr8 = vr8;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemPacienteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemPacienteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_paciente, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemPacienteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.editar;
      ImageView editar = ViewBindings.findChildViewById(rootView, id);
      if (editar == null) {
        break missingId;
      }

      id = R.id.eliminar;
      ImageView eliminar = ViewBindings.findChildViewById(rootView, id);
      if (eliminar == null) {
        break missingId;
      }

      id = R.id.imageLeft;
      ImageView imageLeft = ViewBindings.findChildViewById(rootView, id);
      if (imageLeft == null) {
        break missingId;
      }

      id = R.id.vr1;
      TextView vr1 = ViewBindings.findChildViewById(rootView, id);
      if (vr1 == null) {
        break missingId;
      }

      id = R.id.vr2;
      TextView vr2 = ViewBindings.findChildViewById(rootView, id);
      if (vr2 == null) {
        break missingId;
      }

      id = R.id.vr3;
      TextView vr3 = ViewBindings.findChildViewById(rootView, id);
      if (vr3 == null) {
        break missingId;
      }

      id = R.id.vr4;
      TextView vr4 = ViewBindings.findChildViewById(rootView, id);
      if (vr4 == null) {
        break missingId;
      }

      id = R.id.vr5;
      TextView vr5 = ViewBindings.findChildViewById(rootView, id);
      if (vr5 == null) {
        break missingId;
      }

      id = R.id.vr6;
      TextView vr6 = ViewBindings.findChildViewById(rootView, id);
      if (vr6 == null) {
        break missingId;
      }

      id = R.id.vr7;
      TextView vr7 = ViewBindings.findChildViewById(rootView, id);
      if (vr7 == null) {
        break missingId;
      }

      id = R.id.vr8;
      TextView vr8 = ViewBindings.findChildViewById(rootView, id);
      if (vr8 == null) {
        break missingId;
      }

      return new ItemPacienteBinding((ConstraintLayout) rootView, editar, eliminar, imageLeft, vr1,
          vr2, vr3, vr4, vr5, vr6, vr7, vr8);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
