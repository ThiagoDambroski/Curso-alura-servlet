package br.com.dambroski.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	
	static {
		Empresa empresa = new Empresa(null, "Google");
		Empresa empresa2 = new Empresa(null,"Aura");
		Banco.lista.add(empresa);
		Banco.lista.add(empresa2);
	}

	public void adiciona(Empresa empresa) {
		Banco.lista.add(empresa);
		
	}
	
	public List<Empresa> getEmpresa(){
		return Banco.lista;
	}

}
