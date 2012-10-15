package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.ldv.sio.getap.AccPersonalise;
import org.ldv.sio.getap.Classe;
import org.ldv.sio.getap.DVCTAPException;
import org.ldv.sio.getap.DemandeValidationConsoTempsAccPers;
import org.ldv.sio.getap.Discipline;
import org.ldv.sio.getap.User;

public class TestDemandeValidationConsoTempsAccPers {

	Integer itg = new Integer(1);
	Long lng = new Long(1);
	Integer time = new Integer(240);
	Classe SIO22 = new Classe(itg, "SIO22");
	Discipline PPE = new Discipline(itg, "PPE");

	User NBR = new User(lng, "Nizar", "Ben Ragdel", SIO22, "élève");
	User OKP = new User(lng, "Olivier", "Capuozzo", SIO22, "professeur", PPE);

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testDemandeValidationConsoTempsAccPersLongStringDateIntegerUserAccPersonaliseUserInt() {

		try {

			AccPersonalise SDL = new AccPersonalise(itg, "Salon Du Libre", 1,
					lng);

			DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers();
			dvctap.setId(lng);
			dvctap.setAnneeScolaire("2012");
			dvctap.setDateAction(new java.sql.Date(07 / 10 / 12));
			dvctap.setMinutes(time);
			dvctap.setProf(OKP);
			dvctap.setAccPers(SDL);
			dvctap.setEleve(NBR);
			dvctap.setEtat(0);

			assertNotNull("DVCTAP non null : ", dvctap);

		} catch (DVCTAPException e) {
		}

	}

	@Test
	public void testEtatInitial() {

		try {

			AccPersonalise SDL = new AccPersonalise(itg, "Salon Du Libre", 1,
					lng);

			DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers();
			dvctap.setId(lng);
			dvctap.setAnneeScolaire("2012");
			dvctap.setDateAction(new java.sql.Date(07 / 10 / 12));
			dvctap.setMinutes(time);
			dvctap.setProf(OKP);
			dvctap.setAccPers(SDL);
			dvctap.setEleve(NBR);
			dvctap.setEtat(0);

			System.out.println(dvctap.getEtat());

			assertTrue("Etat initial", dvctap.isEtatInitial());
		} catch (DVCTAPException e) {

		}
	}

	@Test
	public void testDemandeAnnuleeEleve() {

		try {

			AccPersonalise SDL = new AccPersonalise(itg, "Salon Du Libre", 1,
					lng);

			DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers();
			dvctap.setId(lng);
			dvctap.setAnneeScolaire("2012");
			dvctap.setDateAction(new java.sql.Date(07 / 10 / 12));
			dvctap.setMinutes(time);
			dvctap.setProf(OKP);
			dvctap.setAccPers(SDL);
			dvctap.setEleve(NBR);

			dvctap.sauvegarde(8, 0);

			System.out.println(dvctap.chargement());

			assertTrue("Demande annulée par l'éleve",
					dvctap.cheminsPossible(dvctap.chargement()));
		} catch (DVCTAPException e) {

		}
	}

	@Test
	public void testDemandeRefuseeProf() {

		try {

			AccPersonalise SDL = new AccPersonalise(itg, "Salon Du Libre", 1,
					lng);

			DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers();
			dvctap.setId(lng);
			dvctap.setAnneeScolaire("2012");
			dvctap.setDateAction(new java.sql.Date(07 / 10 / 12));
			dvctap.setMinutes(time);
			dvctap.setProf(OKP);
			dvctap.setAccPers(SDL);
			dvctap.setEleve(NBR);

			dvctap.sauvegarde(64, 0);

			System.out.println(dvctap.chargement());

			assertTrue("Demande annulée par l'éleve",
					dvctap.cheminsPossible(dvctap.chargement()));
		} catch (DVCTAPException e) {

		}
	}

