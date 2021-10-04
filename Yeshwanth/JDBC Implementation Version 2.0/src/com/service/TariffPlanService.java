package com.service;

import com.bean.TariffPlan;
import com.dao.TariffPlanDAO;

public class TariffPlanService {
	
public static boolean registerTariffPlan(TariffPlan plan){
		
		
		TariffPlanDAO dao= new TariffPlanDAO();
		
		return dao.registerTariffPlan(plan);
	}

}
