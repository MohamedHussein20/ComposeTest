package com.memo.test

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.memo.test.ui.theme.Gym
import com.memo.test.ui.theme.listOfGyms


class GymsViewModel(private val stateHandle: SavedStateHandle) : ViewModel() {
    var state by mutableStateOf(restoreSelectedGyms())

    private fun getGyms() = listOfGyms
        fun toggleFavoriteState(gymId: Int){
                val gyms = state.toMutableList()
                val itemIndex = gyms.indexOfFirst { it.id == gymId }
                gyms[itemIndex] = gyms[itemIndex].copy(isFavorite = !gyms[itemIndex].isFavorite)
            storeSelectedGym(gyms[itemIndex])
            state = gyms
        }
    private fun storeSelectedGym(gym: Gym){
        val savedHandleList = stateHandle.get<List<Int>?>(FAV_IDS).orEmpty().toMutableList()
        if (gym.isFavorite){
            savedHandleList.add(gym.id)
        }
        else{
            savedHandleList.remove(gym.id)
        }
        stateHandle[FAV_IDS] = savedHandleList
    }

    private fun restoreSelectedGyms(): List<Gym>{
        val gyms = getGyms()
        stateHandle.get<List<Int>?>(FAV_IDS)?.let { savedIds->
            savedIds.forEach{ gymId->
                gyms.find { it.id == gymId }?.isFavorite = true
            }
        }
        return gyms
    }
    companion object{
        const val FAV_IDS = "FavoriteGymsIDS"
    }
}