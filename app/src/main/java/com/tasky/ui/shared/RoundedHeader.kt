package com.tasky.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tasky.R
import com.tasky.ui.theme.TaskyTheme

@Composable
fun RoundedHeaderComposable(text: String) {
    val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )

    val fontName = GoogleFont("Inter")

    val fontFamily = FontFamily(
        Font(googleFont = fontName, fontProvider = provider)
    )

    Surface(color = MaterialTheme.colorScheme.primary) {
        Column {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                fontSize = 28.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(16.dp)
                    .background(Color.White, RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RoundedHeaderComposablePreview() {
    TaskyTheme {
        Column {
            RoundedHeaderComposable("Short Text")
            RoundedHeaderComposable("Super Hyper Ultra Mega Big Text")
        }
    }
}