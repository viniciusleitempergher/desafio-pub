package com.viniciusleitempergher.desafiopub.expendingbalanceservice.responses;

import java.util.List;

import com.viniciusleitempergher.desafiopub.expendingbalanceservice.models.ExpendingBalance;

public class ExpendingBalanceList {
	private List<ExpendingBalance> expendingList;

	public ExpendingBalanceList() {
		super();
	}

	public List<ExpendingBalance> getExpendingList() {
		return expendingList;
	}

	public void setExpendingList(List<ExpendingBalance> expendingList) {
		this.expendingList = expendingList;
	}

}
