package com.example.testinterview.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.testinterview.viewmodel.ListViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;


import javax.inject.Singleton;

@Singleton
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel.class)
    abstract ViewModel bindListViewModel(ListViewModel listViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProvider.AndroidViewModelFactory factory);
}
