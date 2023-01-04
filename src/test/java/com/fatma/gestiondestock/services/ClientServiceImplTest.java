package com.fatma.gestiondestock.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.lenient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fatma.gestiondestock.dto.AdressDto;
import com.fatma.gestiondestock.dto.ClientDto;
import com.fatma.gestiondestock.exception.EntityNotFoundException;
import com.fatma.gestiondestock.exception.ErrorCodes;
import com.fatma.gestiondestock.mapper.ClientDtoClientMapper;
import com.fatma.gestiondestock.model.Adress;
import com.fatma.gestiondestock.model.Client;
import com.fatma.gestiondestock.repository.ClientRepository;
import com.fatma.gestiondestock.services.Impl.ClientServiceImpl;

@ExtendWith(MockitoExtension.class)

public class ClientServiceImplTest {

	@InjectMocks
	private ClientServiceImpl clientService;

	@Mock
	private ClientRepository clientRepository;

	@Test
	void shouldSaveClientWithSuccess() {

		ClientDto expectedClient = ClientDto.builder().code("code").nom("nom").prenom("prenom")
				.adress(AdressDto.builder().adress1("adress1").build()).build();

		Client savedClient = Client.builder().code("code").nom("nom").prenom("prenom")
				.adress(Adress.builder().adress1("adress1").build()).build();

		lenient().when(clientRepository.save(ClientDtoClientMapper.INSTANCE.clientDtoToClient(expectedClient)))
				.thenReturn(savedClient);

		assertEquals(expectedClient.getCode(), savedClient.getCode());

	}

	@Test
	public void testFindNonExistentClientById() {
		final EntityNotFoundException thrown = assertThrows(EntityNotFoundException.class,
				() -> clientService.findById(null));

		assertEquals(thrown.getErrorCode(), ErrorCodes.CLIENT_NOT_FOUND);
	}

}
