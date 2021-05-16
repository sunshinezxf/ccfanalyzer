date
echo '--------------------stop last ccf---------------------'
docker stop ccf
docker container prune -f
echo '--------------------remove image ---------------------'
docker image rm -f ccf:v1.0
docker image prune -f
echo '------------------build new image---------------------'
docker build -t ccf:v1.0 .
echo '---------------------docker run ----------------------'
docker run -d --name ccf -p 8080:8080 ccf:v1.0 
