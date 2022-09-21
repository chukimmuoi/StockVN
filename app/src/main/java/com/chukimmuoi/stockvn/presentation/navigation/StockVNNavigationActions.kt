package com.chukimmuoi.stockvn.presentation.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.chukimmuoi.stockvn.presentation.Screen

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 20/09/2022.
 */
class StockVNNavigationActions(navController: NavHostController) {

    val navigateToHome: () -> Unit = {
        navController.navigate(Screen.Home.route) {
            // Bật lên điểm đến bắt đầu của biểu đồ
            // để tránh tạo ra một lượng lớn các điểm đến trên ngăn xếp phía sau
            // khi người dùng chọn các mục.
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Tránh nhiều bản sao của cùng một item khi chọn lại cùng một mục.
            launchSingleTop = true
            // Khôi phục trạng thái khi chọn lại một item đã chọn trước đó.
            restoreState = true
        }
    }

    val navigateToStock: () -> Unit = {
        navController.navigate(Screen.Stock.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}