package com.example.wordle.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

@Preview(showBackground = true)
@Composable
fun TypographyPreview() {
    Column() {
        Text(text = "H1 headline", style = Typography.h1)
        Text(text = "H2 headline", style = Typography.h2)
        Text(text = "H3 headline", style = Typography.h3)
        Text(text = "H4 headline", style = Typography.h4)
        Text(text = "H5 headline", style = Typography.h5)
        Text(text = "H6 headline", style = Typography.h6)
        Text(text = "Body1", style = Typography.body1)
        Text(text = "Body2", style = Typography.body2)
        Text(text = "Caption", style = Typography.caption)
        Text(text = "Subtitle1", style = Typography.subtitle1)
        Text(text = "Subtitle2", style = Typography.subtitle2)
        Text(text = "Overline", style = Typography.overline)
    }
}