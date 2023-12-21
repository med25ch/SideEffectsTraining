package com.example.sideeffectstraining.launchedeffect

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.sideeffectstraining.ui.theme.SideEffectsTrainingTheme

@Composable
fun MyComposable(name: String, modifier: Modifier = Modifier) {

    var state by remember { mutableStateOf(true) }
    val context = LocalContext.current

    // LaunchedEffect is a composable function that is used to launch a coroutine inside the scope of composable,
    // when LaunchedEffect enters the composition, it launches a coroutine and cancels when it leaves composition.
    // LaunchedEffect takes multiple keys as params and if any of the key changes it cancels the existing coroutine and launch again.
    // This is useful for performing side effects, such as making network calls or updating a database, without blocking the UI thread.
    LaunchedEffect(key1 = Unit){
        Toast.makeText(context,"Show Toast",Toast.LENGTH_SHORT).show()
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(
            text = "Hello $name! : $state",
            modifier = modifier.clickable {
                state = !state
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyComposablePreview() {
    SideEffectsTrainingTheme {
        MyComposable("Android")
    }
}