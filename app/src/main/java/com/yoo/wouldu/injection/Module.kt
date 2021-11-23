package com.yoo.wouldu.injection

import com.yoo.wouldu.model.ChatRepository
import com.yoo.wouldu.model.RequestRepository
import com.yoo.wouldu.viewmodel.ChatViewModel
import com.yoo.wouldu.viewmodel.RequestViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val viewModelModule = module {
    // Request
    single { RequestRepository() }
    viewModel { RequestViewModel(get()) }

    // Chat
    single { ChatRepository() }
    viewModel { ChatViewModel(get()) }
}