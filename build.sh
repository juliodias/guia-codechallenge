echo "Building gradle application..."
./gradlew build

echo "Generating docker image from application..."
docker build -t juliodias/guia-codechallenge .

echo "Running application.."
docker run -p 8080:8080 juliodias/guia-codechallenge