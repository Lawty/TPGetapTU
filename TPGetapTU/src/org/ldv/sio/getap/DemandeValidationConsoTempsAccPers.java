package org.ldv.sio.getap;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Demande de validation d'un temps d'accompagnement personnalisé
 * 
 * 
 */

public class DemandeValidationConsoTempsAccPers {
	private static final int DATE_MODIFIEE = 1024;
	private static final int DUREE_MODIFIEE = 2048;
	private static final int AP_MODIFIEE = 4096;
	private static final int DEMANDE_INIT = 0;
	private static final int ELEVE_ACCEPTEE = 1;
	private static final int ELEVE_REFUSE = 2;
	private static final int ELEVE_MODIFIEE = 4;
	private static final int ELEVE_ANNULEE = 8;
	private static final int PROF_VALIDEE = 32;
	private static final int PROF_REFUSEE = 64;

	/**
	 * mise en mémoire des actions dans un tableau
	 */
	ArrayList<Integer> liste = new ArrayList<Integer>();

	/**
	 * Identifiant de la DCTAP
	 */
	private Long id;
	/**
	 * Année scolaire de la demande, par exemple "2011-2012"
	 */
	private String anneeScolaire;
	/**
	 * Date de réalisation de l'accompagnement
	 * 
	 */
	private java.sql.Date dateAction;
	/**
	 * Nombre de minutes d'accompagnement personnalisé à valider
	 */
	private Integer minutes;
	/**
	 * Professeur ayant assuré l'accompagnement personnalisé
	 */
	private User prof;
	/**
	 * Nature de l'accompagnement personnalisé associé à la demande
	 */
	private AccPersonalise accPers;
	/**
	 * Identifiant de l'élève ayant réalisé l'accompagnement personnalisé
	 */
	private User eleve;

	/**
	 * 
	 */
	private int etat;

	/**
	 * constructeur par défaut
	 */
	public DemandeValidationConsoTempsAccPers() {

	}

	/**
	 * Constructeur permettant de créer une demande complète.
	 * 
	 * @param id
	 *            peut être null (moment de la creation)
	 * 
	 * @param anneeScolaire
	 * @param date
	 * @param minutes
	 * @param prof
	 * @param accPers
	 * @param eleve
	 * @param etat
	 */
	public DemandeValidationConsoTempsAccPers(Long id, String anneeScolaire,
			Date date, Integer minutes, User prof, AccPersonalise accPers,
			User eleve, int etat) {
		super();
		this.id = id;
		this.anneeScolaire = anneeScolaire;
		this.dateAction = date;
		this.minutes = minutes;
		this.prof = prof;
		this.accPers = accPers;
		this.eleve = eleve;
		this.etat = etat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	public java.sql.Date getDateAction() {
		return dateAction;
	}

	public void setDateAction(java.sql.Date date) {
		this.dateAction = date;
	}

	public Integer getMinutes() {
		return minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

	public User getProf() {
		return prof;
	}

	public void setProf(User prof) {
		this.prof = prof;
	}

	public AccPersonalise getAccPers() {
		return accPers;
	}

	public void setAccPers(AccPersonalise accPers) {
		this.accPers = accPers;
	}

	public User getEleve() {
		return eleve;
	}

	public void setEleve(User eleve) {
		this.eleve = eleve;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int i) {

		this.etat = i;

	}

	/**
	 * Permet de modifier l'état de la demande
	 * 
	 * @param etat
	 *            prend ses valeur dans :
	 *            <ul>
	 *            <li>0 - demande créée par l'élève</li>
	 *            <li>1 - demande acceptée par l'élève aprés modification du
	 *            professeur</li>
	 *            <li>2 - demande rejetée par l'élève aprés modification du
	 *            professeur</li>
	 *            <li>4 - demande modifiée par l'élève</li>
	 *            <li>8 - demande annulée par l'élève</li>
	 *            <li>32 - demande validée par le professeur</li>
	 *            <li>64 - demande refusée par le professeur</li>
	 *            <li>1024 - demande où la date a été modifiée par le professeur
	 *            </li>
	 *            <li>2048 - demande où la durée a été modifiée par le
	 *            professeur</li>
	 *            <li>4096 - demande où l'accompagnement personnalisé a été
	 *            modifiée par le professeur</li>
	 *            </ul>
	 */

	// /** Insère la valeur dans une liste de Integer */

	public void sauvegarde(int etat, int index) {

		this.liste.add(index, etat);

	}

	public boolean isEtatInitial() {

		return this.etat == DEMANDE_INIT;

	}

	/**
	 * Test des diférents chemins
	 */

	public boolean cheminsPossible(ArrayList<Integer> a) {

		int longueurListe = a.size();

		if (longueurListe == 1) {
			if (a.get(0) == ELEVE_ANNULEE 
					|| a.get(0) == PROF_VALIDEE
					|| a.get(0) == PROF_REFUSEE) {

				return true;
			}
		}

		else if (longueurListe == 2) {
			if (a.get(0) == ELEVE_MODIFIEE 
					|| a.get(0) == DATE_MODIFIEE 
					|| a.get(0) == DUREE_MODIFIEE
					|| a.get(0) == AP_MODIFIEE) {

				if (a.get(1) == ELEVE_ACCEPTEE 
						|| a.get(1) == ELEVE_REFUSE
						|| a.get(1) == ELEVE_ANNULEE) {

					return true;
				}
			}
		}

		else if (longueurListe == 3) {

			if (a.get(0) == ELEVE_MODIFIEE) {

				if (a.get(1) == DATE_MODIFIEE 
						|| a.get(1) == DUREE_MODIFIEE
						|| a.get(1) == AP_MODIFIEE) {

					if (a.get(2) == ELEVE_ACCEPTEE 
							|| a.get(2) == ELEVE_REFUSE) {

						return true;
					}
				}
			}
		}
		
		return false;
	}

	public ArrayList<Integer> chargement() {

		return liste;
	}

	@Override
	public String toString() {
		return "DemandeConsoTempsAccPers [id=" + id + ", anneeScolaire="
				+ anneeScolaire + ", dateAction=" + dateAction + ", minutes="
				+ minutes + ", prof=" + prof + ", accPers=" + accPers
				+ ", eleve=" + eleve + ", etat=" + etat + "]";
	}
}
