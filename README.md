# Gestione Offerte di Lavoro

web application realizzata per  la gestione delle offerte di lavoro e le candidature.  
L'applicazione permette all'azienda di pubblicare, visualizzare e gestire le proprie offerte, mentre i lavoratori possono candidarsi, visualizzare le proprie informazioni e aggiornare i propri dati personali.



## 🚀 Funzionalità Principali

- **Registrazione e Login**  
  - Gestione degli accessi tramite Spring Security.  
  - Due tipologie di utenti: Lavoratore e Azienda.

- **Gestione Utenti**  
  - Registrazione con validazione dell’email.
  - Area personale per aggiornare i dati.

- **Gestione Offerte di Lavoro**  
  - Pubblicazione, modifica ed eliminazione delle offerte di lavoro.
  - Visualizzazione delle offerte attive.
  - Visualizzazione di un calendario degli eventi correlato alle offerte.
  - Visualizzazione anangrafica di utenti registrati.

- **Gestione Candidature**  
  - Invio candidature da parte dei lavoratori per le offerte.
  - Visualizzazione delle candidature da parte delle aziende.
  


## 💻 Linguaggi e Tecnologie Utilizzate

- **Backend:**  
  - **Java** con **Spring Boot** e **Spring Security**
  - **Spring Data JPA** per l'interazione con il database

- **Frontend:**  
  - **HTML5** e **CSS3**

- **Database:**  
  - MySQL 
- **Strumenti di Sviluppo:**  
  - **Maven** per la gestione delle dipendenze
  - **IDE Eclipse**
    


## 📂 Struttura del Progetto

```bash
gestionale-lavoro/
│
├── src/
│   ├── main/
│   │   ├── java/it/bicocca/progetto/gestionale/
│   │   │   ├── config/          # Configurazioni Spring e Security
│   │   │   ├── controller/      # Controller MVC per le varie rotte (aziende, utenti, candidature, offerte)
│   │   │   ├── model/           # Entità JPA: User, Azienda, OffertaDiLavoro, Candidatura
│   │   │   ├── repository/      # Repository per l'accesso ai dati
│   │   │   └── service/         # Logica di business 
│   │   ├── resources/
│   │   │   ├── static/          # File statici (CSS, immagini, JS)
│   │   │   ├── templates/       # Pagine HTML 
│   │   │   └── application.properties  # Configurazione dell'applicazione e del database
│   └── test/                    # Test (non implementati)
│
├── pom.xml                      # Gestione delle dipendenze Maven
└── README.md                    # Documentazione del progetto
```



## 🛠 Utilizzo dell'Applicazione

- **Homepage e Login:**  
  Visita [http://localhost:8080](http://localhost:8080) per visualizzare il sito vetrina.  
  Gli utenti possono accedere o registrarsi tramite le pagine dedicate.

- **Area Lavoratore:**  
  Dopo il login, il lavoratore può visualizzare le offerte, candidarsi e aggiornare i propri dati nell'area personale.

- **Area Azienda:**  
  Le aziende possono accedere a un pannello dedicato dove creare, visualizzare ed eliminare offerte di lavoro.  
  Inoltre, possono consultare le candidature ricevute e visualizzare le informazioni anagrafiche degli utenti.

## 🔧 Come Avviare il Progetto
1. Clonare il Repository
Apri il terminale e clona il repository:

```bash
git clone https://github.com/tuo-username/gestionale-lavoro.git
cd gestionale-lavoro 
```

2. Configurare il Database
Modifica il file application.properties (src/main/resources/) per impostare le credenziali del database (ovviamente dopo averne creato uno).

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/...
spring.datasource.username=...
spring.datasource.password=...
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
```

Utilizza Maven per eseguire l'applicazione:
```bash
mvn spring-boot:run
``` 
note: in particolare ogni registrazione da accesso come "lavoratore" quindi sarà l'utilizzatore a dover modificare nel database cambiando il ruolo per poter accedere all'area dell'azienda.

## 📩 Contatti

- **Email:** d.bonfanti13@campus.unimib.it
