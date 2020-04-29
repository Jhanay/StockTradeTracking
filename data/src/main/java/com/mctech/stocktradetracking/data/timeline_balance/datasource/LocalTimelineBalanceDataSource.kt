package com.mctech.stocktradetracking.data.timeline_balance.datasource

import com.mctech.stocktradetracking.data.timeline_balance.database.TimelineBalanceDao
import com.mctech.stocktradetracking.data.timeline_balance.mapper.toBusinessEntity
import com.mctech.stocktradetracking.data.timeline_balance.mapper.toDatabaseEntity
import com.mctech.stocktradetracking.domain.timeline_balance.entity.TimelineBalance

class LocalTimelineBalanceDataSource(
	private val dao : TimelineBalanceDao
): TimelineBalanceDataSource{

	override suspend fun createPeriod(period: TimelineBalance){
		dao.save(period.toDatabaseEntity())
	}

	override suspend fun editPeriod(period: TimelineBalance){
		dao.save(period.toDatabaseEntity())
	}

	override suspend fun getListOfPeriodsBalance(): List<TimelineBalance> {
		return dao.loadCurrentPeriod().map { it.toBusinessEntity() }
	}

	override suspend fun getPeriodTransactions(period: TimelineBalance): List<TimelineBalance>{
		TODO()
	}

	override suspend fun depositMoney(amount: Double){
		TODO()
	}

	override suspend fun withdrawMoney(amount: Double){
		TODO()
	}

}
