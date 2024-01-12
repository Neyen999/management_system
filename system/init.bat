rmdir /S /Q db_data
REM elimina las imagenes
docker-compose down --rmi local
REM reconstruye las imagenes
docker-compose build --no-cache
REM levanta el docker y fuerza la creacion de los contenedores
docker-compose up --force-recreate