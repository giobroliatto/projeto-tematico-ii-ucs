<div align="center">

<img src="docs/icon.svg" width="72" alt="Sportify logo" />

# Sportify

**Desktop app for organizing knockout tournaments, built with Java Swing, Hibernate and PostgreSQL.**

![Java](https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-5382A1?logo=openjdk&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?logo=hibernate&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?logo=postgresql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apachemaven&logoColor=white)

</div>

**English** · [Português](README.pt-BR.md)

> [!NOTE]
> Built as a team for the **Projeto Temático II** course at the [Universidade de Caxias do Sul](https://www.ucs.br/) (UCS) in 2023. The UI and code are in Portuguese.

![Sportify bracket view for a 16-team event, with winners highlighted in green](docs/bracket.png)

---

## About

Sportify helps organize sports tournaments in a single-elimination format. You register teams and events, link the teams to an event, and the system draws the bracket. As results are entered, winners advance round by round until the final.

## Features

- **Teams:** create, list, edit and remove.
- **Events:** name, venue, sport, start and end dates, and number of teams (2, 4, 8 or 16).
- **Linking teams to events,** with the number of teams the event expects.
- **Bracket draw:** teams are shuffled and paired up, and the first matches are created in the right round (round of 16, quarterfinals, semifinals or final, depending on the event size).
- **Results:** scores are entered match by match, draws are rejected, and once a pair of matches is decided the next-round match is created automatically.
- **Bracket view** showing every round of the event.

<table>
<tr>
<td width="33%" align="center"><img src="docs/menu.png" alt="Main menu" /><p><sub>Main menu</sub></p></td>
<td width="33%" align="center"><img src="docs/new-event.png" alt="Creating an event" /><p><sub>Creating an event</sub></p></td>
<td width="33%" align="center"><img src="docs/match-result.png" alt="Entering a match result" /><p><sub>Entering a match result</sub></p></td>
</tr>
</table>

## Architecture

The app follows an **MVC** split with a data access layer:

```
view (Swing)  →  controller  →  DAO  →  Hibernate  →  PostgreSQL
                     ↑
                   model (JPA entities)
```

- **model:** JPA entities (`Equipe`, `Evento`, `EquipeEvento`, `Partida`, `Chave`) mapped with annotations.
- **dao:** queries and persistence with a Hibernate `Session`.
- **controller:** business rules, like the bracket draw and advancing winners.
- **view:** Swing forms and dialogs, plus custom `TableModel`s and a `ButtonRenderer` for action buttons inside the tables.

## Stack

| Layer | Technologies |
|---|---|
| Interface | Java Swing |
| Persistence | Hibernate 5 (JPA), PostgreSQL |
| Build | Maven |

## Running locally

Requirements: JDK 11+, Maven and PostgreSQL.

```bash
git clone https://github.com/giobroliatto/sportify.git
cd sportify

# Create the database, the tables and sample data
createdb sportify
psql -d sportify -f postgresql.sql
```

Set your PostgreSQL user and password in [`src/main/resources/hibernate.cfg.xml`](src/main/resources/hibernate.cfg.xml), then run the `com.sportify.Main` class from your IDE, or:

```bash
mvn compile exec:java -Dexec.mainClass=com.sportify.Main
```

## Structure

```
src/main/java/com/sportify/
├── Main.java          # Opens the Hibernate session and the main menu
├── model/             # JPA entities
├── dao/               # Data access
├── controller/        # Business rules
├── dto/
├── tableModel/        # Table models for Swing
├── util/              # HibernateUtil, component factory, ButtonRenderer
└── view/              # Forms, listings, bracket and results
postgresql.sql         # Database schema
```

---

## Authors

Made by **Giovani Broliatto** and **Eduardo Marcon**.

[![LinkedIn](https://img.shields.io/badge/LinkedIn-giobroliatto-0A66C2?logo=linkedin&logoColor=white)](https://www.linkedin.com/in/giobroliatto/)
