package com.example.radog.patm_sinc_2.ciclo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.radog.patm_sinc_2.R;
import com.example.radog.patm_sinc_2.constantes.G;
import com.example.radog.patm_sinc_2.pojos.Ciclo;
import com.example.radog.patm_sinc_2.proveedor.CicloProveedor;

public class CicloActualizacionActivity extends AppCompatActivity {

    EditText editTextCicloNombre;
    EditText editTextCicloAbreviatura;
    int cicloId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_detalle);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_ciclo_detalle);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editTextCicloNombre = (EditText) findViewById(R.id.editTextCicloNombre);
        editTextCicloAbreviatura = (EditText) findViewById(R.id.editTextCicloAbreviatura);

        cicloId = this.getIntent().getExtras().getInt("ID");
        editTextCicloNombre.setText(this.getIntent().getExtras().getString("Nombre"));
        editTextCicloAbreviatura.setText(this.getIntent().getExtras().getString("Abreviatura"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuItem menuItem = menu.add(Menu.NONE, G.GUARDAR, Menu.NONE, "Guardar");
        menuItem.setIcon(R.drawable.ic_action_guardar);
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case G.GUARDAR:
                attemptGuardar();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    void attemptGuardar() {
        editTextCicloNombre.setError(null);
        editTextCicloAbreviatura.setError(null);

        String nombre = String.valueOf(editTextCicloNombre.getText());
        String abreviatura = String.valueOf(editTextCicloAbreviatura.getText());

        if (TextUtils.isEmpty(nombre)) {
            editTextCicloNombre.setError(getString(R.string.campo_requerido));
            editTextCicloNombre.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(abreviatura)) {
            editTextCicloAbreviatura.setError(getString(R.string.campo_requerido));
            editTextCicloAbreviatura.requestFocus();
            return;
        }

        Ciclo ciclo = new Ciclo(cicloId, nombre, abreviatura);
        CicloProveedor.updateRecord(getContentResolver(), ciclo);
        finish();
    }
}
