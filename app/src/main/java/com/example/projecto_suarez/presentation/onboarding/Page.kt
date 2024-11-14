package com.example.projecto_suarez.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.projecto_suarez.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)
val pages = listOf(
    Page(
        title = "Monitorea tu Bienestar",
        description = "Lleva un registro fácil de tus signos vitales y progreso diario.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Objetivos Personalizados",
        description = "Define tus metas de salud y recibe recomendaciones basadas en tus datos.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Consejos de Expertos",
        description = "Descubre tips y hábitos saludables avalados por profesionales.",
        image = R.drawable.onboarding3
    )
)