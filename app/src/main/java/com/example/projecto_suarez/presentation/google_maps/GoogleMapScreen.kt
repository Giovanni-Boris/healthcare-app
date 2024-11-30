package com.example.projecto_suarez.presentation.google_maps

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projecto_suarez.presentation.Dimens
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
@Composable
fun GoogleMapScreen() {
    Column(
        modifier = Modifier
            .padding(
                top = Dimens.MediumPadding1,
                start = Dimens.MediumPadding1,
                end = Dimens.MediumPadding1
            )
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(LatLng(-16.398829, -71.5394782), 15f) // posición original ubicada en plaza de armas
        }
        Text(
            text = "Mapa de lugares de Comida Saludable en Perú",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            // Coordenadas de hospitales en Perú
            val healthyFood1 = LatLng(-12.121222, -77.027506) // Madre Natura, Lima
            val healthyFood2 = LatLng(-12.093479, -77.051450) // Armónica Café, Miraflores
            val healthyFood3 = LatLng(-16.399071, -71.536766) // Green Gourmet, Arequipa

// Marcadores para los puntos de venta
            Marker(
                state = com.google.maps.android.compose.MarkerState(position = healthyFood1),
                title = "Madre Natura",
                snippet = "Productos orgánicos y saludables en Surco, Lima."
            )
            Marker(
                state = com.google.maps.android.compose.MarkerState(position = healthyFood2),
                title = "Armónica Café",
                snippet = "Opciones vegetarianas, veganas y saludables en Miraflores."
            )
            Marker(
                state = com.google.maps.android.compose.MarkerState(position = healthyFood3),
                title = "Green Gourmet",
                snippet = "Restaurante saludable con opciones sin gluten en Arequipa."
            )
        }
    }
}