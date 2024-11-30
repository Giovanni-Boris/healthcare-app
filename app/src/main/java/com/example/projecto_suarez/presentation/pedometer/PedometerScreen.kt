package com.example.projecto_suarez.presentation.pedometer


import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aay.compose.barChart.BarChart
import com.aay.compose.barChart.model.BarParameters
import com.aay.compose.donutChart.DonutChart
import com.aay.compose.donutChart.model.PieChartData
import com.example.projecto_suarez.domain.model.Article
import com.example.projecto_suarez.domain.model.Source
import com.example.projecto_suarez.presentation.Dimens
import com.example.projecto_suarez.presentation.common.ArticleCard
import com.example.projecto_suarez.ui.theme.ProjectosuarezTheme


@Composable
fun PedometerScreen() {

    val testPieChartData: List<PieChartData> = listOf(
        PieChartData(
            partName = "Months",
            data = 500.0,
            color = Color(0xFF0B666A),
        ),
        PieChartData(
            partName = "Days",
            data = 700.0,
            color = Color(0xFF35A29F),
        ),
        PieChartData(
            partName = "Year",
            data = 500.0,
            color = Color(0xFF97FEED),
        ),
        PieChartData(
            partName = "Week",
            data = 100.0,
            color = Color(0xFF071952),
        ),
    )
    val testBarParameters: List<BarParameters> = listOf(
        BarParameters(
            dataName = "<500",
            data = listOf(0.6, 10.6, 80.0, 50.6, 44.0, 100.6, 10.0),
            barColor = Color(0xFF6C3428)
        ),
        BarParameters(
            dataName = ">500",
            data = listOf(50.0, 30.6, 77.0, 69.6, 50.0, 30.6, 80.0),
            barColor = Color(0xFFBA704F),
        ),
        BarParameters(
            dataName = ">10000",
            data = listOf(100.0, 99.6, 60.0, 80.6, 10.0, 100.6, 55.99),
            barColor = Color(0xFFDFA878),
        ),
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(start = Dimens.ExtraSmallPadding, end = Dimens.ExtraSmallPadding, bottom = Dimens.ExtraSmallPadding)
        .statusBarsPadding()
        .verticalScroll(rememberScrollState())

    ) {
        DonutChart(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            pieChartData = testPieChartData,
            centerTitle = "Steps",
            centerTitleStyle = TextStyle(color = Color(0xFFFFFFFf)),
            outerCircularColor = Color.LightGray,
            innerCircularColor = Color.Gray,
            ratioLineColor = Color.LightGray,
            descriptionStyle = TextStyle(color = Color(0xFFFFFFFf)),
        )
        Box( modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
        ) {
            BarChart(
                chartParameters = testBarParameters,
                gridColor = Color.DarkGray,
                xAxisData = listOf("2016", "2017", "2018", "2019", "2020", "2021", "2022"),
                isShowGrid = true,
                animateChart = true,
                showGridWithSpacer = true,
                yAxisStyle = TextStyle(
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                ),
                xAxisStyle = TextStyle(
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.W400
                ),
                yAxisRange = 15,
                barWidth = 20.dp,
                descriptionStyle = TextStyle(color = Color(0xFFFFFFFf)),
            )
        }
    }

}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PedometerScreenPreview() {
    ProjectosuarezTheme {
        PedometerScreen()
    }
}