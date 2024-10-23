<h1 align="center">Progetto Partita_Pallavolo</h1>

<p align="center" style="font-family: monospace">Alessandro Stefanucci <a href="https://github.com/LaggoSeeingo">@LaggoSeeingo</a></p>

## Scopo del Progetto
Si deve realizzare un’applicazione Java multithreading che consenta di simulare una partita di tennis o di pallavolo in cui ogni giocatore dopo aver fatto un passaggio all’avversario, incrementa il numero dei suoi passaggi o palleggi comunicando il suo codice e il numero di passaggi/palleggi effettuato.
All’inizio di ogni partita ogni giocatore comunica i propri dati (id, nome, priorità).”


## Metodi e Attributi della Classe Thread Utilizzati

### Metodi
- `start()`: Avvia il thread
- `join()`: Attende il thread dei giocatori prima di terminare la partita
- `interrupt()`: Utilizzato per gestire l'interruzione dei thread in caso di errori
- `currentThread()`: Ottiene il riferimento al thread corrente durante la gestione delle interruzioni

### Attributi
- `Priority`: Impostato a 10 per entrambi i giocatori usando `setPriority(10)`

## Metodi e Attributi della Classe Object Utilizzati

### Metodi di Sincronizzazione
- `wait()`: Utilizzato nell'arbitro per far attendere il giocatore il proprio turno
- `notifyAll()`: Utilizzato per notificare tutti i thread in attesa quando:
  - Un giocatore termina il proprio turno
  - La partita è terminata

## Importanza della Classe Arbitro

La classe Arbitro è fondamentale per:

1. **Gestione della Risorsa Condivisa**
   - Mantiene lo stato della partita (`fine`)
   - Tiene traccia del turno corrente (`turnoGiocatore`)
   - Definisce il punteggio di vittoria (`VITTORIA = 25`)

2. **Sincronizzazione**
   - Tutti i metodi critici sono dichiarati `synchronized` per garantire l'accesso thread-safe
   - `attendiTurno()`: Blocca i giocatori fino al loro turno
   - `passaTurno()`: Gestisce il cambio di turno tra i giocatori
   - `assegnaPunto()`: Gestisce i punti e verifica la vittoria

3. **Coordinamento**
   - Previene condizioni di race condition nell'accesso ai dati condivisi
   - Garantisce l'alternanza dei turni tra i giocatori
   - Gestisce la terminazione ordinata della partita

## Commento dell'Esecuzione

1. **Inizializzazione**
   - Viene creato un oggetto Arbitro
   - Vengono creati due oggetti Giocatore e i relativi thread
   - Entrambi i thread vengono avviati con priorità massima

2. **Svolgimento della Partita**
   - I giocatori si alternano nei turni
   - Ad ogni turno, un giocatore ha il 50% di probabilità di segnare un punto
   - Il punteggio viene visualizzato dopo ogni turno

3. **Terminazione**
   - La partita termina quando un giocatore raggiunge 25 punti
   - L'arbitro notifica tutti i thread della fine della partita
   - Il programma attende il completamento di entrambi i thread prima di terminare

4. **Gestione degli Errori**
   - Il programma include gestione delle interruzioni e delle eccezioni
   - In caso di errori, la partita viene terminata in modo controllato