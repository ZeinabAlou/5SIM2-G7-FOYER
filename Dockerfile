# Utiliser une image de base Java
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR de l'application
COPY target/Foyer-0.0.1-SNAPSHOT.jar Foyer.jar

# Exposer le port sur lequel l'application va fonctionner
EXPOSE 8080

# Commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "Foyer.jar"]
