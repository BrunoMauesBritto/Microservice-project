package com.bruno.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.hrpayroll.entites.Payment;
import com.bruno.hrpayroll.entites.Worker;
import com.bruno.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {


	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(long workerId, int days) {
		
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