	@Test
	public void testDemandeValideeProf() {

		try {

			AccPersonalise SDL = new AccPersonalise(itg, "Salon Du Libre", 1,
					lng);

			DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers();
			dvctap.setId(lng);
			dvctap.setAnneeScolaire("2012");
			dvctap.setDateAction(new java.sql.Date(07 / 10 / 12));
			dvctap.setMinutes(time);
			dvctap.setProf(OKP);
			dvctap.setAccPers(SDL);
			dvctap.setEleve(NBR);

			dvctap.sauvegarde(32, 0);

			System.out.println(dvctap.chargement());

			assertTrue("Demande annulée par l'éleve",
					dvctap.cheminsPossible(dvctap.chargement()));
		} catch (DVCTAPException e) {

		}
	}

	@Test
	public void testDemandeModifieeAnnuleeEleve() {

		try {

			AccPersonalise SDL = new AccPersonalise(itg, "Salon Du Libre", 1,
					lng);

			DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers();
			dvctap.setId(lng);
			dvctap.setAnneeScolaire("2012");
			dvctap.setDateAction(new java.sql.Date(07 / 10 / 12));
			dvctap.setMinutes(time);
			dvctap.setProf(OKP);
			dvctap.setAccPers(SDL);
			dvctap.setEleve(NBR);

			dvctap.sauvegarde(4, 0);
			dvctap.sauvegarde(8, 1);

			System.out.println(dvctap.chargement());

			assertTrue("Demande annulée par l'éleve",
					dvctap.cheminsPossible(dvctap.chargement()));
		} catch (DVCTAPException e) {

		}
	}

	@Test
	public void testDemandeDateModifieeAccepteeEleve() {

		try {

			AccPersonalise SDL = new AccPersonalise(itg, "Salon Du Libre", 1,
					lng);

			DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers();
			dvctap.setId(lng);
			dvctap.setAnneeScolaire("2012");
			dvctap.setDateAction(new java.sql.Date(07 / 10 / 12));
			dvctap.setMinutes(time);
			dvctap.setProf(OKP);
			dvctap.setAccPers(SDL);
			dvctap.setEleve(NBR);

			dvctap.sauvegarde(1024, 0);
			dvctap.sauvegarde(1, 1);

			System.out.println(dvctap.chargement());

			assertTrue("Demande annulée par l'éleve",
					dvctap.cheminsPossible(dvctap.chargement()));
		} catch (DVCTAPException e) {

		}
	}

	@Test
	public void testDemandeDateModifieeRefuseeEleve() {

		try {

			AccPersonalise SDL = new AccPersonalise(itg, "Salon Du Libre", 1,
					lng);

			DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers();
			dvctap.setId(lng);
			dvctap.setAnneeScolaire("2012");
			dvctap.setDateAction(new java.sql.Date(07 / 10 / 12));
			dvctap.setMinutes(time);
			dvctap.setProf(OKP);
			dvctap.setAccPers(SDL);
			dvctap.setEleve(NBR);

			dvctap.sauvegarde(1024, 0);
			dvctap.sauvegarde(2, 1);

			System.out.println(dvctap.chargement());

			assertTrue("Demande annulée par l'éleve",
					dvctap.cheminsPossible(dvctap.chargement()));
		} catch (DVCTAPException e) {

		}
	}

	@Test
	public void testDemandeDureeModifieeAccepteeEleve() {

		try {

			AccPersonalise SDL = new AccPersonalise(itg, "Salon Du Libre", 1,
					lng);

			DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers();
			dvctap.setId(lng);
			dvctap.setAnneeScolaire("2012");
			dvctap.setDateAction(new java.sql.Date(07 / 10 / 12));
			dvctap.setMinutes(time);
			dvctap.setProf(OKP);
			dvctap.setAccPers(SDL);
			dvctap.setEleve(NBR);

			dvctap.sauvegarde(2048, 0);
			dvctap.sauvegarde(1, 1);

			System.out.println(dvctap.chargement());

			assertTrue("Demande annulée par l'éleve",
					dvctap.cheminsPossible(dvctap.chargement()));
		} catch (DVCTAPException e) {

		}
	}

