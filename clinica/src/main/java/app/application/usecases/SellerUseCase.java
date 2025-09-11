package app.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.services.CreateInvoice;

@Service
public class SellerUseCase {
	@Autowired
	private CreateInvoice createInvoice;
	

}
