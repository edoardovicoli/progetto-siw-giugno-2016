##Specifiche
Si vuole realizzare un sistema informativo su Web per la **prenotazione degli esami medici di una piccola clinica.**
Oltre agli utenti occasionali, due tipologie di attori interagiscono con il sistema: i **pazienti** e l'**amministrazione**
Un **paziente** può svolgere le seguenti operazioni (è possibile introdurne altre):
* Consultazione tipologie di esami offerti dalle clinica
* Consultazione dei risultati di un proprio esame
L'**amministrazione** può svolgere le seguenti operazioni:
* Inserimento di una tipologia di esame 
* Inserimento di un esame
* Inserimento di un paziente nella anagrafica pazienti
* Inserimento risultati di un esame

Per ogni tipologia di esame sono di interesse un nome, un codice, una descrizione, un costo
Ogni tipologia di esame ha inoltre un insieme di prerequisiti che (per semplicità) sono rappresentati da un insieme coppie nome valore 
esempio prerequisiti
* {<"digiuno 12", "il paziente deve essere a digiuno da dodici ore">, <"no pregnant", "paziente non può essere una donna in gravidanza">}
(Per semplicità) ogni tipologia di esame ha un insieme di indicatori per i risultati
esempio risultati per la tipologia "esame del sangue"
* {"emoglobina", "colesterolo LDL",etc.}
Per ogni esame è necessario riportare, oltre al paziente, la data di prenotazione (con data e ora in cui è stata effettuata la prenotazione), la data in cui è stato effettuato l'esame, il nome del medico che ha condotto l'esame
Per ogni medico è necessario gestire: nome, cognome, specializzazione
(Per semplicità) i risultati di un esame sono un insieme di coppie nome-valore
esempio risultati
* {<"emoglobina",, "16 g/100 ml">, <"colesterolo LDL", "180">}

Segue una bozza dei principali casi d'uso
I casi d'uso dovranno essere estesi e completati a piacere (giustificando ogni scelta)
NB: *ipotizziamo che i pagamenti vengano gestiti off-line*
