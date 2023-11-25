# Hello Langchain4J

Sample project to start using the power of Langchain for Java!

## Requirements
- Java 17
- Maven 3
- OpenAI account

## Usage

1. Create a copy of `.env.example` and rename to `.env`
2. Fill the `.env` file with the OpenAI API token and organization ID
3. Export `.env` file to make env vars available:
```bash
export $(cat .env | xargs)
```
4. Build the application from the source code:
```bash
./mvnw clean package
```
5. Run the HelloBot example:
```bash
./mvnw exec:java -D'exec.mainClass=com.yugoccp.example.HelloBot'
```

6. Or run the EmojiBot example:
```bash
./mvnw exec:java -D'exec.mainClass=com.yugoccp.example.EmojiBot'
```

## Reference
