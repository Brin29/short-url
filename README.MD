# 🔗 Spring Boot URL Shortener with Bitly, Redis & Docker

This project is a backend application developed with Spring Boot that allows shortening URLs using the Bitly API, caching results in Redis, and is ready for deployment with Docker.

## 🚀 Features

- Shorten URLs using the official Bitly API.
- Caching with Redis for improved performance.
- Modular and easily extensible architecture.
- Dockerized for quick execution and deployment.
- Configurable environment variables.

---

## 📦 Technologies

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Redis](https://redis.io/)
- [Bitly API](https://dev.bitly.com/)
- [Docker](https://www.docker.com/)
- [Lombok](https://projectlombok.org/)
- [Spring Data Redis](https://spring.io/projects/spring-data-redis)

---

## ⚙️ Environment Setup

### 1. Clone the repository

```bash
    git clone https://github.com/tuusuario/url-shortener-springboot.git
    cd url-shortener-springboot
```

### 2.  Environment Variables

- Configure you environment variables

```bash
    BITLY_API_KEY=your_bitly_api_key  
    REDIS_HOST=redis  
    REDIS_PORT=6379
    USERNAME=your username
    PASSWORD=your_password
```

### 3. Build and Run with Docker

```bash
  docker-compose up --build  
```


### 📄 4. API Endpoints

- POST=/api/url
- GET=/api/url/{id}
- GET=/api/url
- PUT=/api/url/{id}
- DELETE=/api/url/{id}

### 📝 5. LICENSE

- This project is licensed under the MIT License. 