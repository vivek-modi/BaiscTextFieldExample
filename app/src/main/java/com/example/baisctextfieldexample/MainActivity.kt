package com.example.baisctextfieldexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.InterceptPlatformTextInput
import androidx.compose.ui.platform.PlatformTextInputMethodRequest
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val textFieldState = remember { TextFieldState() }
            val interactionSource = remember { MutableInteractionSource() }

            InterceptPlatformTextInput(
                interceptor = { request, nextHandler ->
                    val modifiedRequest = PlatformTextInputMethodRequest { outAttributes ->
                        request.createInputConnection(outAttributes)
                    }
                    nextHandler.startInputMethod(modifiedRequest)
                }
            ) {
                BasicTextField(
                    state = textFieldState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(100.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        autoCorrectEnabled = false,
                    ),
                    decorator = { view ->
                        TextFieldDefaults.DecorationBox(
                            value = textFieldState.text.toString(),
                            innerTextField = view,
                            enabled = true,
                            singleLine = true,
                            interactionSource = interactionSource,
                            placeholder = {
                                Text("Only Letter")
                            },
                            visualTransformation = VisualTransformation.None
                        )
                    }
                )
            }
        }
    }
}