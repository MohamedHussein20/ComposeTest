package com.memo.test
import androidx.lifecycle.ViewModel
import com.memo.test.ui.theme.listOfGyms


class GymsViewModel : ViewModel()  {
        fun getGyms() = listOfGyms
}