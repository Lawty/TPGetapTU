package org.ldv.sio.getap;

import java.sql.Date;

public class Exemple {

	public static void main(String arg[]) {
		Integer itg = new Integer(1);
		Long lng = new Long(1);
		Integer time = new Integer(240);
		Classe SIO22 = new Classe(itg, "SIO22");
		Discipline PPE = new Discipline(itg, "PPE");

		User NBR = new User(lng, "Nizar", "Ben Ragdel", SIO22, "élève");
		User OKP = new User(lng, "Olivier", "Capuozzo", SIO22, "professeur",
				PPE);

		AccPersonalise SDL = new AccPersonalise(itg, "Salon Du Libre", 1, lng);

		DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers();
		dvctap.setId(lng);
		dvctap.setAnneeScolaire("2012");
		dvctap.setDateAction(new java.sql.Date(07 / 10 / 12));
		dvctap.setMinutes(time);
		dvctap.setProf(OKP);
		dvctap.setAccPers(SDL);
		dvctap.setEleve(NBR);
		dvctap.setEtat(0);
	}

}
