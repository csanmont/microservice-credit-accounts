package com.nttdata.microservice.bankcreditaccounts.services.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.microservice.bankcreditaccounts.collections.CreditMovementCollection;
import com.nttdata.microservice.bankcreditaccounts.enums.CreditMovementTypeEnum;
import com.nttdata.microservice.bankcreditaccounts.repository.ICreditMovementRepository;
import com.nttdata.microservice.bankcreditaccounts.services.ICreditMovementService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditMovementServiceImpl implements ICreditMovementService {
	
	@Autowired
	private ICreditMovementRepository repository;

	@Override
	public Mono<CreditMovementCollection> savePaymentCredit(CreditMovementCollection collection) {
		collection.setMovementType(CreditMovementTypeEnum.PAYMENT_CREDIT.toString());
		return repository.save(collection);
	}

	@Override
	public Mono<CreditMovementCollection> savePaymentCreditCard(CreditMovementCollection collection) {
		collection.setMovementType(CreditMovementTypeEnum.PAYMENT_CREDIT_CARD.toString());
		return repository.save(collection);
	}

	@Override
	public Mono<CreditMovementCollection> saveConsumeCreditCard(CreditMovementCollection collection) {
		collection.setMovementType(CreditMovementTypeEnum.CONSUME_CREDIT_CARD.toString());
		return repository.save(collection);
	}

	@Override
	public Mono<CreditMovementCollection> savePaymentCreditThird(CreditMovementCollection collection) {
		collection.setMovementType(CreditMovementTypeEnum.PAYMENT_CREDIT_THIRD.toString());
		return repository.save(collection);
	}

	/*@Override
	public Flux<CreditMovementCollection> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<CreditMovementCollection> getByPersonCode(String personCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<CreditMovementCollection> save(CreditMovementCollection collection) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<CreditMovementCollection> update(CreditMovementCollection updatedCollection, String creditMovementCode)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> delete(CreditMovementCollection collection) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}*/
	

	/*@Override
	public Flux<CreditMovementCollection> getAll() throws Exception {
		// TODO Auto-generated method stub
		return creditMovementRepository.findAll();
	}

	@Override
	public Flux<CreditMovementCollection> getByPersonCode(String personCode) throws Exception {
		// TODO Auto-generated method stub
		
		Flux<CreditMovementCollection> col = creditMovementRepository.findAll().filter(x -> x.getPersonCode().equals(personCode));
		
		return col;
	}

	@Override
	public Mono<CreditMovementCollection> save(CreditMovementCollection collection) throws Exception {
		// TODO Auto-generated method stub
		collection.setCreditMovementCode(UUID.randomUUID().toString());
		
		collection.setState("1");
		collection.setCreatedAt(new Date());
		
		return creditMovementRepository.save(collection);
	}

	@Override
	public Mono<CreditMovementCollection> update(CreditMovementCollection updatedCollection, String creditMovementCode)
			throws Exception {
		// TODO Auto-generated method stub
		Mono<CreditMovementCollection> result = creditMovementRepository.findAll().filter(x -> x.getCreditMovementCode().equals(creditMovementCode)).next();
		CreditMovementCollection resultNew = result.block();
		
		resultNew.setMovementType(updatedCollection.getMovementType());
		resultNew.setAmount(updatedCollection.getAmount());
		resultNew.setCurrency(updatedCollection.getCurrency());
		
		resultNew.setState(updatedCollection.getState());
		resultNew.setUpdatedAt(new Date());
		
		return creditMovementRepository.save(resultNew);
	}

	@Override
	public Mono<Void> delete(CreditMovementCollection collection) throws Exception {
		// TODO Auto-generated method stub
		Mono<CreditMovementCollection> result = creditMovementRepository.findAll().filter(x -> x.getCreditMovementCode().equals(collection.getCreditMovementCode())).next();
		CreditMovementCollection resultNew = result.block();
		
		return creditMovementRepository.delete(resultNew);
	}*/

}