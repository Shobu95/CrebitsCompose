import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun CrebitsDonutChartPrev() {
    CrebitsDonutChart(
        points = listOf(40f, 60f),
        colors = listOf(Color.Black, Color.LightGray),
        modifier = Modifier.size(250.dp)
    )
}

@Composable
fun CrebitsDonutChart(
    points: List<Float>,
    colors: List<Color>,
    modifier: Modifier,
) {

    val sweepAngles = calculateSweepAngles(points)
    var startAngle = 270f

    Canvas(
        modifier = modifier
    ) {

        sweepAngles.forEachIndexed { index, sweepAngle ->
            DrawArc(
                colors[index],
                startAngle,
                sweepAngle
            )
            startAngle += sweepAngle
        }
    }
}


fun calculateSweepAngles(points: List<Float>): List<Float> {
    val total = points.sum()

    val proportions = points.map {
        it * 100 / total
    }

    return proportions.map {
        360 * it / 100
    }
}

fun DrawScope.DrawArc(
    color: Color,
    startAngle: Float,
    sweepAngle: Float,
) {
    val padding = 180f
    drawArc(
        color = color,
        startAngle = startAngle,
        sweepAngle = sweepAngle,
        useCenter = false,
        size = Size(
            width = size.width - padding,
            height = size.width - padding
        ),
        style = Stroke(
            width = 100f
        ),
        topLeft = Offset(padding / 2f, padding / 2f)
    )
}