FROM mysql:8.0.32

ARG MYSQL_ROOT_PASS

# ${MYSQL_ROOT_PASS}
ENV MYSQL_ROOT_PASSWORD=root 

EXPOSE 3306

COPY schema.sql /docker-entrypoint-initdb.d
