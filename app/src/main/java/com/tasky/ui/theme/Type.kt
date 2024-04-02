package com.tasky.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.tasky.R

// Declare the font families
object AppFont {
    private val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )

    private val fontName = GoogleFont("Inter")

    val InterFontFamily = FontFamily(
        androidx.compose.ui.text.googlefonts.Font(googleFont = fontName, fontProvider = provider)
    )
}

private val defaultTypography = Typography()
val Typography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = AppFont.InterFontFamily),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = AppFont.InterFontFamily),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = AppFont.InterFontFamily),

    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = AppFont.InterFontFamily),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = AppFont.InterFontFamily),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = AppFont.InterFontFamily),

    titleLarge = defaultTypography.titleLarge.copy(fontFamily = AppFont.InterFontFamily),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = AppFont.InterFontFamily),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = AppFont.InterFontFamily),

    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = AppFont.InterFontFamily),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = AppFont.InterFontFamily),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = AppFont.InterFontFamily),

    labelLarge = defaultTypography.labelLarge.copy(fontFamily = AppFont.InterFontFamily),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = AppFont.InterFontFamily),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = AppFont.InterFontFamily)
)