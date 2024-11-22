// Generated by view binder compiler. Do not edit!
package com.migu3lone.pryclinica.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.migu3lone.pryclinica.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAddpacienteBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final ScrollView addPaciente;

  @NonNull
  public final Button btnGuardar;

  @NonNull
  public final EditText etApellidos;

  @NonNull
  public final EditText etCelular;

  @NonNull
  public final EditText etCorreo;

  @NonNull
  public final EditText etDNI;

  @NonNull
  public final EditText etDireccion;

  @NonNull
  public final EditText etIdPaciente;

  @NonNull
  public final EditText etNacimiento;

  @NonNull
  public final EditText etNombres;

  @NonNull
  public final EditText etPassword;

  @NonNull
  public final TextView etSexo;

  @NonNull
  public final RadioButton rbFemenino;

  @NonNull
  public final RadioButton rbMasculino;

  @NonNull
  public final RadioGroup rgSexo;

  private FragmentAddpacienteBinding(@NonNull ScrollView rootView, @NonNull ScrollView addPaciente,
      @NonNull Button btnGuardar, @NonNull EditText etApellidos, @NonNull EditText etCelular,
      @NonNull EditText etCorreo, @NonNull EditText etDNI, @NonNull EditText etDireccion,
      @NonNull EditText etIdPaciente, @NonNull EditText etNacimiento, @NonNull EditText etNombres,
      @NonNull EditText etPassword, @NonNull TextView etSexo, @NonNull RadioButton rbFemenino,
      @NonNull RadioButton rbMasculino, @NonNull RadioGroup rgSexo) {
    this.rootView = rootView;
    this.addPaciente = addPaciente;
    this.btnGuardar = btnGuardar;
    this.etApellidos = etApellidos;
    this.etCelular = etCelular;
    this.etCorreo = etCorreo;
    this.etDNI = etDNI;
    this.etDireccion = etDireccion;
    this.etIdPaciente = etIdPaciente;
    this.etNacimiento = etNacimiento;
    this.etNombres = etNombres;
    this.etPassword = etPassword;
    this.etSexo = etSexo;
    this.rbFemenino = rbFemenino;
    this.rbMasculino = rbMasculino;
    this.rgSexo = rgSexo;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAddpacienteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAddpacienteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_addpaciente, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAddpacienteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ScrollView addPaciente = (ScrollView) rootView;

      id = R.id.btnGuardar;
      Button btnGuardar = ViewBindings.findChildViewById(rootView, id);
      if (btnGuardar == null) {
        break missingId;
      }

      id = R.id.etApellidos;
      EditText etApellidos = ViewBindings.findChildViewById(rootView, id);
      if (etApellidos == null) {
        break missingId;
      }

      id = R.id.etCelular;
      EditText etCelular = ViewBindings.findChildViewById(rootView, id);
      if (etCelular == null) {
        break missingId;
      }

      id = R.id.etCorreo;
      EditText etCorreo = ViewBindings.findChildViewById(rootView, id);
      if (etCorreo == null) {
        break missingId;
      }

      id = R.id.etDNI;
      EditText etDNI = ViewBindings.findChildViewById(rootView, id);
      if (etDNI == null) {
        break missingId;
      }

      id = R.id.etDireccion;
      EditText etDireccion = ViewBindings.findChildViewById(rootView, id);
      if (etDireccion == null) {
        break missingId;
      }

      id = R.id.etIdPaciente;
      EditText etIdPaciente = ViewBindings.findChildViewById(rootView, id);
      if (etIdPaciente == null) {
        break missingId;
      }

      id = R.id.etNacimiento;
      EditText etNacimiento = ViewBindings.findChildViewById(rootView, id);
      if (etNacimiento == null) {
        break missingId;
      }

      id = R.id.etNombres;
      EditText etNombres = ViewBindings.findChildViewById(rootView, id);
      if (etNombres == null) {
        break missingId;
      }

      id = R.id.etPassword;
      EditText etPassword = ViewBindings.findChildViewById(rootView, id);
      if (etPassword == null) {
        break missingId;
      }

      id = R.id.etSexo;
      TextView etSexo = ViewBindings.findChildViewById(rootView, id);
      if (etSexo == null) {
        break missingId;
      }

      id = R.id.rbFemenino;
      RadioButton rbFemenino = ViewBindings.findChildViewById(rootView, id);
      if (rbFemenino == null) {
        break missingId;
      }

      id = R.id.rbMasculino;
      RadioButton rbMasculino = ViewBindings.findChildViewById(rootView, id);
      if (rbMasculino == null) {
        break missingId;
      }

      id = R.id.rgSexo;
      RadioGroup rgSexo = ViewBindings.findChildViewById(rootView, id);
      if (rgSexo == null) {
        break missingId;
      }

      return new FragmentAddpacienteBinding((ScrollView) rootView, addPaciente, btnGuardar,
          etApellidos, etCelular, etCorreo, etDNI, etDireccion, etIdPaciente, etNacimiento,
          etNombres, etPassword, etSexo, rbFemenino, rbMasculino, rgSexo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