	@Test
	public void testDemandeDureeModifieeRefuseeEleve() {

		try {

			AccPersonalise SDL = new AccPersonalise(itg, "Salon Du Libre", 1,
					lng);

			DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers();
			dvctap.setId(lng);
			dvctap.setAnneeScolaire("2012");
			dvctap.setDateAction(new java.sql.Date(07 / 10 / 12));
			dvctap.setMinutes(time);
			dvctap.setProf(OKP);
			dvctap.setAccPers(SDL);
			dvctap.setEleve(NBR);

			dvctap.sauvegarde(2048, 0);
			dvctap.sauvegarde(2, 1);

			System.out.println(dvctap.chargement());

			assertTrue("Demande annulée par l'éleve",
					dvctap.cheminsPossible(dvctap.chargement()));
		} catch (DVCTAPException e) {

		}
	}

	@Test
	public void testDemandeAPModifieeAccepteeEleve() {

		try {

			AccPersonalise SDL = new AccPersonalise(itg, "Salon Du Libre", 1,
					lng);

			DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers();
			dvctap.setId(lng);
			dvctap.setAnneeScolaire("2012");
			dvctap.setDateAction(new java.sql.Date(07 / 10 / 12));
			dvctap.setMinutes(time);
			dvctap.setProf(OKP);
			dvctap.setAccPers(SDL);
			dvctap.setEleve(NBR);

			dvctap.sauvegarde(4096, 0);
			dvctap.sauvegarde(1, 1);

			System.out.println(dvctap.chargement());

			assertTrue("Demande annulée par l'éleve",
					dvctap.cheminsPossible(dvctap.chargement()));
		} catch (DVCTAPException e) {

		}
	}

	@Test
	public void testDemandeAPModifieeRefuseeEleve() {

		try {

			AccPersonalise SDL = new AccPersonalise(itg, "Salon Du Libre", 1,
					lng);

			DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers();
			dvctap.setId(lng);
			dvctap.setAnneeScolaire("2012");
			dvctap.setDateAction(new java.sql.Date(07 / 10 / 12));
			dvctap.setMinutes(time);
			dvctap.setProf(OKP);
			dvctap.setAccPers(SDL);
			dvctap.setEleve(NBR);

			dvctap.sauvegarde(4096, 0);
			dvctap.sauvegarde(2, 1);

			System.out.println(dvctap.chargement());

			assertTrue("Demande annulée par l'éleve",
					dvctap.cheminsPossible(dvctap.chargement()));
		} catch (DVCTAPException e) {

		}
	}

	@Test
	public void testDemandeModifieeDateModifieeAccepteeEleve() {

		try {

			AccPersonalise SDL = new AccPersonalise(itg, "Salon Du Libre", 1,
					lng);

			DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers();
			dvctap.setId(lng);
			dvctap.setAnneeScolaire("2012");
			dvctap.setDateAction(new java.sql.Date(07 / 10 / 12));
			dvctap.setMinutes(time);
			dvctap.setProf(OKP);
			dvctap.setAccPers(SDL);
			dvctap.setEleve(NBR);

			dvctap.sauvegarde(4, 0);
			dvctap.sauvegarde(1024, 1);
			dvctap.sauvegarde(1, 2);

			System.out.println(dvctap.chargement());

			assertTrue("Demande annulée par l'éleve",
					dvctap.cheminsPossible(dvctap.chargement()));
		} catch (DVCTAPException e) {

		}
	}

	@Test
	public void testDemandeModifieeDateModifieeRefuseeEleve() {

		try {

			AccPersonalise SDL = new AccPersonalise(itg, "Salon Du Libre", 1,
					lng);

			DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers();
			dvctap.setId(lng);
			dvctap.setAnneeScolaire("2012");
			dvctap.setDateAction(new java.sql.Date(07 / 10 / 12));
			dvctap.setMinutes(time);
			dvctap.setProf(OKP);
			dvctap.setAccPers(SDL);
			dvctap.setEleve(NBR);

			dvctap.sauvegarde(4, 0);
			dvctap.sauvegarde(1024, 1);
			dvctap.sauvegarde(2, 2);

			System.out.println(dvctap.chargement());

			assertTrue("Demande annulée par l'éleve",
					dvctap.cheminsPossible(dvctap.chargement()));
		} catch (DVCTAPException e) {

		}
	}

