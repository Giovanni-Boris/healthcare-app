package com.example.projecto_suarez.presentation.map

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projecto_suarez.R
import com.example.projecto_suarez.presentation.Dimens
import com.example.projecto_suarez.presentation.common.ScanCamara
import org.altbeacon.beacon.RegionViewModel

@Composable
fun MapScreen(state: MapState) {
    ScanCamara(){

    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = Dimens.ExtraSmallPadding, end = Dimens.ExtraSmallPadding, bottom = Dimens.ExtraSmallPadding)
            .statusBarsPadding()
    ) {
        Text("Detected Iot Models:")
        Spacer(modifier = Modifier.height(8.dp))
        state.beacons?.forEach { beacon ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .background(MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(8.dp)) // Fondo redondeado
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically // Alinear contenido al centro
            ) {
                // Imagen genérica para cada IoT
                Image(
                    painter = painterResource(id = R.drawable.onboarding3), // Reemplaza con tu recurso
                    contentDescription = "IoT Icon",
                    modifier = Modifier
                        .size(48.dp)
                        .padding(end = 8.dp)
                )

                // Texto estilizado del beacon
                Text(
                    text = beacon,
                    modifier = Modifier.weight(1f) // Ocupa el espacio restante
                )
            }
        }

    }
}