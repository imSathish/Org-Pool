import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.orgcarpool.core.navigation.NavigationRoute
import com.example.orgcarpool.features.login.LoginViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    navController: NavController,
    viewmodel: LoginViewModel = hiltViewModel(),
) {

    val isUserLoggedIn = viewmodel.isUserLoggedIn.collectAsState()
    if (isUserLoggedIn.value) {
        Toast.makeText(LocalContext.current, "User signed in", Toast.LENGTH_SHORT).show()
        navController.clearBackStack<NavigationRoute.LoginScreen>()
        navController.navigate(NavigationRoute.DashboardScreen)
    }

    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }

    Box(modifier, contentAlignment = Alignment.Center) {
        Column {
            TextField(modifier = Modifier.padding(4.dp), value = name, placeholder = {
                Text("Name")
            }, onValueChange = {
                name = it
            })
            TextField(modifier = Modifier.padding(4.dp), value = email, placeholder = {
                Text("Email")
            }, onValueChange = {
                email = it
            })
            Button(modifier = Modifier.padding(4.dp), onClick = {
                viewmodel.login(name, email)
            }) {
                Text("Login / Sign Up")
            }
        }
    }

}