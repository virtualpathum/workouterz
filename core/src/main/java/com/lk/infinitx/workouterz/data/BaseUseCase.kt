package com.lk.infinitx.workouterz.data


abstract class BaseUseCase<out Type,in Params> where Type : Any  {

    abstract suspend fun execute(params: Params): Type

    class None
}


