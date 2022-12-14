import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.shobu95.crebitscompose.ui.navigation.HomeScreenItem

@Composable
fun HomeBottomNavBar(
    navController: NavController,
) {
    val navItems = listOf(
        HomeScreenItem.Dashboard,
        HomeScreenItem.Transactions,
        HomeScreenItem.Settings)

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.secondary
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = stringResource(id = item.title)
                    )
                },
                label = { Text(text = stringResource(id = item.title), fontSize = 9.sp) },
                selected = (currentRoute == item.route),
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = Color.Gray,
                alwaysShowLabel = false,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}