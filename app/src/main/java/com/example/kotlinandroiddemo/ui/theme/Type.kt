package com.example.kotlinandroiddemo.ui.theme


import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.kotlinandroiddemo.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val customFontFamily = FontFamily(
    Font(R.font.roboto_slab_extra_bold),
)


val Header01ExtraBold = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_slab_extra_bold)),
    fontSize = 21.sp,
    letterSpacing = 0.3.sp,
    color = Grey05
);
val Header01 = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_slab_regular)),
    fontSize = 21.sp,
    letterSpacing = 0.3.sp,
    color = Grey05,
);
val Header02ExtraBold = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_slab_extra_bold)),
    fontSize = 18.sp,
    letterSpacing = 0.3.sp,
    color = Grey05,
);
val Header02 = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_slab_regular)),
    fontSize = 18.sp,
    letterSpacing = 0.3.sp,
    color = Color.Black,
);

val Header03 = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_slab_extra_bold)),
    fontSize = 16.sp,
    letterSpacing = 0.3.sp,
    color = Grey05,
);

val Header04 = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_slab_extra_bold)),
    fontSize = 14.sp,
    letterSpacing = 0.3.sp,
    color = Grey05,
);

val Body01SemiBold = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_slab_semi_bold)),
    fontSize = 16.sp,
    letterSpacing = 0.sp,
    color = Grey05,
);

val Body01 = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_slab_regular)),
    fontSize = 16.sp,
    letterSpacing = 0.sp,
    color = Grey05,
);

val Body02 = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_slab_regular)),
    fontSize = 14.sp,
    letterSpacing = 0.sp,
    color = Grey05,
);

val Body02SemiBold = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_slab_semi_bold)),
    fontSize = 14.sp,
    letterSpacing = 0.sp,
    color = Grey05,
);

val Body03 = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_slab_regular)),
    fontSize = 12.sp,
    letterSpacing = 0.sp,
    color = Grey05,
);

val Body04 = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_slab_regular)),
    fontSize = 9.sp,
    letterSpacing = 0.sp,
    color = Grey05,
);
