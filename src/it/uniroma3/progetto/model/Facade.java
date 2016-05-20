package it.uniroma3.progetto.model;

import java.util.List;

public class Facade {
	
	public Facade() {}
	
	public void creaEsame(Esame esame) {
		// pre-condizioni: l'esame non è presente nel database
//		EsameDaoJDBC esameDao = new EsameDaoJDBC();
//		esameDao.save(esame);
	}
	
	public void creaTipologiaEsame() {
		// pre-condizioni: la tipologia esame non è presente nel database
//		TipologiaEsameJDBC tipologiaEsameDao = new TipologiaEsameDaoJDBC();
//		tipologiaEsameDao.save(tipologiaEsame);
	}
	
	public void inserisciRisultatoEsame(RisultatoEsame risultatoEsame) {
		//EsameDaoJDBC = new EsameDaoJDBC();
		//Esame esame = esameDao.findByPrimaryKey(esame.getIdEsame());
		//List<RigaEsame> risultatiEsame = esame.getRigheEsame();
		
		// itero risultatiEsame fino a che non trovo riga libera;
		// una volta trovata, aggiungo il risultatoEsame (set);
	}
}
