// Generated by view binder compiler. Do not edit!
package com.migu3lone.pryclinica.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
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

public final class FragmentViewespecialidadBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final Button btnShowModal;

  @NonNull
  public final ScrollView especialidad;

  @NonNull
  public final RecyclerView recyclerCita;

  @NonNull
  public final RecyclerView recyclerEspecialidad;

  @NonNull
  public final RecyclerView recyclerMedico;

  @NonNull
  public final RecyclerView recyclerPaciente;

  @NonNull
  public final SearchView searchView;

  private FragmentViewespecialidadBinding(@NonNull ScrollView rootView,
      @NonNull Button btnShowModal, @NonNull ScrollView especialidad,
      @NonNull RecyclerView recyclerCita, @NonNull RecyclerView recyclerEspecialidad,
      @NonNull RecyclerView recyclerMedico, @NonNull RecyclerView recyclerPaciente,
      @NonNull SearchView searchView) {
    this.rootView = rootView;
    this.btnShowModal = btnShowModal;
    this.especialidad = especialidad;
    this.recyclerCita = recyclerCita;
    this.recyclerEspecialidad = recyclerEspecialidad;
    this.recyclerMedico = recyclerMedico;
    this.recyclerPaciente = recyclerPaciente;
    this.searchView = searchView;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentViewespecialidadBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentViewespecialidadBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_viewespecialidad, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentViewespecialidadBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnShowModal;
      Button btnShowModal = ViewBindings.findChildViewById(rootView, id);
      if (btnShowModal == null) {
        break missingId;
      }

      ScrollView especialidad = (ScrollView) rootView;

      id = R.id.recyclerCita;
      RecyclerView recyclerCita = ViewBindings.findChildViewById(rootView, id);
      if (recyclerCita == null) {
        break missingId;
      }

      id = R.id.recyclerEspecialidad;
      RecyclerView recyclerEspecialidad = ViewBindings.findChildViewById(rootView, id);
      if (recyclerEspecialidad == null) {
        break missingId;
      }

      id = R.id.recyclerMedico;
      RecyclerView recyclerMedico = ViewBindings.findChildViewById(rootView, id);
      if (recyclerMedico == null) {
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

      return new FragmentViewespecialidadBinding((ScrollView) rootView, btnShowModal, especialidad,
          recyclerCita, recyclerEspecialidad, recyclerMedico, recyclerPaciente, searchView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
