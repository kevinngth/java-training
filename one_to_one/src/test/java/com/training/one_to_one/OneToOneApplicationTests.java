package com.training.one_to_one;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
public class OneToOneApplicationTests {

	@Autowired
	EntityManager em;
	@Autowired
	OwnerRepository ownerRepo;
	@Autowired
	PetRepository petRepo;

	void flushAndClear() {
		em.flush();
		em.clear();
	}

	@Test
	void shouldAddOwner() {
		Owner o = new Owner("Bob", "99 Brooklyn Ave");
		ownerRepo.save( o );
		flushAndClear();
		List<Owner> list = (List<Owner>) ownerRepo.findAll();
		assertThat( list.get(0).getName() ).isEqualTo( "Bob" );
	}

	@Test
	void shouldAddPet() {
		Pet p = new Pet("Bob", "dog");
		petRepo.save( p );
		flushAndClear();
		List<Pet> list = (List<Pet>) petRepo.findAll();
		assertThat( list.get(0).getName() ).isEqualTo( "Bob" );
	}

	@Test
	void shouldGetOwnerOfPet() {
		Owner o = new Owner("Bob", "99 Brooklyn Ave");
		Pet p = new Pet("Bob", "dog");
		o.setPet( p );
		p.setOwner( o );
		ownerRepo.save( o );
		flushAndClear();
		List<Pet> list = (List<Pet>) petRepo.findAll();
		assertThat( list.get(0).getOwner().getName() ).isEqualTo( "Bob" );
	}
}
