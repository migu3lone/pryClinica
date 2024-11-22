// Generated by view binder compiler. Do not edit!
package com.migu3lone.pryclinica.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.migu3lone.pryclinica.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentViewpacienteBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout paciente;

  @NonNull
  public final RecyclerView recyclerCita;

  @NonNull
  public final RecyclerView recyclerPaciente;

  @NonNull
  public final SearchView searchView;

  private FragmentViewpacienteBinding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout paciente, @NonNull RecyclerView recyclerCita,
      @NonNull RecyclerView recyclerPaciente, @NonNull SearchView searchView) {
    this.rootView = rootView;
    this.paciente = paciente;
    this.recyclerCita = recyclerCita;
    this.recyclerPaciente = recyclerPaciente;
    this.searchView = searchView;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentViewpacienteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentViewpacienteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_viewpaciente, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentViewpacienteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      LinearLayout paciente = (LinearLayout) rootView;

      id = R.id.recyclerCita;
      RecyclerView recyclerCita = ViewBindings.findChildViewById(rootView, id);
      if (recyclerCita == null) {
        break missingId;
      }

      id = R.id.recyclerPaciente;
      RecyclerView recyclerPaciente = ViewBindings.findChildViewById(rootView, id);
      if (recyclerPaciente == null) {
        break missingId;
      }

      id = R.id.searchView;
      SearchView searchView = ViewBindings.findChildViewById(rootView, id);
      if (searchView == null) {
        break missingId;
      }

      return new FragmentViewpacienteBinding((LinearLayout) rootView, paciente, recyclerCita,
          recyclerPaciente, searchView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
