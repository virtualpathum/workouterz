package com.lk.infinitx.workouterz.interactor


abstract class BaseUseCase<out Type,in Params> where Type : Any  {

    abstract suspend fun execute(params: Params): Type

    class None
}


