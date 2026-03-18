package com.usc.cine.bedoyamarin;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Pantalla principal para gestionar el CRUD de entradas de cine.
 */
public class MainActivity extends AppCompatActivity {

    private static final String ESTUDIANTE_FIJO = "CRISTIAN ALEXANDER BEDOYA MARIN";

    private EditText etId;
    private EditText etNombrePelicula;
    private EditText etNombreCine;
    private EditText etNumeroSala;
    private EditText etFecha;
    private EditText etHora;
    private EditText etNumeroEntradas;
    private EditText etCostoTotal;

    private AdminSQLiteOpenHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = findViewById(R.id.etId);
        etNombrePelicula = findViewById(R.id.etNombrePelicula);
        etNombreCine = findViewById(R.id.etNombreCine);
        etNumeroSala = findViewById(R.id.etNumeroSala);
        etFecha = findViewById(R.id.etFecha);
        etHora = findViewById(R.id.etHora);
        etNumeroEntradas = findViewById(R.id.etNumeroEntradas);
        etCostoTotal = findViewById(R.id.etCostoTotal);

        Button btnGuardar = findViewById(R.id.btnGuardar);
        Button btnBuscar = findViewById(R.id.btnBuscar);
        Button btnActualizar = findViewById(R.id.btnActualizar);
        Button btnEliminar = findViewById(R.id.btnEliminar);

        dbHelper = new AdminSQLiteOpenHelper(this);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarEntrada();
            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarEntrada();
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarEntrada();
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarEntrada();
            }
        });
    }

    private void guardarEntrada() {
        if (!validarCamposSinId()) {
            return;
        }

        EntradaCine entrada = new EntradaCine(
                etNombrePelicula.getText().toString().trim(),
                etNombreCine.getText().toString().trim(),
                etNumeroSala.getText().toString().trim(),
                etFecha.getText().toString().trim(),
                etHora.getText().toString().trim(),
                Integer.parseInt(etNumeroEntradas.getText().toString().trim()),
                Double.parseDouble(etCostoTotal.getText().toString().trim()),
                ESTUDIANTE_FIJO
        );

        long id = dbHelper.insertarEntrada(entrada);
        if (id > 0) {
            Toast.makeText(this, "Registro guardado con ID: " + id, Toast.LENGTH_LONG).show();
            limpiarCampos();
        } else {
            Toast.makeText(this, "Error al guardar", Toast.LENGTH_LONG).show();
        }
    }

    private void buscarEntrada() {
        String idText = etId.getText().toString().trim();
        if (TextUtils.isEmpty(idText)) {
            Toast.makeText(this, "Ingrese el ID", Toast.LENGTH_LONG).show();
            return;
        }

        int id = Integer.parseInt(idText);
        EntradaCine entrada = dbHelper.obtenerEntradaPorId(id);
        if (entrada != null) {
            etNombrePelicula.setText(entrada.getNombrePelicula());
            etNombreCine.setText(entrada.getNombreCine());
            etNumeroSala.setText(entrada.getNumeroSala());
            etFecha.setText(entrada.getFecha());
            etHora.setText(entrada.getHora());
            etNumeroEntradas.setText(String.valueOf(entrada.getNumeroEntradas()));
            etCostoTotal.setText(String.valueOf(entrada.getCostoTotal()));
            Toast.makeText(this, "Registro encontrado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No existe el registro", Toast.LENGTH_LONG).show();
        }
    }

    private void actualizarEntrada() {
        String idText = etId.getText().toString().trim();
        if (TextUtils.isEmpty(idText)) {
            Toast.makeText(this, "Ingrese el ID", Toast.LENGTH_LONG).show();
            return;
        }
        if (!validarCamposSinId()) {
            return;
        }

        int id = Integer.parseInt(idText);
        EntradaCine entrada = new EntradaCine(
                etNombrePelicula.getText().toString().trim(),
                etNombreCine.getText().toString().trim(),
                etNumeroSala.getText().toString().trim(),
                etFecha.getText().toString().trim(),
                etHora.getText().toString().trim(),
                Integer.parseInt(etNumeroEntradas.getText().toString().trim()),
                Double.parseDouble(etCostoTotal.getText().toString().trim()),
                ESTUDIANTE_FIJO
        );

        int filas = dbHelper.actualizarEntrada(id, entrada);
        if (filas > 0) {
            Toast.makeText(this, "Registro actualizado", Toast.LENGTH_LONG).show();
            limpiarCampos();
        } else {
            Toast.makeText(this, "No se pudo actualizar", Toast.LENGTH_LONG).show();
        }
    }

    private void eliminarEntrada() {
        String idText = etId.getText().toString().trim();
        if (TextUtils.isEmpty(idText)) {
            Toast.makeText(this, "Ingrese el ID", Toast.LENGTH_LONG).show();
            return;
        }

        int id = Integer.parseInt(idText);
        int filas = dbHelper.eliminarEntrada(id);
        if (filas > 0) {
            Toast.makeText(this, "Registro eliminado", Toast.LENGTH_LONG).show();
            limpiarCampos();
        } else {
            Toast.makeText(this, "No se pudo eliminar", Toast.LENGTH_LONG).show();
        }
    }

    private boolean validarCamposSinId() {
        if (TextUtils.isEmpty(etNombrePelicula.getText().toString().trim()) ||
                TextUtils.isEmpty(etNombreCine.getText().toString().trim()) ||
                TextUtils.isEmpty(etNumeroSala.getText().toString().trim()) ||
                TextUtils.isEmpty(etFecha.getText().toString().trim()) ||
                TextUtils.isEmpty(etHora.getText().toString().trim()) ||
                TextUtils.isEmpty(etNumeroEntradas.getText().toString().trim()) ||
                TextUtils.isEmpty(etCostoTotal.getText().toString().trim())) {
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private void limpiarCampos() {
        etId.setText("");
        etNombrePelicula.setText("");
        etNombreCine.setText("");
        etNumeroSala.setText("");
        etFecha.setText("");
        etHora.setText("");
        etNumeroEntradas.setText("");
        etCostoTotal.setText("");
    }
}