	@Test
	public void testDemandeModifieeDureeModifieeAccepteeEleve() {

		try {

			AccPersonalise SDL = new AccPersonalise(itg, "Salon Du Libre", 1,
					lng);

			DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers();
			dvctap.setId(lng);
			dvctap.setAnneeScolaire("2012");
			dvctap.setDateAction(new java.sql.Date(07 / 10 / 12));
			dvctap.setMinutes(time);
			dvctap.setProf(OKP);
			dvctap.setAccPers(SDL);
			dvctap.setEleve(NBR);

			dvctap.sauvegarde(4, 0);
			dvctap.sauvegarde(2048, 1);
			dvctap.sauvegarde(1, 2);

			System.out.println(dvctap.chargement());

			assertTrue("Demande annulée par l'éleve",
					dvctap.cheminsPossible(dvctap.chargement()));
		} catch (DVCTAPException e) {

		}
	}
	
	@Test
	public void testDemandeModifieeDureeModifieeRefuseeEleve() {

		try {

			AccPersonalise SDL = new AccPersonalise(itg, "Salon Du Libre", 1,
					lng);

			DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers();
			dvctap.setId(lng);
			dvctap.setAnneeScolaire("2012");
			dvctap.setDateAction(new java.sql.Date(07 / 10 / 12));
			dvctap.setMinutes(time);
			dvctap.setProf(OKP);
			dvctap.setAccPers(SDL);
			dvctap.setEleve(NBR);

			dvctap.sauvegarde(4, 0);
			dvctap.sauvegarde(2048, 1);
			dvctap.sauvegarde(2, 2);

			System.out.println(dvctap.chargement());

			assertTrue("Demande annulée par l'éleve",
					dvctap.cheminsPossible(dvctap.chargement()));
		} catch (DVCTAPException e) {

		}
	}
	
	@Test
	public void testDemandeModifieeAPModifieeAccepteeEleve() {

		try {

			AccPersonalise SDL = new AccPersonalise(itg, "Salon Du Libre", 1,
					lng);

			DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers();
			dvctap.setId(lng);
			dvctap.setAnneeScolaire("2012");
			dvctap.setDateAction(new java.sql.Date(07 / 10 / 12));
			dvctap.setMinutes(time);
			dvctap.setProf(OKP);
			dvctap.setAccPers(SDL);
			dvctap.setEleve(NBR);

			dvctap.sauvegarde(4, 0);
			dvctap.sauvegarde(4096, 1);
			dvctap.sauvegarde(1, 2);

			System.out.println(dvctap.chargement());

			assertTrue("Demande annulée par l'éleve",
					dvctap.cheminsPossible(dvctap.chargement()));
		} catch (DVCTAPException e) {

		}
	}
	@Test
	public void testDemandeModifieeAPModifieeRefuseeEleve() {

		try {

			AccPersonalise SDL = new AccPersonalise(itg, "Salon Du Libre", 1,
					lng);

			DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers();
			dvctap.setId(lng);
			dvctap.setAnneeScolaire("2012");
			dvctap.setDateAction(new java.sql.Date(07 / 10 / 12));
			dvctap.setMinutes(time);
			dvctap.setProf(OKP);
			dvctap.setAccPers(SDL);
			dvctap.setEleve(NBR);

			dvctap.sauvegarde(4, 0);
			dvctap.sauvegarde(4096, 1);
			dvctap.sauvegarde(2, 2);

			System.out.println(dvctap.chargement());

			assertTrue("Demande annulée par l'éleve",
					dvctap.cheminsPossible(dvctap.chargement()));
		} catch (DVCTAPException e) {

		}
	}
}