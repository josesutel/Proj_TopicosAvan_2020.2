package clientes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clientes.entidades.Clientes;
import clientes.repository.ClientesRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClientesRepository clientesRepository;
    
	//private static final CrudRepository<Clientes, Long> clientesRepository = null;
	
	
	
  
@Override
	public List<Clientes> buscar() {
		ArrayList<Clientes> lista = new ArrayList<>();
		Iterable<Clientes> userIt = clientesRepository.findAll();
		 userIt.forEach(u -> lista.add(u));
		
		return lista;
}
	@Override
	public void alterar(Clientes clientes)throws Exception{
		if(clientes.getCpf()!= clientes.getCpf()) {
			throw new Exception("Digite um cpf valido");
		}
		clientesRepository.save(clientes);
	
	}

	@Override
	public void salvar(Clientes clientes) throws Exception {
		if(clientes.getNome().equals("")){
			throw new Exception("O campo nome deve ser preenchido");
		}
		clientesRepository.save(clientes);
	}

	@Override
	public void deletar(Clientes clientes) throws Exception {
		if(clientes.getId()!= clientes.getId()) {
			throw new Exception("Digite o ID correto do Cliente");
		}
		clientesRepository.delete(clientes);
	}
		@Override
	public Clientes getClientesByCpf(int cpf)throws Exception {
		if( clientesRepository.existsById(Integer.toUnsignedLong(cpf))== false) {
			throw new Exception("Cliente nao cadastrado");
		}
		return clientesRepository.getClientesByCpf(cpf);
	
	}

}
