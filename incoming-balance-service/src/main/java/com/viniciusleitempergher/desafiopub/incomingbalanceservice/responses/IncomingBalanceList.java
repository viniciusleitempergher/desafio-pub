package com.viniciusleitempergher.desafiopub.incomingbalanceservice.responses;

import java.util.List;

import com.viniciusleitempergher.desafiopub.incomingbalanceservice.models.IncomingBalance;

public class IncomingBalanceList {
	private List<IncomingBalance> listaReceitas;

	public IncomingBalanceList() {
		super();
	}

	public List<IncomingBalance> getListaReceitas() {
		return listaReceitas;
	}

	public void setListaReceitas(List<IncomingBalance> listaReceitas) {
		this.listaReceitas = listaReceitas;
	}

}
