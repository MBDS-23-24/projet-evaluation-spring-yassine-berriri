[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/9_zvHx4K)

# Examen Spring Boot 22/03/2024

  Ce projet est conçu suivant une architecture de microservices, implémentant deux services principaux : SKILL et POSITION. Il s'agit d'un système pour gérer les postes informatiques et leurs compétences associées, en utilisant Spring Boot et divers outils et pratiques recommandés dans le développement moderne de microservices.

###  Architecture et Conception

Le projet est structuré en deux microservices, chacun ayant sa propre responsabilité, conformément aux principes de l'architecture microservices. Les services communiquent entre eux via OpenFeign pour une intégration transparente.

### Services

- Service Skill: Consulter les informations relatives aux compétences.
- Service Position: Consulter les positions/postes et les compétences de chaque poste.

### Caractéristiques techniques

- OpenFeign pour la communication entre services.
- Spring Cloud Gateway pour le routage des requêtes.
- Eureka Discovery Service pour la découverte de services.
- Circuit Breaker pour la tolérance aux pannes.
- Spring Config pour la gestion centralisée de la configuration.

### Bonnes Pratiques de Développement

Le projet suit les bonnes pratiques recommandées pour le développement de microservices, y compris :

- Utilisation de DTOs (Data Transfer Objects) pour les transferts de données entre services.
- Utilisation de Mappers pour convertir entre les entités et les DTOs, assurant une séparation claire entre la logique de l'application et la couche de persistance.
- Lombok pour réduire le boilerplate code grâce à ses annotations pour les getters, setters, constructeurs.

  
