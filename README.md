# soundfolio

_Your personal music journal — log, rate, and reflect on the songs that shaped your mood._

**Soundfolio** is a fullstack web application that helps you catalog and revisit the music that meant something to you. Think of it as your own music diary meets greatest hits archive. You can log songs with ratings, reviews, vibes, and even fetch album art and metadata from external sources like iTunes or Spotify.

---

## Tech Stack

| Layer      | Technology                       |
|------------|----------------------------------|
| Backend    | Java, Spring Boot, Spring MVC    |
| Database   | PostgreSQL (or H2 for dev)       |
| ORM        | Spring Data JPA, Hibernate       |
| API Client | RestTemplate / WebClient         |
| Frontend   | React or Thymeleaf (plug-and-play) |
| Extras     | Lombok, Validation, DevTools     |

---

## Features

- Search & fetch songs  
  Enter a title and artist to pull in album info and cover art.

- Rate your favorites  
  Give 1–5 star ratings (including half-star increments).

- Write journal entries  
  Reflect on why a song hit — write as much or as little as you want.

- Tag with “vibes”  
  Use vibe tags like chill, nostalgic, rage, ethereal, etc.

- Filter by mood or rating  
  Easily find songs based on vibe, rating, or date.

- Private or public entries (future-ready)  
  Mark personal reviews as private if needed.

---

## Project Structure

src/
└── main/
└── java/com/example/soundfolio/
├── controller/
├── service/
├── model/
├── repository/
├── dto/
└── config/

yaml
Copy
Edit

---

## Key Concepts Demonstrated

- MVC architecture with clear layering
- Use of Java Beans (`@Component`, `@Service`, `@Repository`)
- REST API design (GET, POST, PUT, DELETE)
- Dependency injection and inversion of control
- JPA entity modeling and relationships
- External API integration
- Data validation and DTO mapping

---

## Running Locally

1. Clone the repo:
   git clone https://github.com/yourusername/soundfolio.git
   cd soundfolio

markdown
Copy
Edit

2. Open in your IDE of choice

3. Run the app:
   ./mvnw spring-boot:run

yaml
Copy
Edit

4. Access at:
   `http://localhost:8080`

---

## License

MIT – feel free to fork, remix, and build on top of it.

---

## Future Features

- User authentication
- Spotify OAuth integration
- Public journal sharing
- "Year in Review" playlist export