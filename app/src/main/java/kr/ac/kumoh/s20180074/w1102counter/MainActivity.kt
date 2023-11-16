package kr.ac.kumoh.s20180074.w1102counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.s20180074.w1102counter.ui.theme.W1102CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                // 중괄호 부분이 content 인자로 전달됨
                Column {
                    Counter()
                    Counter()
                }
                //Clicker()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) { // Unit = void
    W1102CounterTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

@Composable
fun Clicker() {
    // 리액트의 var (name, setName) = useState("눌러주세요")와 동일함
    var (txtString, setTxtString) = remember { //
        mutableStateOf("눌러주세요")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = txtString,
            fontSize = 70.sp,
        )
        Button(modifier = Modifier
            .fillMaxWidth(),
            onClick = {
                setTxtString("눌렸음!!!")
            }) {
            // Text(text = "눌러봐")
            Text("눌러봐")
        }
    }
}

@Composable
fun Counter() {
    // 리액트의 var (name, setName) = useState("눌러주세요")와 동일함
    var (num, setNum) = rememberSaveable { // remember는 화면전환 시 데이터 소멸, 이거는 유지됨
        mutableStateOf(0)
    }

    Column(modifier = Modifier
        .padding(8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = num.toString(),
            fontSize = 70.sp,
        )
        Row(modifier = Modifier
            .wrapContentWidth(),
        ){
            Button(modifier = Modifier.weight(2F), // 플러터 expanded 위젯과 비슷
                    onClick = {
                setNum(++num)
            }) {
                // Text(text = "눌러봐")
                Text("Increament")
            }
            Spacer(modifier = Modifier.width(8.dp)) // 컴포저블에 마진 없어서
            Button(modifier = Modifier.weight(2f),
                onClick = {
                    setNum(--num)
                }) {
                // Text(text = "눌러봐")
                Text("Decreament")
            }
        }

    }
}