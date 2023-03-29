package com.ibrahimcanerdogan.nasaspaceapp.data.repository.marsrover.datasourceImpl

import com.ibrahimcanerdogan.nasaspaceapp.data.database.MarsRoverDao
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.marsrover.datasource.MarsRoverLocalDataSource
import com.ibrahimcanerdogan.nasaspaceapp.model.marsrover.MarsRoverDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MarsRoverLocalDataSourceImpl(
    private val marsRoverDao: MarsRoverDao
) : MarsRoverLocalDataSource {

    override suspend fun getMarsRoverDataFromLocal(): List<MarsRoverDetail> {
        return marsRoverDao.getAllMarsRoverData()
    }

    override suspend fun saveMarsRoverDataToLocal(marsRoverData: List<MarsRoverDetail>) {
        CoroutineScope(Dispatchers.IO).launch {
            marsRoverDao.saveMarsRoverData(marsRoverData)
        }
    }

    override suspend fun clearMarsRoverDataFromLocal() {
        CoroutineScope(Dispatchers.IO).launch {
            marsRoverDao.deleteAllMarsRoverData()
        }
    }
}