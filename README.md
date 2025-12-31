1. I used Java version 21
2. How to run
   1. mvn clean install -Dmaven.test.skip=true -T 15
   2. Environment Variables:
      CONNECTION_TIMEOUT=30000
      IDLE_TIMEOUT=30000
      MAX_LIFETIME=2000000
      MIN_IDLE=1
      MYSQL_DB=app_user
      MYSQL_HOST=localhost
      MYSQL_PASSWORD=arafinN
      MYSQL_PORT=3306
      MYSQL_USER=root
      POOL_SIZE=15
3. Browse URL: http://localhost:8080/swagger-ui/index.html
