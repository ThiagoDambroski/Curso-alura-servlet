package br.com.dambroski.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa(null, "Google");
		empresa.setId(chaveSequencial++);
		Empresa empresa2 = new Empresa(null,"Aura");
		empresa2.setId(chaveSequencial++);
		Banco.lista.add(empresa);
		Banco.lista.add(empresa2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		Banco.lista.add(empresa);
		
	}
	
	public List<Empresa> getEmpresa(){
		return Banco.lista;
	}

	public void remove(Integer id) {
		
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId() == id) {
				it.remove();
			}
			
		}
		
	}

	public Empresa buscaEmpresaId(Integer id) {
		for (Empresa empresa : lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

}
