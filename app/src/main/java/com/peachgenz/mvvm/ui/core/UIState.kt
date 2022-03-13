package com.peachgenz.mvvm.ui.core

sealed class UIState

object Loading : UIState()

object HasData : UIState()

data class ServerError(val errorMsg: String = "") : UIState()