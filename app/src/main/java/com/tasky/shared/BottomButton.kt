package com.tasky.shared

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tasky.R
import com.tasky.ui.theme.TaskyTheme

@Composable
fun BottomButton(
    isEnabled: Boolean,
    isLoading: Boolean = false,
    @StringRes textId: Int,
    onClick: () -> Unit
) {

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(55.dp),
        onClick = onClick,
        enabled = isEnabled
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = Color.White,
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
            )
        } else {
            Text(text = stringResource(id = textId))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomButtonPreview() {
    TaskyTheme {
        Column(Modifier.padding(16.dp)) {
            BottomButton(
                isEnabled = true,
                isLoading = false,
                onClick = {},
                textId = R.string.get_started
            )
            Spacer(modifier = Modifier.padding(8.dp))
            BottomButton(
                isEnabled = false,
                isLoading = false,
                onClick = {},
                textId = R.string.get_started
            )
            Spacer(modifier = Modifier.padding(8.dp))
            BottomButton(
                isEnabled = true,
                isLoading = true,
                onClick = {},
                textId = R.string.get_started
            )
            Spacer(modifier = Modifier.padding(8.dp))
            BottomButton(
                isEnabled = false,
                isLoading = true,
                onClick = {},
                textId = R.string.get_started
            )
        }
    }
}
