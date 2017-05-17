package com.example.radog.patm_sinc_2.proveedor;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by radog on 16/05/2017.
 */

public class Contrato {

    public static final String AUTHORITY = "com.example.radog.patm_sinc_2.proveedor.ProveedorDeContenido";

    public static final class Ciclo implements BaseColumns {

        public static final Uri CONTENT_URI = Uri
                .parse("content://" + AUTHORITY + "/Ciclo");

        // Table column
        public static final String NOMBRE = "Nombre";
        public static final String ABREVIATURA = "Abreviatura";
    }
}
