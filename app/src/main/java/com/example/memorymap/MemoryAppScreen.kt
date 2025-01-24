package com.example.memorymap

//import androidx.annotation.StringRes
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Close
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.currentBackStackEntryAsState
//import androidx.navigation.compose.rememberNavController
//import com.example.memorymap.ui.MemoryViewModel
//import com.example.memorymap.ui.theme.AppTheme
//
//enum class MemoryAppScreen(@StringRes val title: Int) {
//    Login(title = R.string.login),
//    Register(title = R.string.register),
//    Role(title = R.string.role),
//    Dashboard(title = R.string.dashboard),
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MemoryAppBar(
//    currentScreen: MemoryAppScreen,
//    canNavigateBack: Boolean,
//    navigateUp: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    TopAppBar(
//        title = { Text(stringResource(currentScreen.title))},
//        colors = TopAppBarDefaults.mediumTopAppBarColors(
//            containerColor = MaterialTheme.colorScheme.primaryContainer
//
//        ),
//        modifier = modifier,
//        navigationIcon = {
//            if(canNavigateBack) {
//                IconButton(onClick = navigateUp) {
//                    Icon(
//                        imageVector = Icons.Filled.Close,
//                        contentDescription = stringResource(id = R.string.back_button)
//                    )
//                }
//            }
//        }
//    )
//}
//
//@Composable
//fun MemoryApp(
//    viewModel: MemoryViewModel = viewModel,
//    navController: NavHostController = rememberNavController()
//) {
//    val backStackEntry by navController.currentBackStackEntryAsState()
//    val currentScreen = MemoryAppScreen.valueOf(
//        backStackEntry?.destination?.route ?: MemoryAppScreen.Login.name
//
//    )
//    Scaffold (
//        topBar = {
//            MemoryAppBar(
//                currentScreen = currentScreen,
//                canNavigateBack = navController.previousBackStackEntry != null,
//                navigateUp = { navController.navigateUp() }
//            )
//        }
//     ) { innerPadding ->
//        val uiState by viewModel.uiState.collectAsState()
//        NavHost(
//            navController = navController,
//            startDestination = MemoryAppScreen.Login.name,
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(innerPadding)
//                .verticalScroll(rememberScrollState()),
//        ){
//            composable(route = MemoryAppScreen.Login.name) {
//
//            }
//        }
//
//
//
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MemoryApp(
//
//    ) {
//
//    }
//}